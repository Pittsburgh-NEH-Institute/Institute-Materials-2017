# Programs and files 1

## The hierarchical file system
<!-- note about Python versions for Mac-->
* `/`
* Directories are files, too
* `file`: filetype
* `/dev/null`: the black hole of the file system
* Finding the filesystem location of a file from the MacOS Finder or Windows Explorer
	* Mac: Drag the filename from a Finder windows and drop it in a terminal window to paste the path to the file. Or just view the filename by selecting the file and `Cmd+i` (get info).
	* Windows: Drag the filename from File Explorer and drop it in the terminal window to paste the path.
	* Linux: ???

## Operating system conventions

* EOL: CR LF (Windows), LF (Unix); `dos2unix`; using the `file` command
* Path separator: `\` (Windows non-bash), `/` (Unix)
* Drive letter: `C:/Users` (Windows non-bash), `/c/Users` (Windows git `bash`), `/Users` (Unix: no drive letter)

## Files can have more than one name and live in more than one place


* `ln plain_file_name link_name` (filenames and inodes)<!--Inodes introduce a little bit more complexity into our original idea of "what are files?" The reason we can change filenames is that inodes store the location and attribute information, so a file can exist in multiple places with different names, so long as it links back to that inode number. To view the inode numbers for your files, use `ls -i`.-->
* `ln -s directory_name link_name`
* Difference between hard links and symbolic links

## File ownership and permissions

* `ls -l`
* user, group, other
* `chown` (You probably can’t change ownership on shared systems and don’t need to do it on your own machine. This command is useful if you install something incorrectly.)
* `chmod` (“644”, “664” for files; “755”, “775” for directories)

## Getting around the directory stack

<!--to explain what this is and why and how it's used-->
* review of `cd` and `cd -`
* `pushd`
* `popd`
* `dirs -v` (verbose); `dirs -c` (clear)


## Character sets

* Unicode, UTF-8, “legacy” character sets
* The Windows default encoding scheme is ANSI (aka Windows-1252 or variants). When saving text files (in Notepad or Notepad++), save as UTF-8 <[screenshot](images/programs_and_files1_ansi.png)>. 
* `file oldfile.txt`: information about file, including character set for text files (if it says “ASCII”, it’s also UTF-8)
* `iconv -f CP1251 -t UTF-8 oldfile.txt > newfile.txt`: convert `oldfile.txt` from CP1251 to UTF-8 and save result as `newfile.txt`
* `hexdump -C -n1000 filename` or `xxd filename`: show hex and character values for first 1000 characters of `filename`. Omit the `-n` switch to see the entire file.

## Aliases

### Why use aliases?

* **Shortcuts** `alias saxon='java -Xmx4g -DentityExpansionLimit=500000 -jar /opt/saxon/saxon9he.jar'`: launch saxon by just typing its name
* **Redefine command** `alias grep='grep --color=auto'`: `grep` should always return colored output
* **Safety** `alias rm='rm -i'`: don’t delete files without asking for confirmation
* **Getting around** `alias doc="cd ~/Documents"`: take me to my Documents folder

### Aliases and `.bash_profile`

* Aliases you want to save go in ~/.bash\_profile. Aliases declared on the command line disappear when you close the terminal window. 
* If .bash\_profile does not exist, create it first: `touch .bash_profile` (while in your home directory), and then edit it.  
* To edit a file that begins with a dot, type `bbedit .bash_profile` (or `mate` if you’re using TextMate or `notepad` if you’re using notepad), or open it from the MacOS Finder or Windows File Explorer. 
* After editing .bash\_profile, run `source .bash_profile` to make the changes take effect in your current shell. 


### Alias details

* Syntax: `alias ll='ls -l'`
* `alias`: list all aliases
* `type ll`: find out what `ll` is aliased to
* Windows users: `alias python='winpty python.exe'`

### Sample alias declarations

* `alias ls='ls -G'` (colored output)
* `alias la='ls -aG'` (hidden files)
* `alias ll='ls -alG'` (long listing)
* `alias lt='ls -alGt'`(sort by date)
* `alias lh='ls -alGh'` (human-readable numbers)
* `alias grep='grep --color=auto'` (colored output)
* `alias saxon='java -Xmx4g -DentityExpansionLimit=500000 -jar /opt/saxon/saxon9he.jar'` (run the Saxon XSLT engine by typing just `saxon`)
* `alias ob='ssh -l moe -p 12345 myserver.org'` (type `ob` to log into myserver.org on port 12345 with username 'moe' using encryption)
* `alias myproject='cd /Users/djb/Dropbox/myproject'` (move to specified directory)
