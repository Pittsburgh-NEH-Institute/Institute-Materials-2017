# Command line 2

## Enhanced history

<!--this will be a good way to review/reflect/field qs-->
* `!!`: rerun the last command
* `!command`: rerun the most recent command that begins with the word after the exclamation mark (that is, replace “command” with the name of the command)
* `!25`: rerun command #25 (get number with `history`; fine-tune as above for beginning of command, or with `history | grep stuff` to find all history items that include the string “stuff”)
* `!$`: plug in the last word token from the last command

## Editing the command line

* Up-arrow recalls the last command (or keep going, or go forward after you go back)
* `ctrl+r` and start typing seaches for substring matches in the history; keep typing `ctrl+r` to cycle through the matches
* `left-arrow` and `right-arrow` move the cursor through the line
* `ctrl+a` go to the beginning of the line
* `ctrl+e` go to the end of the line
* `ctrl+u` erase everything from the cursor until the beginning of the line
* `ctrl+c` abort whatever you’re doing and return to a new command line
* `Opt+click` anywhere in the line to move the cursor (MacOS only)
* Careful: `ctrl+d` exit the shell and close the terminal window

## Wildcards (“globbing”; annoyingly different from regex) 

<!--using forked week_1 subdirectory, use `grep` to explore files-->
* [Fork](/Institute-Materials-2017/schedule/week_2/fork.md) our Git repo to your local machine
* `*.xml ` (files ending in “.xml”)<!--Ask the participants of times they think it might be useful to use globbing. Now that they have some experience with regex, the idea of wildcards isn’t foreign. With which commands will you likely use wildcards?-->
* `*.x?l` (files ending in “.x” followed by any single letter followed by “l”, e.g., XML [xml], XSLT [xsl], XProc [xpl] files)
* `*.x[ms]l` (files ending in “.x” followed by “m” or “s” followed by “l”, e.g., XML and XSLT files, but not XProc)

## Reading from and writing to files

* stdin, stdout, stderr
* `<`: input from file
* `>`: output to file (overwrites existing files with the same name)
* `>>`: append to file (creates file if it doesn’t already exist)
* `2>`: error messages to file (`2> /dev/null`)

## Sending data through pipelines

* `|`
* `history | tail`
* `wc filename` ~ `wc < filename` ~ `cat filename | wc`
* Why are there two backslashes in `history | grep \\.xml`?<!--SW Carpentry pipelining activity, adapted-->
## Shell variables

* `env | grep PATH`
* `$HOME`
* `$PATH`

## Quotes and the shell

* Quotes can get you out of a white-space pickle (`cat ’stupid filename with spaces’`)
* Or you can “escape” the space by preceding it with a backslash (`cat stupid\ filename\ with\ spaces`)
* Quotes or backslash also escape other special characters (`cat ’download.txt(1)’` or `cat download.txt\(1\)`)
* Single quotes are literal (`echo ’$HOME’`)
* Double quotes expand variables (`echo "$HOME"`)

## Useful command switches for `ls` 
<!-- review from command 1, should we scrap?-->

* `-G`: colorize output
* `-a`: include hidden files
* `-f`: decorate filenames according to filetype
* `-l`: long listing
* `-d`: don’t recurse into directories
* `-t`: sort by time
* `-1`: single-column
* `ls -d */`: list only directories
