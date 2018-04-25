##Day 4: Useful Things for Programming
(with some review of regular expressions)

###Regular expression recap 

   * Character classes 
   * Bracketed expressions: \url{https://www.gnu.org/software/grep/manual/html\_node/Character-Classes-and-Bracket-Expressions.html}
   * Grouping and backreferences
       * grep ‘[[:digit:]].*\1’ *.txt
       * grep ‘\b(\w\w)\w*\1\b’ *.txt
###File and character encoding

   * your computer's inferences
   * the 'file' command, file magics
       * Mac: /usr/share/file/magic
       * Windwos: /usr/share/misc
   * character encoding, 8 bit
   * character encoding, Unicode
###Platform-specific issues

   * Line endings
   * Hexdump
   * Unicode encodings: UTF-8 vs. UTF-16 vs. UCS-4 (every character is always 4 bytes)
   * Drive and file paths
   * CSV - what it is
   * CSV - platform-specific
###Locale

   * Finding your locale 
   * What it is for
   * When you might need to know about it
###Text editors vs. word processors

   * What word processor files look like
   * What "non-programming" text editor files look like
   * What happens when you try to use onek
###There is more than one shell

   * telnet
       * Mac: **telnet** => telnet> waiting for new commands
       * !!! YOU'RE OPERATING IN THE telnet-SHELL - NOT BASH - SO THE BASH COMMANDS DON'T WORK ANYMORE !!!
       * type **help** => shows possible commands
       * exit: q
   * python
   * bash inside bash
   * pretty much any program that felt like having a shell (SQL, etc.)
