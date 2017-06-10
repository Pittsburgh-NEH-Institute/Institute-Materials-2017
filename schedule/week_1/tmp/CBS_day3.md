#Week 2: Regular Expressions
(with some review of command line concepts)

###Review from last week

   * what happened to those emails?
   * recap of the Internet, ports, etc.
   * man pages (on the web for Windows --> google) man = manual 
       * Mac / Linux: type e.g. *man find* (to go back to the shell, type Q)
###Searching files with grep.

   * plain text
   * case insensitive
   * how to highlight the match (grep -i --color=auto) multiple words work within quotation marks: "" or ''
   * anchors: ^ (beginning of the line: ^die)  and $ (end of the line: one$)
   * searching for dashes ( -- instead of quotation marks and backslash) "I'm finished giving you options": 
           * *grep --colour -i -- -and alice.txt*
           * *( grep --colour "\-and" alice.txt )*

###Digression: Command history

   * up \& down arrow
   * ctrl-R and type --> search command history (browse from latest back in time by repeating ctrl-R)
           * history --> numbered list of commands (with !+number of command --> brings up the respective command)
   * use of !$ (last argument from the last command) and !! (same as up arrow)
   * !* all except the command (to change the command while keeping the same arguments)
###When you need an escape

   * - and especially --
   * !
   * ", ', and the difference between them
   * the meanings of $
   * the value of testing

###Extended regular expressions

   * recap of alias and why we use them
   * what is a *pattern*?
   * wildcards, a little differently
   * zero or more: *
   * one or more: +
   * zero or one: ?
   * a precise number: {3}
   * how to make these literal
###Digression: Standard input and output

   * recap of redirects and STDOUT (Standard Output in a proper file with: 1> output.txt)
   * STDERR can be redirected too (Standard Error in a proper file with: 2> error.txt)
           * STDOUT and STDERR  in the same file: 2>\&1 (2 is going wherever 1 is going; after having defined where 1 goes)
   * why you've been needing ctrl-C
   * STDIN and the other end of the pipe
   * some programs use STDIN!
###Extended regular expressions: character classes

   * anything goes: .
   * alternatives for a single character: [ab]
   * ranges for a single character: [a-z]
   * anything but that: [^ab], [^a-z]
           * grep -v --> non-matching lines (everything that does not match the following pattern)
   * alternatives for words: (this|that)
   * word characters: \wgr
   * digits: \d # DON'T WORK ON GIT BASH IN WINDOWS
   * spaces: \s
###Extended regular expressions: setting conditions

   * recap of ^ and $
   * word boundaries: \b and \B
   * for the really brave: grouping and backreference
###Homework
Do the survey
Go have fun solving regex crosswords! \url{https://regexcrossword.com} 
