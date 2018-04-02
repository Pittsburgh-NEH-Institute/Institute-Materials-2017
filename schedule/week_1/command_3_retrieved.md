# Command line 3

## Advanced `grep`

### Useful command switches for `grep`

Download and unzip the “C-Span Inaugural Address Corpus”, available on NLTK’s corpora page: http://www.nltk.org/nltk_data/.  Place the unzipped inaugural folder on your desktop.

* `-E`: extended regex (supports `{` metacharacter, wrap double quotes around regex)
* `-w`: whole words (put phrases in single or double quotation marks)
* `-i`: case insensitive
* `-l`: filenames but not text
* `-v`: lines that don’t match (“invert” the search)
* `-n`: include line numbers in output
* `-c`: count of matching lines
* `-s`: silent mode (suppresses error messages)

### `grep` and regex

`grep` searches for a _regex pattern_, and not just a string. so:

* `grep ^To: *`: the line begins with the string “To” (a caret at the beginning of a regex means ‘match only at the beginning of a line’)
* `grep ^.o *`: the second letter of the line is an “o” (a dot in regex matches any single character except a newline)
* `grep ing$ *`: the line ends in “ing” (a dollar sign at the end of a regex means ‘match only at the end of a line’)

### `grep` complications

* Variables (begin with a dollar sign) and regex metacharacters (e.g., asterisk) are resolved in double quotation marks and treated as literal strings in single quotation marks
* Spaces: precede with a backslash or put the entire regex in quotation marks
* Variables: put the entire regex in double quotation marks 
* Quotes: single quotes are okay inside double quotes and vice versa
* Hyphens: `grep -l stuff` looks like an incomplete attempt to search for the string “stuff” and return only the filenames—incomplete because you haven’t specified where to look. If you want to search a file called `stuff` for the string `-l`, use `--` to tell `grep` that nothing that follows is a switch: `grep -- -l stuff`. Otherwise anything that begins with a hypen will look like a switch.


## Shell scripting

* Adapt from [Linux tutorial](http://linuxcommand.org/lc3_writing_shell_scripts.php)
