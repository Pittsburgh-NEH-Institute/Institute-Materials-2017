# Command line, programs, and files schedule

## General

* **Preliminaries:** If you haven’t done so already, complete preparation described at our [Before you arrive](before_you_arrive.md) page. 
* **References:** Much of the content of these sessions is summarized at our [Command line quick reference](command-line_resources.md) page.* 
* **Etherpad:** We’ll create an [Etherpad](https://etherpad.net) where participants who wish to do so can take notes collaboratively. For a quick overview of Etherpad functionality see <http://write.flossmanuals.net/etherpad/introduction/>.
____

## Monday, 11:00–12:30: Command line 1

### Why and how do we use the shell?

* The shell is a program that runs other programs.
* We use the shell to interact with the computer on the command line (CLI ~ GUI).
* The Unix philosophy is that you can _pipe_ together small commands, each of which does one thing well, to do something complex. You can’t do this in a GUI.
* Learn the shell on a need-to-know basis. There are commands you’ll use every day, some you’ll use for special purposes (and you’ll look up how they work when you need them), and some that you’ll never need.

### Launching the shell

### Getting oriented
* `cd`: change directory
* `clear`: clear the screen
* `pwd`: print working directory (current location in filesystem)
* `whoami`: print login id

### Explore your files

* `ls`: list files
* `less`: page through file (space to go forward, `b` to go back, `q` to quit)
* `grep`: global regular expression print (find lines that match a pattern)

### Making things easier

* Command and filename completion with the Tab key
* History with the arrow keys
* RTFM with `man` (user manual)

### Working with files

* `cp`: copy
* `mv`: move and rename
* `rm`: delete (careful!)

### Working with directories

* `mkdir`: make directory
* `rmdir`: remove empty directory
* `rm -rf:` remove directory and its contents recursively (careful!)

### Making things easier

* Wildcards (“globbing”; annoyingly different from regex)
	* `*.xml ` (files ending in “.xml”)
	* `*.x?l` (files ending in “.x” followed by any letter followed by “l”, e.g., XML [xml], XSLT [xsl], XProc [xpl] files)
	* `*.x[ms]l` (files ending in “.x” followed by “m” or “s” followed by “l”, e.g., XML and XSLT files, but not XProc)
* `!!`: rerun the last command
* `!$`: plug in the last word token from the last command
* `cd -`: go back to the directory you came from
* `cd` or `cd ~`: go to your home directory
* `ctrl-r`: initiate history search
* `..`: parent directory
* `.`: current directory (Why might you need this?)
* `~`: home directory

### Getting around the directory stack

* `pushd`
* `popd`
* `dirs -v` (verbose); `dirs -c` (clear)

If there’s somewhere you go all the time, define an alias: `alias work='cd /Users/moe/work'`

### More useful commands

* `wc` (`-l` lines, `-w` words, `-c` characters)
* `cat` (you might have meant `less`)
* `sort` (`-r` reverse, `-u` unique, `-g` numeric)
* `uniq` (only on sorted input)
* `head` (`-10`, or any other number)
* `tail` (`-10`, or any other number)

### Reading from and writing to files

* stdin, stdout, stderr
* `<`: input from file
* `>`: output to file
* `2>`: error messages to file (`2> /dev/null`)

### Sending data through pipelines

* `|`
* `history | tail`
* `wc filename` ~ `wc < filename` ~ `cat filename | wc`
* Why are there two backslashes in `history | grep \\.xml`?

### Repeating things

In the first example below `%` removes a matching string at the end of the filename. These commands make copies, but if you replace `cp` with `mv`, they rename files.

* `for file in *.txt; do cp ${file%txt}bak; done` replace “.txt” extension with “.bak”
* `for file in *.txt; do cp $file $file.bak; done` keep “.txt”, but add “.bak” after it

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
* `file`
* /dev/null

### Files can have more than one name and live in more than one place

* `ln plain_file_name link_name` (filenames and inodes)
* `ln -s directory_name link_name`

### File ownership and permissions

* `ls -l`
* user, group, other
* `chown` (you probably can’t change ownership on shared systems and don’t need to do it on your own machine)
* `chmod` (“644”, “664” for files; “755”, “775” for directories)

### Character sets

* Unicode, UTF-8, “legacy” character sets
* `iconv -f CP1251 -t UTF-8 oldfile.txt > newfile.txt`

### Operating system conventions

* EOL: CR LF (Windows), LF (Unix); `dos2unix`
* Path separator: `\` (Windows non-bash), `/` (Unix)
* Drive letter: `C:/Users` (Windows non-bash), `/c/Users` (Windows git bash), `/mnt/c/Users` (Ubuntu for Windows bash), `/Users` (Unix: no drive letter)

### Aliases

* Aliases go in ~/.bash_profile
* After editing .bash_profile, run `source .bash_profile` to make the changes active in your current shell
* Syntax: `alias ll='ls -l'`
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

Documentation and error messages

## Tuesday, 11:00–12:30: Command line 2

### Useful command switches for `ls`

* `-a`: include hidden files
* `-f`: decorate filenames according to filetype
* `-l`: long listing
* `-d`: don’t recurse into directories
* `-t`: sort by time
* `-1`: single-column
* `ls -d */`: list only directories

### Useful command switches for `grep`

* `-w`: whole words
* `-i`: case insensitive
* `-l`: filenames but not text
* `-v` lines that don’t match
* `-n`: line numbers
* `-c`: count of matching lines
* `-s`: silent mode (suppresses error messages)

## Tuesday, 2:00–3:30: Programs and files 2

### Connecting to remote systems

* Interactive command line: if available, use `ssh`, not `telnet`
* File-transfer command line: if available, use `sftp`, not `ftp`

## Tuesday, 4:00–5:30: Review

## Wednesday, 11:00–12:30: Command line 3

____
**Credit:** Command line, programs, and files tutorials used in the NEH Institute are derived from materials made available by [Software Carpentry](http://software-carpentry.org) under a [CC-BY 4.0 license](https://creativecommons.org/licenses/by/4.0/). 
