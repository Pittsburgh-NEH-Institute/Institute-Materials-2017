Welcome to the Computational Background Skills class! I will use this notepad to give you links and other things that it would be difficult to copy by hand. You, the students, may use it to keep any sort of collective notes you like on what we learn.

There is also a chat box in this document; if you have any questions, feel free to put them on the chat and I will try to address any that go unanswered.

###Preliminaries
1. Installation

   * For Mac users: [in Terminal.app] 
       * xcode-select --install
   * For Windows users: Git tools (Git Bash)
   * For all users: Anaconda Python version 3.6: \url{https://www.continuum.io/downloads}
2. Extra setup

   * For Windows users: [in Git Bash]
       *  alias python='winpty python.exe'
       * alias telnet='winpty telnet.exe'
   * For all users: create a folder for your work in this class, and expand the 'shell-novice-data' ZIP file into it
###Day 1 Lesson Plan

Having a look around

   * Why do we use the shell?
   * Looking around: ls, cd, pwd
       * ls is for looking around
   * The filesystem and the finder
   * Making things easier: the 'tab' key, the arrow keys
Changing things

   * Copying
   * Moving
   * Removing
   * Adding files
   * Adding directories
Putting things together

   * Selecting multiple files and directories (wildcards)
   * More useful commands: wc, cat, sort, head, tail
   * Reading from and writing to files
   * Sending data through pipes
Repeating things

   * For loops
   * Shell variables
   * More about wildcards
   * Making things easier: ctrl-R, !$, !!
**Day 2 Lesson Plan**

Review

   * Commands we learned
   * - ls for showing the directory inventory you're in
   * - ls -F shows the inventory and if something is a  directory itself or a file
   * - pwd for showing the path
   * - cd for entering new directories 
   * - cd ~ brings you to your home directory
   * - .. for going one directory behind where you're located at the moment
   * - . for going to the exact directory where you're located at the moment
   * - \  stands for space e.g.: Documents/Digital\ Humanities/
   * - ls / --> base of the entire file system
   * - mkdir for creating a directory
   * - rmdir for deleating a directory
   * - touch creates a file without any content
   * - rm removes a file
   * - wc for counting the words, lines and characters in a file
   * - cat shows the content of a file
   * - echo in front of the command shows what the command will do and which files it'll use
   * - head to show the first 10 lines of a document
   * - head -n to show the first n lines of a document
   * - * for "everything"
   * - mv to move a file to another directory
   * - cp for copy a file to another directory
   * - # to ignore what you type behind this sign (can be used for safety reasons)
   * - [ ] for either-or-arguments (e.g. ls *[AB].txt shows everything that ends on either A.txt or B.txt - but not AB.txt!)
   * - \ means "treat the next character as something with no meaning" --> important for entering directories or operating with files with a space in the name
   * 

       * !! if the **shell** gives you a **$** --> "I’m ready to take your command"
       *    if the **shell** gives you a **>** --> "I’m ready to end the command and do as you said"
       *    if **you** type in a **$ **--> "hey shell, here comes a variable!"
       *    if **you** type in a **>** --> "hey shell, put the output into a new file!"
   * 

   * For loops and variables
for **datafile** in NENE*.txt --> "datafile" is the name of the variable. It could be anything (e.g. "file", "filename", "jellyfish"), but it makes sense to choose a name that refers to what should be done afterwards. It's important to use the same name in the command, but with a $-sign added, so it refers to the variable. Otherwise, the shell would think it should e.g. create a new file named "datafile". 
> do
> bash goostats **$datafile** stats-**$datafile**
> done

   * 
Finding things

   * grep - lets you look for single letter combinations (and whole words with -w, multiple words in quotation marks) in files and outputs them (first Argument = word you're looking for, second arg. = filename)
       * -w ..e --> 3rd (last??) character is an e
       * ^ --> beginning of the line, e.g. ^.o --> second character at the beginning of the line is an o
       * $ (as part of the grep-command!) --> end of the line, e.g. ing$ --> line ends with ing
       * grep --help shows you the possible ways to use grep
   * find
   * - find shows you the directory structure
   * 

   * Complications: spaces, quotes, slashes
The environment

   * More on variables: $() --> 
xargs -->

   * What a shell is
   * Environment variables: export, PS1, HOME, PATH
   * Changing your defaults: .bash\_profile
   * Making shortcuts: alias
       * with aliases, old commands are replaced by new ones
           * e.g. alias lc="wc -l"
           * -l   --> only word count (wc: lines, words, characters)
       * if you've forgotten which command you have aliased, use
           * type lc --> lc is aliased to `wc -l'
       * when done in the shell, the alias only works until the working session is done; when you quit, it's gone
       * to save it, you have to write it as a line into the file .bash\_profile in your **home directory**
       * the bash-profile is a Dot-file and likes to hide itself. 
           * on Windows, it could be found with the Notepad ++ editor
           * on Mac, you can open it out of the shell with mate .bash\_profile (when using TextMate) or atom .bash\_profile (when using Atom). 
       * write the alias-command as shown above on the bottom of the document and save it --> now the alias stays even if you quit the terminal
   * Looking at your environment: env
Running programs

   * The path
   * Executables
   * Shell scripts
   * Other shells
Files and their contents

   * Fonts, character sets, and Unicode
   * UTF-8 vs. UTF-16
   * Line endings
   * Dashes and quotes