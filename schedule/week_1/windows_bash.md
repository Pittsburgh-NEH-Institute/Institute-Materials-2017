# Using bash on Windows

## Git Bash (Windows 7 and above)

Git is a version control system used by developers to collaborate on, document, and organize project files.  While there is a GUI (graphical user interface), we recommend that you use command line git.  See the Git Resources page for tutorials and troubleshooting guides.

You can download Git at <https://git-scm.com/>.  Follow the downloading instructions available on Rebecca Parker's [Git Bash tutorial](http://newtfire.org/dh/explainGitShell.html#account).  Once you've downloaded and logged into your Github account, you can create or clone repositories and begin using Git.
### Creating Aliases

As you become increasingly comfortable at command line, you may find that some commands and their extensions are cumbersome to type repeatedly.  While Bash does a good job of shortening longer commands, it may make sense to create aliases for your often used commands.  In order to do this, we'll create a few files where we can save those preferences using Git Bash.

When you're browing files in the Git Bash shell, you'll want to start with your home directory.  Open a new shell and type **cd /c/Users/username** ("username" being your login username).  This will take you to your home directory.  If you are confused about where your home directory is, just type **echo ~**.  Once in your home directory, type **ls -a** to check for a .bashrc file.  If you already have a .bashrc file, you can type your aliases directly into that file.  Open it using a plain text editor, and be sure to save, close, and use the command **source .bashrc** to make it available to your shell.

If you do not have a .bashrc or .bash_profile file, we should create those now.  In the home directory, type **notepad .bash\_profile** and paste in the following:
>-f ~/.profile && . ~/.profile test -f ~/.bashrc && . ~/.bashrc

Save and exit, which will bring you back to the command line.  Create another file, this time **notepad .bashrc**.  In this file, you'll write your aliases.  For now, we'll just make an alias for the **rm -i** command, which asks permission before deleting a file.  This is an important alias to establish, as it can save you from deleting anything accidentally.  To establish and save an alias, type:
>alias rm="rm -i"

If you have any other aliases you'd like to add, write each one on a new line.  Save and exit your file, and then type **source .bashrc .bash\_profile** on the command line to make them available in your shell.  These aliases will be available in Bash on Ubuntu on Windows as well, which we detail below.


<!--## Bash on Windows 10

As part of “Ubuntu on Windows”, the Anniversary Edition of Windows 10 supports a real bash shell, with functionality similar to that available in bash on Linux. If you are running a version of Windows that supports the bash shell, we recommend using it instead of the older Windows PowerShell or cmd.exe. See <https://msdn.microsoft.com/en-us/commandline/wsl/faq> for Microsoft’s FAQ about Ubuntu on Windows.

Windows normally installs itself on your C drive, and your home directory is located in **C:\Users\username** (replace “username” with your username, the one you use to log in when you boot your machine). Note that Windows natively uses backslashes to separate paths, and it specifies a drive letter, followed by a colon, as part of a full path.

One side effect of using bash is that your C drive shows up in a different location in the Ubuntu on Windows subsystem, and you need to refer to it using Unix syntax (no leading uppercase drive letter plus colon, forward slashes between path steps instead of backslashes). In bash on Windows, you access your files through what is called a “mount point”, which will appear in the file path as **mnt**. The command you type at the bash shell prompt to get to your C drive is:

	cd /mnt/c

The Unix filesystem doesn’t have leading drive letters, so every full path begins at the root of the entire filesystem, which is represented by a leading forward slash. This command takes you to the root, moves into the mnt subdirectory, and then moves from there into the c subdirectory of mnt. Your files haven’t moved, though; if you go back to the PowerShell, you would still use the Windows navigation syntax there.

Your home directory in bash is in:

	/mnt/c/Users/username

(with your own username). Unix is case-sensitive, so the “c” has to be lower case and “Users’ has to have an initial upper-case “U”.

From your home directory, you can list the contents of your directory using the `ls` command. Inside your home directory you'll see directories like “Documents”, “Downloads”, and—if you’re a Dropbox user—“Dropbox”. To navigate into any of these, continue to use the change directory command `cd`.-->