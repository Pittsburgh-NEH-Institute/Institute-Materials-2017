# Command line 1
____

## General

* **References:** Much of the content of these sessions is summarized at our [Command line quick reference](command-line_resources.md) page.
* **Etherpad:** We’ll create an [Etherpad](https://etherpad.net) where participants who wish to do so can take notes collaboratively. For a quick overview of Etherpad functionality see <http://write.flossmanuals.net/etherpad/introduction/>.

## Why and how do we use the shell?

* The shell is a program that runs other programs.
* We use the shell to interact with the computer on the command line (CLI ~ GUI).
* The Unix philosophy is that you can _pipe_ (chain) together small commands, each of which does one thing well, to do something complex. You can’t do this in a GUI.
* bash = ‘Bourne again shell’ (the original Bourne shell is sh; others include csh, ksh, tcsh, zsh).
* Learn the shell on a need-to-know basis.

## Launching the shell

* For Mac OS X: the **Terminal.app** that you will find in the Applications → Utilities folder. (Many Mac users prefer the free third-party <https://www.iterm2.com/>.)
* For Windows: Although **cmd.exe** is the traditional Windows shell, and you may even have used it previously, we recommend **bash**. When you download Git, you'll also download **Git bash**, the command line interface we use and recommend. (We do not recommend the Windows 10 “Ubuntu in Windows”.)
* For Ubuntu Desktop (Unity): you can hit Ctrl-Alt-T or you can type `Terminal` into the Search box.

## Looking around

cd (no argument)
whoami
pwd
mycommand (non-existent)
clear (Ctrl+l)

Change to your home directory, look at it with pwd.

cd ~
cd ..
cd -
cd; cd Desktop
cd data-shell/data/s... (tab completion)
cd /Users/djb/Desktop/data-shell/data (absolute path)

Change to Desktop/data-shell

ls -F
ls -j (unsuppored)
man ls
ls
ls data

Dragging a file from your filesystem Finder/Explorer window to the terminal

## `ls` switches

* `ls -a`: include hidden files (filenames starting with `.`)
* `ls -l`: show enhanced file information, including date and time stamps, owner and group, permissions
* `ls -t`: list in timestamp order
* `ls -G`: colored output
* `ls -lh`: human readable file size

## History and completion

* Command and filename completion with the `Tab` key
* Command history with the arrow keys

## Interim summary

* The file system is responsible for managing information on the disk.
* Information is stored in files, which are stored in directories (folders).
* Directories can also store other directories, which forms a directory tree.
* `cd path` changes the current working directory.
* `ls path` prints a listing of a specific file or directory; `ls` on its own lists the current working directory.
* `pwd` prints the user’s current working directory.
* `whoami` shows the user’s current identity.
* `/` on its own is the root directory of the whole file system.
* A relative path specifies a location starting from the current location.
* An absolute path specifies a location from the root of the file system.
* Directory names in a path are separated with ‘/’ on Unix (including Mac OS)
* `..` means ‘the parent directory = the directory above the current one’
* `.` on its own means ‘the current directory’. Why would we need this?
* Most filenames have conventional extensions: `.txt`, `.xml`, etc.
* Most commands take options (flags) which begin with a `-`.

RESUME HERE

### Working with directories

[10 mins]

* `mkdir`: make directory.
<!--Use `pwd` to make sure you're still in your Documents directory, then `ls -a` to see all the directories currently inside it. We'll use `mkdir` to create a new folder called sample: `mkdir sample`. Once you've done this, check to see it's there using `ls -a`.-->
* `rmdir`: remove empty directory.
<!--Now that we've created an empty directory, we can use `rmdir sample` to get rid of it. Of course, we actually do want to have that directory, so make a new one called salutations: `mkdir salutations`.-->
* `rm -rf:` remove directory and its contents recursively (careful!).
<!--We won't use this one yet, as our directory has no files. However, you should note that `rmdir` will only remove an empty directory, while this command will loop over the directory and remove its contents before removing the directory itself. We caution you to be careful with it, as you can accidentally remove significant files or lose important work.-->

### Working with files

[15 mins]

* `cp`: copy
<!--This copies a file to another location. This command takes two arguments: the file or directory you're trying to copy, and the location to which you want to copy. This can be an entirely new file name, and you don't have to create the file ahead of time. You can accidentally overwrite data if you aren't careful about where you're copying to. For now, we're going to copy our greeting file into our salutations directory using `cp greetings.txt ./Salutations`. This creates a copy of the file inside the directory. Notice that we use a `.` to show the current directory. This is a relative path, meaning it is dependent upon the current context to know where we want to copy the file. Use `ls` to look at your Documents directory. greeting.txt is still there, unchanged. Navigate into your Salutations directory and list its contents. You have another greeting.txt file there as well, and if you echo it to stdout, you see it contains the same text as the original. Note that you've just made a copy, not a link, so any changes you make to one will not be reflected in the other.--> 
* `mv`: move and rename
<!--Within your Salutations directory, use the `rm` command to get rid of the file you just copied in (`rm greeting.txt`). Then, move back into your Documents directory using `cd ..` and list all files. greeting.txt is still there, but let's move it and change its name. `mv` also takes two arguments: what you want to move, and where you want to move it to. Again, you can accidentally overwrite data, as moving a file to a specific filename will simply write over that file. To move our file, we'll use `mv greeting.txt ./Salutations/hello.txt`. Take a look around those two directories to see what has changed.-->
* `rm`: delete (careful!)
* `rm -i`: delete after asking permission
<!--These two have been addressed already, but the `-i` switch makes deleting interative. Before any file is deleted, the prompt asks you if you're sure, to which you can respond 'y' or 'n'. Though this seems like it may be a pain, it's particularly useful combined with the recursive `-rf` switch, as it will go through a directory and ask about each file.-->

### Getting around the file system

[5 mins]

* `cd -`: go back to the directory you came from
* `cd` or `cd ~`: go to your home directory
* `ctrl+r`: initiate history search
* `..`: parent directory
* `.`: current directory (Why might you need this?)
* `~`: home directory

### More useful commands

[5 mins, do an activity with one of them as they are review]

* `wc` (`-l` lines, `-w` words, `-c` characters)
* `cat` (you might have meant `less`)
* `less` (shows the file, but only one screen of it)
* `sort` (`-r` reverse, `-u` unique, `-g` numeric)
* `uniq` (only on sorted input)
* `head` (`-10`, or any other number)
* `tail` (`-10`, or any other number)
* `echo` (e.g., `echo $HOME`, `echo a*`)


## Monday, 2:00–3:30: Programs and files 1

### The hierarchical file system
<!-- note about Python versions for Mac-->
[5 mins (review)]

* `/`
* Directories are files, too
* `file`: filetype
* `/dev/null`: the black hole of the file system
* Finding the filesystem location of a file from the MacOS finder or Windows explorer
	* Mac: Drag the filename from a Finder windows and drop it in a terminal window to paste the path to the file. Or just view the filename by selecting the file and `cmd+i` (get info).
	* Windows: Drag the filename from File Explorer and drop it in the terminal window to paste the path.
	* Linux: ???

### Operating system conventions

[15 mins (review)]

* EOL: CR LF (Windows), LF (Unix); `dos2unix`; using the `file` command
* Path separator: `\` (Windows non-bash), `/` (Unix)
* Drive letter: `C:/Users` (Windows non-bash), `/c/Users` (Windows git bash), `/Users` (Unix: no drive letter)

### Files can have more than one name and live in more than one place

[10 mins]

* `ln plain_file_name link_name` (filenames and inodes).<!--Inodes introduce a little bit more complexity into our original idea of "what are files?" The reason we can change filenames is that inodes store the location and attribute information, so a file can exist in multiple places with different names, so long as it links back to that inode number. To view the inode numbers for your files, use `ls -i`.-->
* `ln -s directory_name link_name`
* Difference between hard links and sym links

### File ownership and permissions

[10 mins]

* `ls -l`
* user, group, other
* `chown` (You probably can’t change ownership on shared systems and don’t need to do it on your own machine. This command is useful if you install something incorrectly.)
* `chmod` (“644”, “664” for files; “755”, “775” for directories)

### Getting around the directory stack

[15 mins]

<!--to explain what this is and why and how it's used-->
* review of `cd` and `cd -`
* `pushd`
* `popd`
* `dirs -v` (verbose); `dirs -c` (clear)


### Character sets

[10 mins]

* Unicode, UTF-8, “legacy” character sets
* `file oldfile.txt`: information about file, including character set for text files (if it says “ASCII”, it’s also UTF-8)
* `iconv -f CP1251 -t UTF-8 oldfile.txt > newfile.txt`: convert `oldfile.txt` from CP1251 to UTF-8 and save result as `newfile.txt`
* `hexdump -C -n1000 filename` or `xxd filename`: show hex and character values for first 1000 characters of `filename`. Omit the `-n` switch to see the entire file.

### Aliases

[30 mins]

#### Why use aliases?

* Shortcuts. `alias saxon='java -Xmx4g -DentityExpansionLimit=500000 -jar /opt/saxon/saxon9he.jar'`: launch saxon by just typing its name
* Redefine command. `alias grep='grep --color=auto'`: `grep` should always return colored output
* Safety. `alias rm='rm -i'`: don’t delete files without asking for confirmation
* Getting around. `alias doc="cd ~/Documents"`: take me to my Documents folder

#### Aliases and `.bash_profile`

* Aliases you want to save go in ~/.bash\_profile. Aliases declared on the command line disappear when you close the terminal window. 
* After editing .bash\_profile, run `source .bash_profile` to make the changes active in your current shell
* To edit a file that begins with a dot, type `bbedit .bash_profile` (or `mate` if you’re using TextMate or `atom` if you’re using Atom), or open it from the MacOS Finder or Windows Explorer

#### Alias details

* Syntax: `alias ll='ls -l'`
* `alias`: list all aliases
* `type ll`: find out what `ll` is aliased to
* Windows users: `alias python='winpty python.exe'`

#### Sample alias declarations

* `alias ls='ls -G'` (colored output)
* `alias la='ls -aG'` (hidden files)
* `alias ll='ls -alG'` (long listing)
* `alias lt='ls -alGt'`(sort by date)
* `alias lh='ls -alGh'` (human-readable numbers)
* `alias grep='grep --color=auto'` (colored output)
* `alias saxon='java -Xmx4g -DentityExpansionLimit=500000 -jar /opt/saxon/saxon9he.jar'` (run the Saxon XSLT engine by typing just `saxon`)
* `alias ob='ssh -l moe -p 12345 myserver.org'` (type `ob` to log into myserver.org on port 12345 with username 'moe' using encryption)
* `alias myproject='cd /Users/djb/Dropbox/myproject'` (move to specified directory)

## Monday, 4:00–5:30: Review

### Close reading of error messages

[10 mins]

* Making things go wrong on purpose
* Errors without a message
* Google is your friend! 
* Complex answers on Stack Overflow can be adapted for smaller problems, but it takes some patience and troubleshooting.

### Documentation and man pages

[only 5 mins, as Windows users don’t have a man page]

* Regular expression documentation: <https://www.gnu.org/software/findutils/manual/html\_node/find\_html/egrep-regular-expression-syntax.html>

### An exercise in reading a man page

* Finding the information you want ([`cat`](http://man7.org/linux/man-pages/man1/cat.1.html), [`ls`](http://man7.org/linux/man-pages/man1/ls.1.html))
* Transferring the knowledge you’ve gained elsewhere 

### Review

[20 mins]

* The command line, file paths, an assortment of useful commands
* A very brief primer on the Internet
	* HTTP (HyperText Transfer Protocol)
	* `curl http://www.example.com` fetch the page at the specified URL and write it to stdout
* How these things crop up in developer idiom

### Project: install Mallet <http://mallet.cs.umass.edu/index.php>

[40 mins, with troubleshooting and some explanation of topic modeling]

Mallet is used for **topic modeling**, which you can learn about at <http://programminghistorian.org/lessons/topic-modeling-and-mallet>. For now, it’s an installation exercise, and not a lesson in topic modeling.

<!-- Don't show this; the point is for them to follow the website instructions
and ask for help when they need it!
1. download package and open it
1. `cd` to switch to home directory
1. edit `.bash_profile` to set environment variable `$MALLET_HOME` (Windows users: use `%` instead of `$` on Windows old style) to point to the mallet-directory
2. `source .bash_profile` makes your new environment variable available in the current session (otherwise `.bash_profile` is read only when you launch the terminal)
1. `cd` to main mallet directory
1. run `bin/mallet import-dir --input sample-data/web/ --output web.mallet`
1. you'll be asked to install the Java developers kit; do that
1. run the command again (don’t retype it; use your command history)
* if output is `Labels = sample-data/web/` (optionally with language suffixes like “de” or “en”, you’re done!

This is an exercise in running into problems and resolving them, not an exercise in showing how skilled you are! -->
<!--Still missing twenty mins-->

## Tuesday, 11:00–12:30: Command line 2

### Enhanced history

[10 mins]

<!--this will be a good way to review/reflect/field qs-->
* `!!`: rerun the last command
* `!command`: rerun the most recent command that begins with the word after the exclamation mark (that is, replace “command” with the name of the command)
* `!25`: rerun command #25 (get number with `history`; fine-tune as above for beginning of command, or with `history | grep stuff` to find all history items that include the string “stuff”)
* `!$`: plug in the last word token from the last command

### Wildcards (“globbing”; annoyingly different from regex) 

[10 mins]

<!--using forked week_1 subdirectory, use `grep` to explore files-->
* `*.xml ` (files ending in “.xml”)
<!--Ask the participants of times they think it might be useful to use globbing. Now that they have some experience with regex, the idea of wildcards isn't foreign. With which commands will you likely use wildcards?-->
* `*.x?l` (files ending in “.x” followed by any single letter followed by “l”, e.g., XML [xml], XSLT [xsl], XProc [xpl] files)
* `*.x[ms]l` (files ending in “.x” followed by “m” or “s” followed by “l”, e.g., XML and XSLT files, but not XProc)

### Reading from and writing to files

[10 mins, as half of this is just review]

* stdin, stdout, stderr
* `<`: input from file
* `>`: output to file (overwrites existing files with the same name)
* `>>`: append to file (creates file if it doesn’t already exist)
* `2>`: error messages to file (`2> /dev/null`)

### Sending data through pipelines
<!--email Na-Rae about materials-->

[40 mins, with pipelining activity]

* `|`
* `history | tail`
* `wc filename` ~ `wc < filename` ~ `cat filename | wc`
* Why are there two backslashes in `history | grep \\.xml`?

### Shell variables

[15 mins, explaining how these work, when and when not to use them]

* `env | grep PATH`
* `$HOME`
* `$PATH`

### Quotes and the shell

[5 mins]

* Quotes can get you out of a white-space pickle (`cat 'stupid filename with spaces'`)
* Or you can “escape” the space by preceding it with a backslash (`cat stupid\ filename\ with\ spaces`)
* Quotes or backslash also escape other special characters (`cat 'download.txt(1)'` or `cat download.txt\(1\)`)
* Single quotes are literal (`echo '$HOME'`)
* Double quotes expand variables (`echo "$HOME"`)

### Useful command switches for `ls`

<!--review 5 mins, should we scrap?-->

* `-G`: colorize output
* `-a`: include hidden files
* `-f`: decorate filenames according to filetype
* `-l`: long listing
* `-d`: don’t recurse into directories
* `-t`: sort by time
* `-1`: single-column
* `ls -d */`: list only directories


## Tuesday, 2:00–3:30: Programs and files 2

### File formats

[10 mins]

* Unicode beyond UTF-8 (UTF-16, UCS-4)
* CSV and TSV (comma- and tab-separated values)

### The environment

[5 mins]

* `env`: show all environment variables
* `$PATH`: list of directories where the shell looks for executable files, starting at the beginning
* `echo $PATH`: show the value of the `$PATH` variable

### More about `$PATH`

[5 mins]

* Your working directory is not automatically in your path. Why might that be the case? 
* To execute a file in the current directory, specify the directory as part of the command, e.g., `./command` runs a command called `command` that’s located in the current working directory.

### Finding commands and files

[10 mins]

* `help`: list all shell built-ins
* `which`: search `$PATH`, one result (the one that will be executed if you type the command), not for shell built-ins or aliases
* `whereis`: search standard locations, multiple results, not for shell built-ins or aliases
* `find / -name java -print 2> /dev/null`: find all files named `java` starting at the file system root, not for shell built-ins or aliases
* `type`: includes shell built-ins and aliases!

### Web technologies

[60 mins]

* HTML
* CSS
* JavaScript
* PHP, CMS and framework

### Markdown

[30 min]

* [Markdown](https://github.com/adam-p/markdown-here/wiki/Markdown-Cheatsheet)
* [Pandoc](http://pandoc.org/)

### Connecting to remote systems

[5 mins]

* Interactive command line: if available, use `ssh`, not `telnet`
* File-transfer command line: if available, use `sftp`, not `ftp`

### Repeating things and variables

[20 mins]

Declare a variable with just it’s name, but refer to it with a leading `$`. Example: `for file in *.txt; do wc -l $file; done`. The preceding declares a variable called `file`, which will be equal to all files in the current directory that end in “.txt” and then reports the number of lines in each. 

In the first example below `%` removes a matching string at the end of the filename. These commands make copies, but if you replace `cp` with `mv`, they rename files.

* `for file in *.txt; do cp ${file%txt}bak; done` replace “.txt” extension with “.bak”
* `for file in *.txt; do cp $file $file.bak; done` keep “.txt”, but add “.bak” after it

### Misc

[5 mins]
* `diff`
* `locale`: view your locale

## Tuesday, 4:00–5:30: Review

### Text editors vs. word processors

* What word processor files look like
* What “non-programming” text editor files look like
* What happens when you try to use one (hint: it isn’t good!)

### There’s more than one shell

* `bash`: “the shell”
* `telnet`: open a command-line `telnet` session and show the `telnet>` shell prompt
* `python`: open a command-line `python` session and show the `>>>` prompt
* `bash` within `bash`: secondary shell prompt (e.g., `bash-3.2$)
* `echo $SHLVL`: shell level
* `bash` commands don’t work in non-bash shells
* `help`: help information (including how to exit)
* `ctrl-d`: quit the current shell and return to the one that launched it (typically bash)

## Wednesday, 11:00–12:30: Command line 3

### Advanced `grep`

#### Useful command switches for `grep`

* `-E`: extended regex (supports `{` metacharacter, wrap double quotes around regex)
* `-w`: whole words (put phrases in single or double quotation marks)
* `-i`: case insensitive
* `-l`: filenames but not text
* `-v`: lines that don’t match (“invert” the search)
* `-n`: include line numbers in output
* `-c`: count of matching lines
* `-s`: silent mode (suppresses error messages)

#### `grep` and regex

`grep` searches for a _regex pattern_, and not just a string. so:

* `grep ^To: *`: the line begins with the string “To” (a caret at the beginning of a regex means ‘match only at the beginning of a line’)
* `grep ^.o *`: the second letter of the line is an “o” (a dot in regex matches any single character except a newline)
* `grep ing$ *`: the line ends in “ing” (a dollar sign at the end of a regex means ‘match only at the end of a line’)

#### `grep` complications

* Variables (begin with a dollar sign) and regex metacharacters (e.g., asterisk) are resolved in double quotation marks and treated as literal strings in single quotation marks
* Spaces: precede with a backslash or put the entire regex in quotation marks
* Variables: put the entire regex in double quotation marks 
* Quotes: single quotes are okay inside double quotes and vice versa
* Hyphens: `grep -l stuff` looks like an incomplete attempt to search for the string “stuff” and return only the filenames—incomplete because you haven’t specified where to look. If you want to search a file called `stuff` for the string `-l`, use `--` to tell `grep` that nothing that follows is a switch: `grep -- -l stuff`. Otherwise anything that begins with a hypen will look like a switch.


### Shell scripts

* See SW Carpentry

### Editing the command line

* Up-arrow recalls the last command (or keep going, or go forward after you go back)
* `ctrl+r` and start typing seaches for substring matches in the history; keep typing `ctrl+r` to cycle through the matches
* `left-arrow` and `right-arrow` move the cursor through the line
* `ctrl+a` go to the beginning of the line
* `ctrl+e` go to the end of the line
* `ctrl+u` erase everything from the cursor until the beginning of the line
* `ctrl+c` abort whatever you’re doing and return to a new command line
* `Opt+click` anywhere in the line to move the cursor (MacOS only)
* Careful: `ctrl+d` exit the shell and close the terminal window
____
**Credit:** Command line, programs, and files tutorials used in the NEH Institute are partially derived from materials made available by [Software Carpentry](http://software-carpentry.org) under a [CC-BY 4.0 license](https://creativecommons.org/licenses/by/4.0/). 


