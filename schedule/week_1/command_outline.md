# Command line, programs, and files schedule
____

## General

* **Preliminaries:** If you haven’t done so already, complete preparation described at our [Before you arrive](before_you_arrive.md) page. 
* **References:** Much of the content of these sessions is summarized at our [Command line quick reference](command_resources.md) page.
* **Etherpad:** We’ll create an [Etherpad](https://etherpad.net) where participants who wish to do so can take notes collaboratively. For a quick overview of Etherpad functionality see <http://write.flossmanuals.net/etherpad/introduction/>.

## Monday, 9:00–10:30: Getting to know your OS: file and directory system

[10 mins. Introductions, verify that everyone’s Eduroam connections work]

### File system hierarchy 

[10 mins]

* What are files?
* What are directories/repositories/folders? <!--Thinking about why we call them folders: a folder and a piece of paper are the same, and can do some of the same things. A folder can also hold pieces of paper.-->
* What are programs? <!--Programs are files that can do something, but are still files nonetheless. Take a piece of paper out of your folder, fold it into an airplane, and throw it. It's still a piece of paper you can read from and write on, but it can fly.-->
* GUI file explorers and file heirarchy

### Hidden files and filename extensions

[15 mins]

#### Configuring your machine to show hidden files
<!-- consolidate these -->
* **To show hidden files for Mac OS Sierra:** Open the Finder and hit `Cmd+Shift+.` (dot)
* **To show hidden files for Mac OS El Capitan:** Execute `defaults write com.apple.finder AppleShowAllFiles YES` on the command line
* **To show filename extensions for Mac OS:** Open the Finder and choose Preferences, click Advanced, and check the box next to "Show all filename extensions". 
* **To show hidden files for Windows:** Control Panel → Appearance and Personalization → File Explorer Options → View → select “Display the full path in the title bar” *and* “Show hidden files, folders, and drives”.
* **To show filename extensions for Windows:** Open File Explorer, click the View tab at the top, select “File name extensions” under the Show/hide tab.

#### About files

* Why are some files hidden? <!--If you change something, however small, in some of these files, you can break your computer. Be careful!-->
* **Case sensitive** vs **case preserving**: Linux is **case sensitive**, meaning files with the same name but different capitalization are different files (e.g., `finalpaper.txt` is different than `FinalPaper.txt`). Mac OS and Windows are **case preserving**, but not case sensitive.
<!-- (This preference can be changed when configuring the filesystem, but certain programs will not run in a case sensitive environment, so it’s best to leave it alone). A case preserving file system will spell the filename as you type it, but if you create a different file with a name that differs only in capitalization, it will overwrite the first one. We recommend not creating filenames that differ only in capitalization even on Linux; not only is it potentially confusing, but you may be collaborating on a project with someone not on Linux. -->

### Moving through a filesystem
<!-- Move the programs and files stuff in here, use cmd.exe -->
<!-- where is home?  both in cmd and in gui-->
<!-- language differences for gui and command line-->
[30 mins]

* Navigate up and down, with emphasis on the paths in the title bar.
<!-- We should clarify that Git Bash will use forward slashes rather than backslashes, and explain later when we introduce cmd why that's the case.-->
* Drives and volumes
** Windows has drive letters: `/c/Users` or e.g. `/e` for USB (Windows git bash), `C:\Users` or `E:\` (Windows non-bash)
** Mac has no drive letters: `/Users` but it does have volumes: `/Volumes/Thumb\ Drive`.
* `cd`: change directory
<!--Open a command line and begin using `cd`. Explain that `cd` is essentially the same as selecting or clicking a folder. `cd` into your home directory.-->
* `ls`: list all files
<!--Use `ls` to show all the files in your current (when you first open the terminal, home) directory. Compare that to what you now see in your home directory (or C drive "folder"). Then use `cd Documents` to move into your documents folder. This is a relative path, as you’ve navigated relative to where you’ve started. Explain what an absolute path looks like, and try running one. Then run a few relative paths.-->


### Why and how do we use the shell?

[10 mins]

* The shell is a program that runs other programs.
<!--Emphasize that the shell is still a program, which takes input and gives output. The input is a command, though, so it seems as though we’re doing something different. In reality, using command line is no different than using any other program.-->
* We use the shell to interact with the computer on the command line (CLI ~ GUI).
* The Unix philosophy is that you can _pipe_ (chain) together small commands, each of which does one thing well, to do something complex. You can’t do this in a GUI.
* bash = ‘Bourne again shell’ (the original Bourne shell is sh; others include csh, ksh, tcsh, zsh).
<!--We use and recommend bash (Git Bash). There are many different shells, some of which you end up downloading with program packages like Python.-->
* Learn the shell on a need-to-know basis.
<!--There are commands you’ll use every day, some you’ll use for special purposes (and you’ll look up how they work when you need them), and some that you’ll never need.-->

### Launching the shell

[5 mins]

* For Mac OS X: the **Terminal.app** that you will find in the Applications → Utilities folder. (Many Mac users prefer the free third-party <https://www.iterm2.com/>.)
* For Windows: Although **cmd.exe** is the traditional Windows shell, and you may even have used it previously, we recommend **bash**. When you download Git, you'll also download **Git bash**, the command line interface we use and recommend. (We do not recommend the Windows 10 “Ubuntu in Windows”.)
* For Ubuntu Desktop (Unity): you can hit Ctrl-Alt-T or you can type `Terminal` into the Search box.


### Windows shells (`cmd.exe`, Git bash, and others)

[5 mins] 

* In the past, you may have used `cmd.exe`, Windows Powershell, or Bash on Ubuntu on Windows. Though each has its own benefits and drawbacks, for the purposes of this course we will use Git bash.

### `ls` switches

[10 mins]

* `ls -a`: include hidden files (filenames starting with `.`)
* `ls -l`: show enhanced file information, including date and time stamps, owner and group, permissions
* `ls -t`: list in timestamp order
* `ls -G`: colored output
<!--If you’re using Git 
Bash, your list will already be colorized, but for other shells this command colorizes output so filetypes and directories are different.-->

## Monday, 11:00–12:30: Command line 1

### Getting oriented

[5 mins]

* When you see `$` (shell prompt): the shell is waiting for you to provide input
* When you type `$`: you’re beginning to type a variable name (see below)
* When you see `>` (shell continuation prompt): you’ve started entering multiple-line input, and the shell is waiting for the next line
* When you type `>`: you’re writing output into a file, instead of displaying it on the screen (see below)
* If you type a command and find yourself on a blank line with nothing happening: you typed an incomplete command, and should abort it with `Ctrl+c`

### First commands

[15 mins]

* `cd`: change directory. also `cd ..`, `cd ~`
* `pwd`: print working directory (current location in filesystem)
* `whoami`: print login id
* `clear`: clear the screen (keyboard shortcut: `Ctrl+l` [that’s a lowercase “L”, not the digit “1”])
* absolute vs. relative paths

### Explore your files

[25 mins]

* `ls`: list files
<!--Use `cd` to navigate to your home directory, and then `ls -a` to show all files and directories, including hidden ones. From there, use `cd Documents` to move into that directory.--> 
* `echo`: echoes a string to stdout
<!--Using `echo`, write the string 'Hello world!' to the screen.-->
* stdin, stdout, stderr
<!--Remember that Bash is a program, it just happens to be a program you use to run other programs. This means that you're constantly editing files while you use Bash: these are called Standard Input (stdin), Standard Output (stdout), and Standard Error (stderr). You write input at the command line, the program processes your command, and any output is written to stdout. If you run into an error, output is written to stderr, which prints to your screen the same way stdout does. This means that you may purposely (or accidentally print to either). For now, we'll just print to stdout, which is the default.-->
* `touch`: create a file, or update its timestamp 
<!--Use `touch sample.txt` to create a new plain text file in your Documents folder.-->
* Redirecting stdout with `>`
<!--Instead of printing your greeting, which you created with `echo 'Hello world!'` earlier, we can redirect it to a file using a right angle bracket. Type `echo 'Hello world!' > greeting.txt`. Notice that nothing is printed to your screen.--> 
* `cat`: view and combine files
<!--Now that we’ve written a file, we can view it using `cat`, which is short for "concatenate". It has a multitude of uses, but for now we’ll just use it to print the contents of our file to stdout. `cat greeting.txt`.-->
* `less`: display a file one page at a time
<!--Another useful command for longer files, as it prints only one screen at a time.--> 
* `grep`: find text inside files
<!--`grep` takes two arguments: the regex (not just string) you’re searching for and the file you want to search in. If you don’t supply a file, it searches stdin. Try using the command `grep "Hello" greeting.txt` (mind your capital letters!). The entire contents of the file is written to stdout because `grep` returns the entire line that contains the search pattern, and this file has only one line. If you try searching for "hello" (or some other capitalization difference), you’ll see nothing printed to stdout. We use the `-i` switch to turn off case sensitivity. The switch comes directly after the command, before any arguments. Try `grep -i "hElLo WoRld" greeting.txt`.-->

### Making things easier

[5 mins]

* Command and filename completion with the `Tab` key
* Command history with the arrow keys
* RTFM with `man` (user manual). Windows users on Git Bash don’t have this luxury, unfortunately; <https://ss64.com/bash/> doesn’t match the Git bash command inventory exactly, but it’s close.
* To turn off case sensitive tab completion, create a file called `.inputrc` in your home directory (you can use any text editor). In the file, write `echo 'set completion-ignore-case On'` and save. The next time you open your bash shell, you should be able to use tab completion without thinking about capitalization.
* Dragging a file from your filesystem Finder/Explorer window to the terminal!
<!-- This helps you find things quickly when you have a small number of files, but it also generates a lot of false hits when you have many files. -->

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
* To disable an alias temporarily, precede it with a backslash. E.g., if you have aliased `ls` to `ls -l`, you can run it with the original meaning as `\ls`.

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


