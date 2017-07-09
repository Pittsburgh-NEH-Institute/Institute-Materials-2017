# Command line 1 (Windows)
* The three Command Line lessons are based on the wonderful [Software Carpentry's materials](http://swcarpentry.github.io/shell-novice/). 
* **Windows users** will work through a **special breakout session** for Command Line 1 only. We will cover:
  *  Setup [http://swcarpentry.github.io/shell-novice/setup/]
  1. Introducing the Shell [http://swcarpentry.github.io/shell-novice/01-intro/]
  1. Navigating Files and Directories [http://swcarpentry.github.io/shell-novice/02-filedir/]
  1. Working with Files and Directories [http://swcarpentry.github.io/shell-novice/03-create/]
	

__________

## Setup
* Download the zip file from the Software Carpentry's [Setup page](http://swcarpentry.github.io/shell-novice/setup/). 


## What is the shell? Why and how do we use it?

* The *shell* is a program that runs other programs, typically in a Unix environment. <!--Emphasize that the shell is still a program, which takes input and gives output. The input is a command, though, so it seems as though we’re doing something different. In reality, using command line is no different than using any other program.-->
* We use the shell to interact with the computer on the command line (CLI ~ GUI).
* The command-line-based window that runs a shell is called a *console* or a *terminal*. 
* The Unix philosophy is that you can _pipe_ (chain) together small commands, each of which does one thing well, to do something complex. You can’t do this in a GUI.
* bash = ‘Bourne again shell’ (the original Bourne shell is sh; others include csh, ksh, tcsh, zsh). <!--We use and recommend bash (Git Bash). There are many different shells, some of which you end up downloading with program packages like Python.-->
* Learn the shell on a need-to-know basis. <!--There are commands you’ll use every day, some you’ll use for special purposes (and you’ll look up how they work when you need them), and some that you’ll never need.-->


## Launching a terminal/console

* For Windows: We will be switching over to the **bash** shell. When you downloaded Git, you also downloaded **Git bash**, the command line interface. We will be using this as our shell for the rest of the institute. 

## Git bash vs. Windows command lines

* In the past, you may have used `cmd.exe` <[screenshot](images/getting_to_know_cmd.png)> or Windows Powershell <[screenshot](images/command1_powershell.png)>, both native to Windows. Though each has its own benefits and drawbacks, for the purposes of this institute we will have everyone learn Git `bash` <[screenshot](images/command1_gitbash.png)>.
	* You might have heard of [“Ubuntu Bash on Windows 10”](https://msdn.microsoft.com/en-us/commandline/wsl/about). We do not recommend it—ask us why later! 
* Why is learning `bash` a good idea? 	
* The Git `bash` filesystem adopts a Unix-like convention: it uses `/` as the path separator, and absolute paths start with `/c/`, `/d/`, etc. (So, `/c/Users/narae` instead of `C:\Users\narae` in `cmd`.) 
* Git `bash` is missing some commands that are included in regular `bash`, e.g., `nano`, `sudo`, and `man`.
	* `nano` is a text editor. You can substitute Notepad, which you can run using `notepad myfile.txt`. 
	* `sudo` allows you to change features that require elevated administrative permissions. Any files or directories you create using `sudo` will not be available to you without `sudo` later. `sudo` is generally used to solve user-generated errors when installing software, so use it with caution.
	* `man` displays a command manual, and there is no equivalent in Git `bash`. You can look up commands on line at <https://ss64.com/bash/>. 
* Git `bash` requires the use of `winpty` when running certain Windows applications that are meant to run within `cmd`. For example, to run an interactive python session, you should execute `winpty python`. 

## Getting oriented

* When you *see* `$` (shell prompt): the shell is waiting for you to provide input
* When you *type* `$`: you’re beginning to type a variable name (see below)
* When you *see* `>` (shell continuation prompt): you’ve started entering multiple-line input, and the shell is waiting for the next line
* When you *type* `>`: you’re writing output into a file, instead of displaying it on the screen (see below)
* If you type a command and find yourself on a blank line with nothing happening: you typed an incomplete command, and should abort it with `Ctrl+c`

## Files and directories
* We will work from the Software Carpentry lessons. 
