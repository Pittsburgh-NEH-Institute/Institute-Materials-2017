# Programs and files 1

## Identifying file types

* How your operating system does it: filename extensions
* Why this is kind of silly in many cases
* Another way to do it: the magical `file` command
* Why `file` is not completely infallible

## Character sets and file formats

* Where it all began: ASCII
* 8-bit character encodings (and why they're called that)
  * Windows: ANSI / code pages
  * Mac: MacOS encodings
  * Unix: ISO-8859 encodings
* Unicode and encodings thereof 
  * The Unicode set
  * Problems of encoding and how they can be solved
  * Byte order marks in encodings other than UTF-8 (UTR-16, UCS-4)
    * Corollary: there is **never** a reason to choose "UTF-8 with BOM" for your encoding!
  * Unicode-enabled Windows uses UTF-16 by default
  * Unicode-enabled Mac and Linux use UTF-8
* CSV and TSV: comma-separated values and tab-separated values
* Why UTF-8 is preferred by most people: backwards compatibility
* How to know what you have: the `file` command
* How to change what you have: your text editor
  * [Example on Notepad++](images/programs_1_ansi.png)
  * [Example on BBEdit](images/programs_1_bbedit.png)
* How to change what you have on the command line: `iconv -f CP1251 -t UTF-8 oldfile.txt > newfile.txt`
* How to get up close and personal with the bits: `xxd -l 1000 filename` or `xxd filename` for the whole file


## Why we recommend text editors instead of word processors

We will write a 'Hello World' script in Python, for demonstration purposes.

* In Word or OpenOffice
* In TextEdit on Mac (WordPad, alas, has got cleverer, but it's still pretty awkward to use...!)
* Why don't these work?


## Operating system conventions everyone should know about

* Line endings (EOL): 
  * Windows default is CRLF (\r\n, 0x0d 0x0a)
  * Unix/current Mac default is LF (\n, 0x0a)
  * Legacy MacOS default is CR (\r, 0x0d)
  * Use `xxd` to see what kind of line endings you have.
  * Convert line endings on Windows: `dos2unix` and `unix2dos`
  * Convert line endings on Mac: either install `dos2unix` via Homebrew (`brew install dos2unix`), or [use Perl](https://stackoverflow.com/a/14155400) (e.g. `perl -pi -e 's/\r\n|\n|\r/\n/g'` for converting to Unix). We recommend installing the utilities via Homebrew!
  
* Path separators: 
  * `\` (Windows non-bash), 
  * `/` (Unix, Mac)
  * Why you can't put `:` in a file name, and what happens if you try


## Shells within shells

* `ls -l`
* user, group, other
* `chown` (You probably can’t change ownership on shared systems and don’t need to do it on your own machine. This command is useful if you install something incorrectly.)
* `chmod` (“644”, “664” for files; “755”, “775” for directories)
* Bash is a shell, but there are other shells
* Running `python` - different syntax, different commands
* Running `telnet` - another different syntax, more different commands
* Running `bash` within `bash` and process listing
 
## Getting around the directory stack

* review of `cd` and `cd -`
* `pushd`
* `popd`
* `dirs -v` (verbose); `dirs -c` (clear)


