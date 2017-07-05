## Monday, 9:00–10:30: Getting to know your OS: file and directory system

[10 mins. Introductions, verify that everyone’s Eduroam connections work]

### File system hierarchy 

* What are files?
* What are directories/repositories/folders? <!--Thinking about why we call them folders: a folder and a piece of paper are the same, and can do some of the same things. A folder can also hold pieces of paper.-->
* What are programs? <!--Programs are files that can do something, but are still files nonetheless. Take a piece of paper out of your folder, fold it into an airplane, and throw it. It's still a piece of paper you can read from and write on, but it can fly.-->
* GUI file explorers and file hierarchy


### Hidden files and filename extensions


#### Configuring your machine to show hidden files
<!-- consolidate these -->
* Mac OS 
	* **To show the root directory and the directory hierarchy in Finder in Mac OS**: do ...
	* **To show hidden files for Mac OS Sierra:** Open the Finder and hit `Cmd+Shift+.` (dot)
	* **To show hidden files for Mac OS El Capitan:** Execute `defaults write com.apple.finder AppleShowAllFiles YES` on the command line
	* **To show filename extensions for Mac OS:** Open the Finder and choose Preferences, click Advanced, and check the box next to "Show all filename extensions". 

* Windows
	* **To show hidden files for Windows:** Control Panel → Appearance and Personalization → File Explorer Options → View → select “Display the full path in the title bar” *and* “Show hidden files, folders, and drives”.
	* **To show filename extensions for Windows:** Open File Explorer, click the View tab at the top, select “File name extensions” under the Show/hide tab.


#### About files

* Why are some files hidden? <!--If you change something, however small, in some of these files, you can break your computer. Be careful!-->
* **Case sensitive** vs **case preserving**: Linux is **case sensitive**, meaning files with the same name but different capitalization are different files (e.g., `finalpaper.txt` is different than `FinalPaper.txt`). Mac OS and Windows are **case preserving**, but not case sensitive.
<!-- (This preference can be changed when configuring the filesystem, but certain programs will not run in a case sensitive environment, so it’s best to leave it alone). A case preserving file system will spell the filename as you type it, but if you create a different file with a name that differs only in capitalization, it will overwrite the first one. We recommend not creating filenames that differ only in capitalization even on Linux; not only is it potentially confusing, but you may be collaborating on a project with someone not on Linux. -->
* **SPACE** in a file/directory names. Why it could be problematic? 


### What is the shell? Why and how do we use it?

* The shell is a program that runs other programs. <!--Emphasize that the shell is still a program, which takes input and gives output. The input is a command, though, so it seems as though we’re doing something different. In reality, using command line is no different than using any other program.-->
* We use the shell to interact with the computer on the command line (CLI ~ GUI).
* The Unix philosophy is that you can _pipe_ (chain) together small commands, each of which does one thing well, to do something complex. You can’t do this in a GUI.
* bash = ‘Bourne again shell’ (the original Bourne shell is sh; others include csh, ksh, tcsh, zsh).
<!--We use and recommend bash (Git Bash). There are many different shells, some of which you end up downloading with program packages like Python.-->
* Learn the shell on a need-to-know basis.
<!--There are commands you’ll use every day, some you’ll use for special purposes (and you’ll look up how they work when you need them), and some that you’ll never need.-->

### Launching a terminal

* For Mac OS X: the **Terminal.app** that you will find in the Applications → Utilities folder. (Many Mac users prefer the free third-party <https://www.iterm2.com/>.)
* For Windows: the command prompt **cmd.exe** is the native Windows terminal, which we will use in this session. From a START menu, type in `cmd`. 
(For later sessions, we will switch over to **bash**, which you downloaded and installed as part of Git. This is the command line interface we use and recommend.)
* For Ubuntu Desktop (Unity): you can hit Ctrl-Alt-T or you can type `Terminal` into the Search box.


### Moving through a filesystem
<!-- Move the programs and files stuff in here, use cmd.exe -->
<!-- where is home?  both in cmd and in gui-->
<!-- language differences for gui and command line-->


* Navigate up and down, with emphasis on the paths in the title bar.
<!-- We should clarify that Git Bash will use forward slashes rather than backslashes, and explain later when we introduce cmd why that's the case.-->
* Drive letter: `C:\Users` (Windows cmd), `/c/Users` (Windows git bash), `/Users` (Unix, including Mac OS: no drive letter).
* `cd`: change directory
<!--Open a command line and begin using `cd`. Explain that `cd` is essentially the same as selecting or clicking a folder. `cd` into your home directory.-->
* `dir`: list all files (Windows)
* `ls`: list all files (Mac, bash)
<!--Use `ls` to show all the files in your current (when you first open the terminal, home) directory. Compare that to what you now see in your home directory (or C drive "folder"). Then use `cd Documents` to move into your documents folder. This is a relative path, as you’ve navigated relative to where you’ve started. Explain what an absolute path looks like, and try running one. Then run a few relative paths.-->

### File/directory path in file explorer GUI vs. Terminal 
* How to match up Destkop GUI's file path and file/directory path in terminal
* Non-Enlglish OS may have translation/localization applied, but only on the GUI side! 
	* In Spanish Windows, a user's Documents folder would appear as 'Usarios > jeremy > Documentos'
	* The same folder will appear in command line as `C:\Users\jeremy\Documents`

### External drives and mounting
How removable and external drives (such as a USB thumbdrive) are treated in GUI vs. terminal environment
* In Windows, they are assigned a new drive letter: `d:\` `e:\` (cmd), `/d/` `/e/` (git bash)
* In Mac OS, they are mounted underneath `\Volumes`
 
	
### How to run program as an administrator
* Windows: right click on a program icon (say, Command Prompt) and select "Run as administrator". 


### Environmental variables (aka system variables)
* How to view system variables through Desktop GUI?
	* Windows:
	* Mac: 
* How to view system variables in a terminal?
	* Windows (cmd): `set`
	* Mac (bash): `printenv`