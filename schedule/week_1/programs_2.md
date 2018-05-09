# Programs and files 2

## Repeating things and variables
 
 Declare a variable with just its name, but refer to it with a leading `$`. For example: 
 
```bash
for file in *.txt; do wc -l $file; done
```

The preceding declares a variable called `file`, which will be equal to all files in the current directory that end in `.txt` and then reports the number of lines in each. 

In the first example below, `%` removes a matching string at the end of the filename (in this case, `.txt`), and we then append something else (in this case, `.bak`). This changes the extension on all `.txt` files to `.bak`; for example, it changes `obdurodon.txt` to `obdurodon.bak`. The second example keeps the `.txt` and appends `.bak` after it, changing `obdurodon.txt` to `obdurodon.txt.bak`.

Both commands as written, with `cp`, make copies, but if you replace `cp` with `mv`, they rename files.

```bash
for file in *.txt; do cp ${file%txt}bak; done 
for file in *.txt; do cp $file $file.bak; done
```
 
## The environment
 
* `env`: show all environment variables
* `$PATH`: list of directories where the shell looks for executable files, starting at the beginning
* `echo $PATH`: show the value of the `$PATH` variable
 
### More about `$PATH`
 
* Your working directory is not automatically in your path. Why might that be the case? 
* To execute a file in the current directory, specify the directory as part of the command, e.g., `./command` runs a command called `command` that’s located in the current working directory.
 
## Finding commands and files
 
* `help`: list all shell built-ins
* `which`: search `$PATH`, one result (the one that will be executed if you type the command), not for shell built-ins or aliases
* `whereis`: search standard locations, multiple results, not for shell built-ins or aliases
* `find / -name java -print 2> /dev/null`: find all files named `java` starting at the file system root, not for shell built-ins or aliases
* `type`: includes shell built-ins and aliases!
 
## System locale (`$LOCALE` and `$LC_*`)
 
 Declare a variable with just it’s name, but refer to it with a leading `$`. Example:
 
 ```bash
 for file in *.txt; do wc -l $file; done
 ```
 The preceding declares a variable called `file`, which will be equal to all files in the current directory that end in `.txt`, and then reports the number of lines in each. 

* How to find your locale: the `locale` command
* What the different `LC_*` variables are for
* What happens when your locale changes: playing with `date`
 
## Misc
* `diff`
* `locale`: view your locale
* `diff` and `wdiff`