# Command line 3

## Working with files

### Review

* `cp`: copy
	* `cp oldfile newfile` copy a file
	* `cp oldfile1 oldfile2 newdirectory`: copy multiple files

### New

* `cp olddirectory newdirectory`: eek!
* `cp -r olddirectory newdirectory`: copy directory recursively, but the result depends on whether `newdirectory` exists
* `mv`: rename / move
	* `mv oldfile.txt newfile.txt`: rename a file
	* `mv oldfile.txt newdirectory`: move a file, keeping the name
	* `mv oldfile.txt newdirectory/newfile.txt`: move a file, changing the name
	* `mv olddirectory newdirectory`: result depends on whether `newdirectory` exists

## Looping with `for`

### `for` syntax

* `for file in *; do echo -n "$file: "; head -1 $file; done` (in `data-shell/molecules`)

### A job for `for`

* Copy a bunch of files and rename them
	* You can keep the names if you copy to a different directory
	* You have to give new names to copy it to the current one
	* You need to rename each file separately, i.e., in a `for` loop
* Add a new extension, e.g., `file1.txt` → `file1.txt.bak`
* Change the extension, e.g., `file1.txt` → `file1.bak` 
	* cp $file ${file/txt/bak}
	* cp $file ${file%.txt}.bak 

For more information about substring removal, see <http://wiki.bash-hackers.org/syntax/pe#substring_removal> (including the section immediately below, subtitled “How the heck does that help to make my life easier?”).

## Finding things with `grep`

### Useful command switches for `grep`

* `-w`: whole words (put phrases in single or double quotation marks)
* `-i`: case insensitive
* `-l`: filenames but not text
* `-o`: output only the matching part of the line
* `-v`: lines that don’t match (“invert” the search)
* `-n`: include line numbers in output
* `-c`: count of matching lines
* `-s`: silent mode (suppresses error messages)
* `-r` or `-R`: recurse through directories
* `-E`: extended regex (supports `{` metacharacter, wrap double quotes around regex); same as `egrep`

### `grep` activity

In `data-shell/writing`, working with `haiku.txt`:

#### Matching strings

* Find lines that contain 'not'
* Find lines that contain 'the'
* Find lines that contain 'The' regardless of upper and lower case
* Find lines that contain 'The' as a word, but not as part of a word, regardless of upper and lower case
* Find lines that contain 'is not'
* Find lines that contain 'it' and return the line numbers
* Return a count of the lines that contain 'it' 

Leaving aside `haiku.txt` for the moment, find all files in the `writing` directory that contain 'the'. Compare:

* `grep the *`
* `grep -s the *`
* `grep the * 2> /dev/null`

Not every command as an `-s` switch. Inside `data-shell` try:

```bash
wc *
```

Leaving aside `haiku.txt` for the moment, find all filenames (not the lines in the files, just the names) in all files in the `writing` directory or its subdirectories that contain `the` (case-insensitive). The answer should be:

	data/LittleWomen.txt
	data/one.txt
	data/two.txt
	haiku.txt
	tools/format

Now get the count. The answer should be:

	data/LittleWomen.txt:8418
	data/one.txt:28
	data/two.txt:142
	haiku.txt:4
	old/.gitkeep:0
	thesis/empty-draft.md:0
	tools/format:1
	tools/old/oldtool:0
	tools/stats:0

Notice the files with 0 hits are included. We’ll get rid of those shortly.

#### Matching regex

`grep` searches for a _regex pattern_, and not just a string. so, in `haiku.txt`:

* Find lines with 'o' as the second letter
* Find lines ending in 'ing'
* Find geminate (doubled) letters (in this case, “ee” in “seen” and “ss” in “loss”).

#### Greedy and non-greedy matching

The task is to find all quoted text in data-shell/writing/data/LittleWomen.txt. Try:

```bash
grep -En --color '".*"' LittleWomen.txt
```

and scroll up to line 12378. What’s the problem? Regex matches are *greedy* by default; they prefer the longest possible match.

To fix it, make the match non-greedy with:

```bash
grep -En --color '".*?"' LittleWomen.txt
```

That doesn’t fix all the problems, though. Scroll up to line 15624; what’s the problem there? (It can’t be fixed in `grep`, but there are regex contexts that can deal with it.)

#### Inverting a search with `grep -v`

* `grep -iwn the data/one.txt`: find all lines that contain 'the' as a word, case-insensitive, and include the line numbers
* `grep -iwnv the data/one.txt`: find all lines that *don’t* contain 'the' as a word, case-insensitive, and include the line numbers

Previously we ran: Find all filenames (not the lines in the files, just the names) in all files in the `writing` directory or its subdirectories that contain `the` (case-insensitive). The result was:

	data/LittleWomen.txt:8418
	data/one.txt:28
	data/two.txt:142
	haiku.txt:4
	old/.gitkeep:0
	thesis/empty-draft.md:0
	tools/format:1
	tools/old/oldtool:0
	tools/stats:0

Now: Pipe this output into a second `grep` command to get rid of the lines that report zero hits.

#### `grep` complications

* Variables (begin with a dollar sign) and regex metacharacters (e.g., asterisk) are resolved in double quotation marks and treated as literal strings in single quotation marks
* Spaces: precede with a backslash or put the entire regex in quotation marks
* Variables: put the entire regex in double quotation marks 
* Quotes: single quotes are okay inside double quotes and vice versa
* Hyphens: `grep -l stuff` looks like an incomplete attempt to search for the string “stuff” and return only the filenames—incomplete because you haven’t specified where to look. If you want to search a file called `stuff` for the string `-l`, use `--` to tell `grep` that nothing that follows is a switch: `grep -- -l stuff`. Otherwise anything that begins with a hypen will look like a switch.

#### Sibling rivalry

* Move to the directory we care about: `cd ~/Desktop/data-shell/writing/data`
* Check what’s there: `ls -al`
* Look at the file: `less LittleWomen.txt` (note the annoying header and footer; we’ll ignore the clutter for now)
* The four sisters are: Jo, Meg, Beth, Amy
* Which is mentioned most often?

```bash
for sis in Jo Meg Beth Amy
do
	echo $sis:
	grep -ocw $sis LittleWomen.txt
done
```

## Finding files with `find`

`grep` finds lines that contain text. `find` finds files with *filenames* that match a string.

Warning: `find` is recursive. Run it at the top of your filesystem and it will look at every file = take a long time.

### Practice with `find`

Inside `writing`:

* `find .`: find all files
* `find . -type d`: find all directories
* `find . -type f`: find all regular files
* `find . -name *.txt`: why doesn’t it find the text files in the `data` directory? How do we fix this?

### Combining `find` with other commands

* `wc -l $(find . -name '*.txt')`
* `grep "FE" $(find .. -name '*.pdb')`

<!--
## Shell scripting

Adapt from [Linux tutorial](http://linuxcommand.org/lc3_writing_shell_scripts.php).
-->