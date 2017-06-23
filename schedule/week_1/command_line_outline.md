# Command line, programs, and files schedule
____

## Notes to developers (delete this section before publication)

Divide commands into introduction in one session and advanced in another. E.g., introduce `ls`, and perhaps the `-l` and `-a` switches first, and add other useful switches in a different session. This sneaks in review of the topic.

____

## General

* **Preliminaries:** If you haven’t done so already, complete preparation described at our [Before you arrive](before_you_arrive.md) page. 
* **References:** Much of the content of these sessions is summarized at our [Command line quick reference](command-line_resources.md) page.
* **Etherpad:** We’ll create an [Etherpad](https://etherpad.net) where participants who wish to do so can take notes collaboratively. For a quick overview of Etherpad functionality see <http://write.flossmanuals.net/etherpad/introduction/>.
____

## Monday, 9:00–11:30: Getting to know your OS: file and directory system

[Address with windows users: why we used git bash and not cmd, the basics of cmd and why they need to know them, CRLF issues (may be something we should wait on, it's weirdly specific), and drive letters.]
### Operating system conventions

### File system hierarchy 
<!--10 mins-->
* What are files?
* What are directories/repositories/folders?  Thinking about why we call them folders: a folder and a piece of paper are the same, and can do some of the same things.  A folder can also hold pieces of paper.
* What are programs?  Programs are files that can do something, but are still files nonetheless.  Take a piece of paper out of your folder, fold it into an airplane, and throw it.  It's still a piece of paper you can read from and write on, but it can fly.
* Organization of file hierarchy, moving around using File Explorer

### Hidden files and filename extensions
<!--15 mins-->
* Show Hidden Files for Windows: Control Panel-Appearance and Personalization-File Explorer Options-View-Select 'Display the full path in the title bar' AND 'Show hidden files, folders, and drives'.
* Show filename extensions for Windows: Open File Explorer, click the View tab at the top, select 'File name extensions' under the Show/hide tab.
* Why are some files hidden? If you change something, however small, in some of these files, you can break your computer.  Be careful!
* Case Sensitivity: Linux is case sensitive, meaning files with the same name but different capitalization are different files (ie finalpaper.txt is different than FinalPaper.txt).  Mac OS and Windows are case preserving, but by default not case sensitive.  This preference can be changed when configuring the filesystem, but certain programs will not run in a case sensitive environment.  

### Moving through a filesystem
<!--30 mins-->
* Navigate up and down, with emphasis on the paths in the title bar.  We should clarify that Git Bash will use forward slashes rather than backslashes, and explain later when we introduce cmd why that's the case.\
* Drive letter: `C:\Users` (Windows non-bash), `/c/Users` (Windows git bash), `/Users` (Unix: no drive letter).
* Open a command line and begin using `cd`.  Explain that `cd` is essentially the same as selecting or clicking a folder.  `cd` into your home directory.
* Use `ls` to show all the files in your home directory.  Compare that to what you now see in your home directory (or C drive "folder").
* Then use `cd Documents` to move into your documents folder.  This is a relative path, as you've navigated relative to where you've started.  Explain what an absolute path looks like, and try running one.

### Why and how do we use the shell?
<!--10 mins-->
* The shell is a program that runs other programs.
* We use the shell to interact with the computer on the command line (CLI ~ GUI).
* The Unix philosophy is that you can _pipe_ together small commands, each of which does one thing well, to do something complex. You can’t do this in a GUI.
* bash = ‘Bourne again shell’ (the original shell is sh; others include csh, ksh, tcsh, zsh). We use and recommend bash (Git Bash).  There are many different shells, some of which you end up downloading with program packages like Python.
* Learn the shell on a need-to-know basis. There are commands you’ll use every day, some you’ll use for special purposes (and you’ll look up how they work when you need them), and some that you’ll never need.

### Launching the shell
<!--5 mins-->
<!--Once you've fixed command-line_resources.md, add that here-->

### `cmd.exe` vs. Git Bash or other shells
<!--2 mins-->
* In the past, you may have used 'cmd.exe', Windows Powershell, or Bash on Ubuntu on Windows.  Though each has its own benefits and drawbacks, for the purposes of this course we will use Git Bash.

### `ls` switches
<!--15 mins-->
* `ls -a`
* `ls -l`
* `ls -g`
* `ls -t`
* `ls -h`
* `ls -ld`

## Monday, 11:00–12:30: Command line 1

### Getting oriented
<!--5 mins-->
* When you see `$` (shell prompt): the shell is waiting for you to provide input
* When you type `$`: you’re beginning to type a variable name (see below)
* When you see `>` (shell continuation prompt): you’ve started entering multiple-line input, and the shell is waiting for the next line
* When you type `>`: you’re writing output into a file, instead of displaying it on the screen (see below)
* If you type a command and find yourself on a blank line with nothing happening: you typed an incomplete command, and should abort it with `ctrl+c`

### First commands
<!--15 mins-->
* `cd`: change directory.  also `cd ..`, `cd ~`, <!--ADD SWITCHES and ARGUMENTS-->
* `pwd`: print working directory (current location in filesystem)
* `whoami`: print login id
* `clear`: clear the screen
* explain absolute vs. relative paths

### Explore your files
<!--20 mins-->
* `ls`: list files.  
* Use `cd` to navigate to the Documents folder.
* `echo`: echoes a string to standard out.  Using `echo`, create a file and redirect standard out to a file.
* `cat`: view and create files.  Use cd, ls, and switches to navigate into Documents folder and create a file using `cat`.
* `less`: see only one page of file 
* `grep`: searching the text of a file, just with absolute file names.

### Making things easier

* Command and filename completion with the Tab key
* History with the arrow keys
* RTFM with `man` (user manual) and git --help <!-- git \-\-help is the closest thing git bash has to a manual, and it really won't help if you're using git bash for things other than git-->
* To turn off case sensitive tab completion, create a file called .inputrc in your home directory.  In the file, write echo 'set completion-ignore-case On' and save.  The next time you open your bash shell, you should be able to use tab completion without 
### Working with files

* `cp`: copy
* `mv`: move and rename
* `rm`: delete (careful!)
* `rm -i`: delete after asking permission
* `touch`: update the date stamp of a file (create the file if it doesn’t already exist)

### Working with directories

* `mkdir`: make directory
* `rmdir`: remove empty directory
* `rm -rf:` remove directory and its contents recursively (careful!)


### Wildcards (“globbing”; annoyingly different from regex) 
<!-- this should probably make no mention of regex? At least until they know what that is? -->

* `*.xml ` (files ending in “.xml”)
* `*.x?l` (files ending in “.x” followed by any letter followed by “l”, e.g., XML [xml], XSLT [xsl], XProc [xpl] files)
* `*.x[ms]l` (files ending in “.x” followed by “m” or “s” followed by “l”, e.g., XML and XSLT files, but not XProc)


### Getting around the file system

* `cd -`: go back to the directory you came from
* `cd` or `cd ~`: go to your home directory
* `ctrl+r`: initiate history search
* `..`: parent directory
* `.`: current directory (Why might you need this?)
* `~`: home directory

### More useful commands

* `wc` (`-l` lines, `-w` words, `-c` characters)
* `cat` (you might have meant `less`)
* `less` (shows the file, but only one screen of it)
* `sort` (`-r` reverse, `-u` unique, `-g` numeric)
* `uniq` (only on sorted input)
* `head` (`-10`, or any other number)
* `tail` (`-10`, or any other number)
* `echo` (e.g., `echo $HOME`, `echo a*`)

### Enhanced history

* `!!`: rerun the last command
* `!command`: rerun the most recent command that begins with the word after the exclamation mark (that is, replace ”command” with the name of the command). 
* `!25`: rerun command #25 (get number with `history`; fine-tune as above for beginning of command, or with `history | grep stuff` to find all history items that include the string “stuff”)
* `!$`: plug in the last word token from the last command
<!-- end command line 1 lesson here?-->

### Reading from and writing to files

* stdin, stdout, stderr
* `<`: input from file
* `>`: output to file (overwrites existing files with the same name)
* `>>`: append to file (creates file if it doesn’t already exist)
* `2>`: error messages to file (`2> /dev/null`)

### Sending data through pipelines

* `|`
* `history | tail`
* `wc filename` ~ `wc < filename` ~ `cat filename | wc`
* Why are there two backslashes in `history | grep \\.xml`?

### Shell variables

* `$HOME`
* `$PATH`

### Quotes and the shell

* Quotes can get you out of a white-space pickle (`cat 'stupid filename with spaces'`)
* Or you can “escape” the space by preceding it with a backslash (`cat stupid\ filename\ with\ spaces`)
* Quotes or backslash also neutralizes other special characters (`cat 'download.txt(1)'` or `cat download.txt\(1\)`)
* Single quotes are literal (`echo '$HOME'`)
* Double quotes expand variables (`echo "$HOME"`)

## Monday, 2:00–3:30: Programs and files 1

### Hidden files

* `ls -a`
* alias and **.bash_profile**

### The hierarchical file system

* `/`
* Directories are files, too
* `file`: filetype
* `/dev/null`: the black hole of the file system
* Finding the filesystem location of a file from the MacOS finder or Windows explorer
	* Mac: Drag the filename from a finder windows and drop it in a terminal window to paste the path to the file. Or just view it by selecting the file and `cmd+i` (get info)
	* Windows: See Mac directions.
	* Linux: ???
)
### Operating system conventions

* EOL: CR LF (Windows), LF (Unix); `dos2unix`
* Path separator: `\` (Windows non-bash), `/` (Unix)
* Drive letter: `C:/Users` (Windows non-bash), `/c/Users` (Windows git bash), `/mnt/c/Users` (Ubuntu for Windows bash), `/Users` (Unix: no drive letter)

### Files can have more than one name and live in more than one place

* `ln plain_file_name link_name` (filenames and inodes)
* `ln -s directory_name link_name`

### File ownership and permissions

* `ls -l`
* user, group, other
* `chown` (you probably can’t change ownership on shared systems and don’t need to do it on your own machine)
* `chmod` (“644”, “664” for files; “755”, “775” for directories)

### Getting around the directory stack

* `pushd`
* `popd`
* `dirs -v` (verbose); `dirs -c` (clear)

If there’s somewhere you go all the time, define an alias: `alias work='cd /Users/moe/work'`

### Character sets

* Unicode, UTF-8, “legacy” character sets
* `file oldfile.txt`: information about file, including character set for text files (if it says “ASCII”, it’s also UTF-8)
* `iconv -f CP1251 -t UTF-8 oldfile.txt > newfile.txt`: convert `oldfile.txt` from CP1251 to UTF-8 and save result as `newfile.txt`
* `hexdump -C -n1000 filename`: show hex and character values for first 1000 characters of `filename`. Omit the `-n` switch to see the entire file.

### Aliases

#### Why use aliases?

* Shortcuts. `alias saxon='java -Xmx4g  -DentityExpansionLimit=500000 -jar /opt/saxon/saxon9he.jar'`: launch saxon by just typing its name
* Redefine command. `alias grep='grep --color=auto'`: `grep` should always return colored output
* Safety. `alias rm='rm -i'`: don’t delete files without asking for confirmation

#### Aliases and `.bash_profile`

* Aliases you want to save go in ~/.bash_profile. Aliases declared on the command line disappear when you close the terminal window.
* After editing .bash_profile, run `source .bash_profile` to make the changes active in your current shell
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
* `alias saxon='java -Xmx4g  -DentityExpansionLimit=500000 -jar /opt/saxon/saxon9he.jar'` (run the Saxon XSLT engine by typing just `saxon`)
* `alias ob='ssh -l moe -p 12345 myserver.org'` (log into myserver.org on port 12345 with username 'moe' using encryption)
* `alias myproject='cd /Users/djb/Dropbox/myproject'` (move to specified directory)

## Monday, 4:00–5:30: Review

### Close reading of error messages

* Making things go wrong on purpose
* Errors without a message
* Google is your friend! 

### Documentation and man pages

* Regular expression documentation: <https://www.gnu.org/software/findutils/manual/html\_node/find\_html/egrep-regular-expression-syntax.html>

### An exercise in reading a man page

* Finding the information you want ([`cat`](http://man7.org/linux/man-pages/man1/cat.1.html), [ls](http://man7.org/linux/man-pages/man1/ls.1.html))
* Transferring the knowledge you've gained elsewhere 

### Review

* The command line, file paths, an assortment of useful commands
* A very brief primer on the Internet
* Regular expressions and complex search
* How these things crop up in developer idiom

### Project: install Mallet <http://mallet.cs.umass.edu/index.php>

Mallet is used for **topic modeling**, which you can learn about at <http://programminghistorian.org/lessons/topic-modeling-and-mallet>. For now, it’s an installation exercise, and not a lesson in topic modeling.

1. download package and open it
1. `cd` to switch to home directory
1. edit `.bash_profile` to set environment variable `$MALLET_HOME` (Windows users: use `%` instead of `$` on Windows old style) to point to the mallet-directory
1. `cd` to main mallet directory
1. run `bin/mallet import-dir --input sample-data/web/ --output web.mallet`
1. you'll be asked to install the Java developers kit; do that
1. run the command again (don’t retype it; use your command history)
* if output is `Labels = sample-data/web/` (optionally with language suffixes like “de” or “en”, you’re done!

This is an exercise in running into problems and resolving them, not an exercise in showing how skilled you are!

## Tuesday, 11:00–12:30: Command line 2


### Reading from and writing to files

* stdin, stdout, stderr
* `<`: input from file
* `>`: output to file (overwrites existing files with the same name)
* `>>`: append to file (creates file if it doesn’t already exist)
* `2>`: error messages to file (`2> /dev/null`)

### Sending data through pipelines

* `|`
* `history | tail`
* `wc filename` ~ `wc < filename` ~ `cat filename | wc`
* Why are there two backslashes in `history | grep \\.xml`?

### Shell variables

* `$HOME`
* `$PATH`

### Quotes and the shell

* Quotes can get you out of a white-space pickle (`cat 'stupid filename with spaces'`)
* Or you can “escape” the space by preceding it with a backslash (`cat stupid\ filename\ with\ spaces`)
* Quotes or backslash also neutralizes other special characters (`cat 'download.txt(1)'` or `cat download.txt\(1\)`)
* Single quotes are literal (`echo '$HOME'`)
* Double quotes expand variables (`echo "$HOME"`)

### Useful command switches for `ls`

* `-a`: include hidden files
* `-f`: decorate filenames according to filetype
* `-l`: long listing
* `-d`: don’t recurse into directories
* `-t`: sort by time
* `-1`: single-column
* `ls -d */`: list only directories


## Tuesday, 2:00–3:30: Programs and files 2

### File formats

* Unicode beyond UTF-8 (UTF-16, UCS-4)
* CSV and TSV (comma- and tab-separated values)

### The environment

* `env`: show all environment variables
* `$PATH`: list of directories where the shell looks for executable files, starting at the beginning
* `echo $PATH`: show the value of the `$PATH` variable

### More about `$PATH`

* Your working directory is not automatically in your path. Why might that be the case? 
* To execute a file in the current directory, specify the directory as part of the command, e.g., `./command` runs a command called `command` that’s located in the current cwd.

### Finding commands and files

* `help`: list all shell built-ins
* `which`: search `$PATH`, one result [the one that will be executed if you type the command], not for shell built-ins or aliases
* `whereis`: search standard locations, multiple results, not for shell built-ins or aliases
* `find / -name java -print 2> /dev/null`: find all files named `java` starting at the file system root, not for shell built-ins or aliases
* `type`: includes shell built-ins and aliases!

### Connecting to remote systems

* Interactive command line: if available, use `ssh`, not `telnet`
* File-transfer command line: if available, use `sftp`, not `ftp`

### Repeating things and variables

Declare a variable with just it’s name, but refer to it with a leading `$`. Example: `for file in *.txt; do wc -l $file; done`. The preceding declares a variable called `file`, which will be equal to all files in the current directory that end in “.txt” and then reports the number of lines in each. 

In the first example below `%` removes a matching string at the end of the filename. These commands make copies, but if you replace `cp` with `mv`, they rename files.

* `for file in *.txt; do cp ${file%txt}bak; done` replace “.txt” extension with “.bak”
* `for file in *.txt; do cp $file $file.bak; done` keep “.txt”, but add “.bak” after it

### Shell scripts

Do we want to cover this?

### Misc

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
* `-v` lines that don’t match
* `-n`: line numbers
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
**Credit:** Command line, programs, and files tutorials used in the NEH Institute are derived from materials made available by [Software Carpentry](http://software-carpentry.org) under a [CC-BY 4.0 license](https://creativecommons.org/licenses/by/4.0/). 


[Items mentioning regex we may want to save for later in the week

###Wildcards (“globbing”; annoyingly different from regex)

* `*.xml ` (files ending in “.xml”)
* `*.x?l` (files ending in “.x” followed by any letter followed by “l”, e.g., XML [xml], XSLT [xsl], XProc [xpl] files)
* `*.x[ms]l` (files ending in “.x” followed by “m” or “s” followed by “l”, e.g., XML and XSLT files, but not XProc)]
