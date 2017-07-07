# Command line 1
__________

### What is the shell? Why and how do we use it?

* The *shell* is a program that runs other programs, typically in a Unix environment. <!--Emphasize that the shell is still a program, which takes input and gives output. The input is a command, though, so it seems as though we’re doing something different. In reality, using command line is no different than using any other program.-->
* We use the shell to interact with the computer on the command line (CLI ~ GUI).
* The command-line-based window that runs a shell is called a *console* or a *terminal*. 
* The Unix philosophy is that you can _pipe_ (chain) together small commands, each of which does one thing well, to do something complex. You can’t do this in a GUI.
* bash = ‘Bourne again shell’ (the original Bourne shell is sh; others include csh, ksh, tcsh, zsh). <!--We use and recommend bash (Git Bash). There are many different shells, some of which you end up downloading with program packages like Python.-->
* Learn the shell on a need-to-know basis. <!--There are commands you’ll use every day, some you’ll use for special purposes (and you’ll look up how they work when you need them), and some that you’ll never need.-->


## Launching the shell

* For Mac OS X: the **Terminal.app** that you will find in the Applications → Utilities folder. (Many Mac users prefer the free third-party <https://www.iterm2.com/>.)
* For Windows: Although **cmd.exe** is the native Windows command-line, we will be switching over to the **bash** shell. When you downloaded Git, you also downloaded **Git bash**, the command line interface. We will be using this as our shell for the rest of the institute. 
* For Ubuntu Desktop (Unity): you can hit Ctrl-Alt-T or you can type `Terminal` into the Search box.

## Windows shells (`cmd.exe`, Git bash, and others)

* In the past, you may have used `cmd.exe` or Windows Powershell, both native to Windows. Though each has its own benefits and drawbacks, for the purposes of this course we will use Git bash.
	* We do not recommend “Ubuntu Bash on Windows,” which is still in beta.
* Git bash is missing certain commands (that are included in regular bash): `nano`, `sudo`, and `man`.  
	* Nano is a text editor; you can substitute Notepad, which you can run using `notepad myfile.txt`.  
	* `sudo` is a command that allows you to change things as an admin and requires your credentials.  Any files or directories you create using `sudo` will not be available to you later.  This command is generally used to solve user generated errors when installing software, so use with caution.
	* `man` displays a command manual, and there is no equivalent in Git bash. You will need to look up online at <https://ss64.com/bash/>. 
* Certain Windows applications are meant to run within `cmd`, and those need to be launched through a command called `winpty`. For example, to run an interactive python session, you should execute `winpty python`. 

## Getting oriented

* When you see `$` (shell prompt): the shell is waiting for you to provide input
* When you type `$`: you’re beginning to type a variable name (see below)
* When you see `>` (shell continuation prompt): you’ve started entering multiple-line input, and the shell is waiting for the next line
* When you type `>`: you’re writing output into a file, instead of displaying it on the screen (see below)
* If you type a command and find yourself on a blank line with nothing happening: you typed an incomplete command, and should abort it with `Ctrl+c`

## First commands

* `cd`: change directory. also `cd ..`, `cd ~`
* `pwd`: print working directory (current location in filesystem)
* `whoami`: print login id
* `clear`: clear the screen (keyboard shortcut: `Ctrl+l` [that’s a lowercase “L”, not the digit “1”])
* absolute vs. relative paths: absolute paths start from the root `/`, while relative paths reference the current working directory. 

## Explore your files

* `ls`: list files<!--Use `cd` to navigate to your home directory, and then `ls -a` to show all files and directories, including hidden ones. From there, use `cd Documents` to move into that directory.--> 
* `echo`: echoes a string to stdout<!--Using `echo`, write the string ’Hello world!’ to the screen.-->
* stdin, stdout, stderr<!--Remember that Bash is a program, it just happens to be a program you use to run other programs. This means that you’re constantly editing files while you use Bash: these are called Standard Input (stdin), Standard Output (stdout), and Standard Error (stderr). You write input at the command line, the program processes your command, and any output is written to stdout. If you run into an error, output is written to stderr, which prints to your screen the same way stdout does. This means that you may purposely (or accidentally print to either). For now, we’ll just print to stdout, which is the default.-->
* `touch`: create a file, or update its timestamp <!--Use `touch sample.txt` to create a new plain text file in your Documents folder.-->
* Redirecting stdout with `>`<!--Instead of printing your greeting, which you created with `echo ’Hello world!’` earlier, we can redirect it to a file using a right angle bracket. Type `echo ’Hello world!’ \> greeting.txt`. Notice that nothing is printed to your screen. --> 
* `cat`: view and combine files<!--Now that we’ve written a file, we can view it using `cat`, which is short for "concatenate". It has a multitude of uses, but for now we’ll just use it to print the contents of our file to stdout. `cat greeting.txt`.-->
* `less`: display a file one page at a time<!--Another useful command for longer files, as it prints only one screen at a time.--> 
* `grep`: find text inside files<!--`grep` takes two arguments: the regex (not just string) you’re searching for and the file you want to search in. If you don’t supply a file, it searches stdin. Try using the command `grep "Hello" greeting.txt` (mind your capital letters!). The entire contents of the file is written to stdout because `grep` returns the entire line that contains the search pattern, and this file has only one line. If you try searching for "hello" (or some other capitalization difference), you’ll see nothing printed to stdout. We use the `-i` switch to turn off case sensitivity. The switch comes directly after the command, before any arguments. Try `grep -i "hElLo WoRld" greeting.txt`.-->

## `ls` switches

* `ls -a`: include hidden files (filenames starting with `.`)
* `ls -l`: show enhanced file information, including date and time stamps, owner and group, permissions
* `ls -t`: list in timestamp order
* `ls -G`: colored output<!--If you’re using Git Bash, your list will already be colorized, but for other shells this command colorizes output so filetypes and directories are different.-->

## Making things easier

* Command and filename completion with the `Tab` key
* Command history with the arrow keys
* RTFM with `man` (user manual). Windows users on Git Bash don’t have this luxury, unfortunately; <https://ss64.com/bash/> doesn’t match the Git bash command inventory exactly, but it’s close.
* To turn off case sensitive tab completion, create a file called `.inputrc` in your home directory (you can use any text editor). In the file, write `echo ’set completion-ignore-case On’` and save. The next time you open your bash shell, you should be able to use tab completion without thinking about capitalization.<!-- This helps you find things quickly when you have a small number of files, but it also generates a lot of false hits when you have many files. -->

## Working with directories

* `mkdir`: make directory.<!--Use `pwd` to make sure you’re still in your Documents directory, then `ls -a` to see all the directories currently inside it. We’ll use `mkdir` to create a new folder called sample: `mkdir sample`. Once you’ve done this, check to see it’s there using `ls -a`.-->
* `rmdir`: remove empty directory.<!--Now that we’ve created an empty directory, we can use `rmdir sample` to get rid of it. Of course, we actually do want to have that directory, so make a new one called salutations: `mkdir salutations`.-->
* `rm -rf:` remove directory and its contents recursively (careful!).<!--We won’t use this one yet, as our directory has no files. However, you should note that `rmdir` will only remove an empty directory, while this command will loop over the directory and remove its contents before removing the directory itself. We caution you to be careful with it, as you can accidentally remove significant files or lose important work.-->

## Working with files

* `cp`: copy<!--This copies a file to another location. This command takes two arguments: the file or directory you’re trying to copy, and the location to which you want to copy. This can be an entirely new file name, and you don’t have to create the file ahead of time. You can accidentally overwrite data if you aren’t careful about where you’re copying to. For now, we’re going to copy our greeting file into our salutations directory using `cp greetings.txt ./Salutations`. This creates a copy of the file inside the directory. Notice that we use a `.` to show the current directory. This is a relative path, meaning it is dependent upon the current context to know where we want to copy the file. Use `ls` to look at your Documents directory. greeting.txt is still there, unchanged. Navigate into your Salutations directory and list its contents. You have another greeting.txt file there as well, and if you echo it to stdout, you see it contains the same text as the original. Note that you’ve just made a copy, not a link, so any changes you make to one will not be reflected in the other.--> 
* `mv`: move and rename<!--Within your Salutations directory, use the `rm` command to get rid of the file you just copied in (`rm greeting.txt`). Then, move back into your Documents directory using `cd ..` and list all files. greeting.txt is still there, but let’s move it and change its name. `mv` also takes two arguments: what you want to move, and where you want to move it to. Again, you can accidentally overwrite data, as moving a file to a specific filename will simply write over that file. To move our file, we’ll use `mv greeting.txt ./Salutations/hello.txt`. Take a look around those two directories to see what has changed.-->
* `rm`: delete (careful!)
* `rm -i`: delete after asking permission<!--These two have been addressed already, but the `-i` switch makes deleting interative. Before any file is deleted, the prompt asks you if you’re sure, to which you can respond ’y’ or ’n’. Though this seems like it may be a pain, it’s particularly useful combined with the recursive `-rf` switch, as it will go through a directory and ask about each file.-->

## Getting around the file system

* `cd -`: go back to the directory you came from
* `cd` or `cd ~`: go to your home directory
* `ctrl+r`: initiate history search
* `..`: parent directory
* `.`: current directory (Why might you need this?)
* `~`: home directory

## More useful commands

* `wc` (`-l` lines, `-w` words, `-c` characters)
* `cat` (you might have meant `less`)
* `less` (shows the file, but only one screen of it)
* `sort` (`-r` reverse, `-u` unique, `-g` numeric)
* `uniq` (only on sorted input)
* `head` (`-10`, or any other number)
* `tail` (`-10`, or any other number)
* `echo` (e.g., `echo $HOME`, `echo a*`)
