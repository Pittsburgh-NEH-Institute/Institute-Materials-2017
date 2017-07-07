# Monday, 9:00–10:30: Getting to know your OS: file and directory system

[Introduction; verify that everyone’s Internet connections work]

## File system hierarchy 

* What are files?
* What are directories/repositories/folders? <!--Thinking about why we call them folders: a folder and a piece of paper are the same, and can do some of the same things. A folder can also hold pieces of paper.-->
* What are programs? <!--Programs are files that can do something, but are still files nonetheless. Take a piece of paper out of your folder, fold it into an airplane, and throw it. It's still a piece of paper you can read from and write on, but it can fly.-->
* GUI file explorers and file hierarchy


## Configuring your machine to show hidden files
* **Mac OS:** 
	* Mac OS Sierra: Open Finder and hit `Cmd+Shift+.`
	* Mac OS El Capitan: Open the command line and execute `defaults write com.apple.finder AppleShowAllFiles YES`

* **Windows:** <[screenshot](images/getting_to_know_winconfig.png)> In any File Explorer window, click on “View” tab, and then “Options” on the right to open the “Folder Options” window. In the “View” tab, check “Show hidden files, folders, and drives” and select “Display the full path in the title bar” (not essential, but recommended).


## Configuring your machine to show filename extensions

* **Mac OS:** Open Finder and select Preferences, click Advanced, and check the box next to "Show all filename extensions".

* **Windows:** <[screenshot](images/getting_to_know_winconfig.png)> In the same "File Options" window as before, uncheck “Hide extensions for known file types” box.

## About files

* Why are some files hidden? <!--If you change something, however small, in some of these files, you can break your computer. Be careful!-->
* **Case sensitive** vs **case preserving**: Linux is **case sensitive**, meaning files with the same name but different capitalization are different files (e.g., `finalpaper.txt` is different than `FinalPaper.txt`). Mac OS and Windows are **case preserving**, but not case sensitive. <!-- (This preference can be changed when configuring the filesystem, but certain programs will not run in a case sensitive environment, so it’s best to leave it alone). A case preserving file system will spell the filename as you type it, but if you create a different file with a name that differs only in capitalization, it will overwrite the first one. We recommend not creating filenames that differ only in capitalization even on Linux; not only is it potentially confusing, but you may be collaborating on a project with someone not on Linux. -->
* **Spaces** in a file and directory names. Why could these be problematic? 


## Launching a terminal

* For Mac OS X: the **Terminal.app** that you will find in the Applications → Utilities folder. (Many Mac users prefer the free third-party <https://www.iterm2.com/>.)
* For Windows: the Command Prompt **cmd.exe** <[screenshot](images/getting_to_know_cmd.png)> is the native Windows console, which grew out of DOS.  We will be using it in this session. From a Start menu type in `cmd`. (For later sessions and the remainder of this institute we will be using the **bash shell** instead, which you downloaded and installed as part of Git. This is the command line interface we use and recommend.)
* For Ubuntu Desktop (Unity): you can hit Ctrl-Alt-T or you can type `Terminal` into the Search box.

## Moving through a filesystem
<!-- Move the programs and files stuff in here, use cmd.exe -->
<!-- where is home?  both in cmd and in gui-->
<!-- language differences for gui and command line-->

* Navigate up and down, with emphasis on the paths in the title bar. <!-- We should clarify that Git Bash will use forward slashes rather than backslashes, and explain later when we introduce cmd why that's the case.-->
* Drive letter: `C:\Users` (Windows `cmd`), `/c/Users` (Windows git `bash`), `/Users` (Unix, including Mac OS: no drive letter).
* `cd`: change directory <!--Open a command line and begin using `cd`. Explain that `cd` is essentially the same as selecting or clicking a folder. `cd` into your home directory.-->
* `dir`: list all files (Windows)
* `ls`: list all files (Mac, bash) <!--Use `ls` to show all the files in your current (when you first open the terminal, home) directory. Compare that to what you now see in your home directory (or C drive "folder"). Then use `cd Documents` to move into your documents folder. This is a relative path, as you’ve navigated relative to where you’ve started. Explain what an absolute path looks like, and try running one. Then run a few relative paths.-->

## File/directory path in file explorer GUI vs. shell 

* How to match up the GUI file path with the file/directory path in the terminal
* User-specific directories: where are your home directory, document folder, and desktop? What are their full file/directory paths? 
* Non-English OS’s may have translation/localization applied, but only on the GUI side! 
	* In Spanish Windows, a user’s Documents folder would appear in File Explorer as “Usarios > jeremy > Documentos”
	* The same folder will appear on the command line as `C:\Users\jeremy\Documents`

## External drives and mounting
How removable and external drives (such as a USB thumbdrive) are treated in GUI vs. terminal environment

* In Windows, they are assigned a new drive letter: `d:\` `e:\` (cmd), `/d/` `/e/` (git `bash`)
* In Mac OS, they are mounted underneath `/Volumes`
 	
## How to run a program as an administrator

* Windows: right click on a program icon (say, Command Prompt) and select “Run as administrator”. 
* Mac: `sudo` on the command line; no equivalent method in GUI.  

## Environment variables (aka system variables)

* How to view system variables in a terminal
	* Windows (`cmd`): `set`
	* Mac (`bash`): `printenv`
* How to view system variables through a GUI
	* Windows:
	* Mac: Mac OS does not provide a GUI interface to the environment. Use the command line.
