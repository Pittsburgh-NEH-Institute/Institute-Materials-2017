# The command line

## Getting started

Although it’s sometimes called “the Unix shell”, Windows, Mac, and Linux all come with command line interfaces that support many of the same commands:

* For Mac OS X: the **Terminal.app** that you will find in the Applications → Utilities folder. (Many Mac users prefer the third-party <https://www.iterm2.com/>.)
* For Windows: **Windows Powershell**, which you can find from the search box. (Some versions of Windows 10 also support **bash**, which is preferable if you can run it. See [How to install and use the Linux bash shell on Windows 10](https://www.howtogeek.com/249966/how-to-install-and-use-the-linux-bash-shell-on-windows-10/) for details. Although **cmd.exe** is the traditional Windows shell, and you may even have used it previously, we recommend **bash** if you are able to run it on your version of Windows, and **Windows Powershell** otherwise.)
* For Ubuntu Desktop (Unity): you can type Ctrl-Alt-T or you can type **Terminal** (without the quotation marks) into the Search box.

The shell is a window on your desktop where you type commands and then run them by pressing the Enter (or Return) key. When it’s your turn to type, the shell displays a _prompt_, which may look something like:

* On Mac: `Taras-Mac:~ tara$`
* On Windows: `PS C:\Users\Tara L Andrews>`
* On Linux: `tla@ubuntu:~$`
	
The text of the prompt is configurable, and by default it adapts to the machine and user, so yours will look different from ours, but unless you’ve specified otherwise, it will end with either a dollar sign (`$`) or a right angle bracket (`>`).

## Tutorials

* Software Carpentry’s [Unix shell](http://swcarpentry.github.io/shell-novice/)

## Shell commands by category

These lista are deliberately only brief reminders of the available commands. To get more information about a command, type `man command-name` (replacing “command-name” with the name of the command you are looking up).

### Getting oriented

Command | Mnemonic | What it does
---- | ---- | ----
**cd** | **c**hange **d**irectory | by itself takes you to your home directory,<br/>otherwise specifies a destination
**pwd**  | **p**rint **w**orking **d**irectory | displays your current location in the filesystem
**whoami** | [none] | displays your userid
