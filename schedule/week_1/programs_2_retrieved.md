 # Programs and files 2
 (incorporates Tara's and Gabi's Materials)
 ## File formats
- Unicode beyond UTF-8 (UTF-16, UCS-4)
- CSV and TSV (comma- and tab-separated values)
 ## Repeating things and variables
 
 Declare a variable with just it’s name, but refer to it with a leading `$`. Example: `for file in *.txt; do wc -l $file; done`. The preceding declares a variable called `file`, which will be equal to all files in the current directory that end in “.txt” and then reports the number of lines in each. 
 
 * Unicode beyond UTF-8 (UTF-16, UCS-4)
 * CSV and TSV (comma- and tab-separated values)
 In the first example below `%` removes a matching string at the end of the filename. These commands make copies, but if you replace `cp` with `mv`, they rename files.

 * `for file in *.txt; do cp ${file%txt}bak; done` replace “.txt” extension with “.bak”
 * `for file in *.txt; do cp $file $file.bak; done` keep “.txt”, but add “.bak” after it
 
 ## The environment
 
 * `env`: show all environment variables
 * `$PATH`: list of directories where the shell looks for executable files, starting at the beginning
 * `echo $PATH`: show the value of the `$PATH` variable
 
 ## More about `$PATH`
 ## The execution path (`$PATH`)
 
 * Your working directory is not automatically in your path. Why might that be the case? 
 * To execute a file in the current directory, specify the directory as part of the command, e.g., `./command` runs a command called `command` that’s located in the current working directory.
 
 ## Finding commands and files
 
 * `help`: list all shell built-ins
 * `which`: search `$PATH`, one result (the one that will be executed if you type the command), not for shell built-ins or aliases
 * `whereis`: search standard locations, multiple results, not for shell built-ins or aliases
 * `find / -name java -print 2> /dev/null`: find all files named `java` starting at the file system root, not for shell built-ins or aliases
 * `type`: includes shell built-ins and aliases!
 
 ## Repeating things and variables
 ## System locale (`$LOCALE` and `$LC_*`)
 
 Declare a variable with just it’s name, but refer to it with a leading `$`. Example: `for file in *.txt; do wc -l $file; done`. The preceding declares a variable called `file`, which will be equal to all files in the current directory that end in “.txt” and then reports the number of lines in each. 
 * How to find your locale: the `locale` command
 * What the different LC_* variables are for
 * What happens when your locale changes: playing with `date`
 
 In the first example below `%` removes a matching string at the end of the filename. These commands make copies, but if you replace `cp` with `mv`, they rename files.
 ## Spreadsheets, CSV, and hidden traps therein
 
 * `for file in *.txt; do cp ${file%txt}bak; done` replace “.txt” extension with “.bak”
 * `for file in *.txt; do cp $file $file.bak; done` keep “.txt”, but add “.bak” after it
 * What is CSV and TSV (comma- and tab-separated value) format?
 * What does that have to do with your locale?
 
 ## Misc
 * `diff`
 * `locale`: view your locale

 * `diff` and `wdiff`