# Using bash on Windows

As part of “Ubuntu on Windows”, the Anniversary Edition of Windows 10 supports a real bash shell, with functionality similar to that available in bash on Linux. If you are running a version of Windows that supports the bash shell, we recommend using it instead of the older Windows PowerShell or cmd.exe. See <https://msdn.microsoft.com/en-us/commandline/wsl/faq> for Microsoft’s FAQ about Ubuntu on Windows.

Windows normally installs itself on your C drive, and your home directory is located in **C:\Users\username** (replace “username” with your username, the one you use to log in when you boot your machine). Note that Windows natively uses backslashes to separate paths, and it specifies a drive letter, followed by a colon, as part of a full path.

One side effect of using bash is that your C drive shows up in a different location in the Ubuntu on Windows subsystem, and you need to refer to it using Unix syntax (no leading uppercase drive letter plus colon, forward slashes between path steps instead of backslashes). In bash on Windows, you access your files through what is called a “mount point”, which will appear in the file path as **mnt**. The command you type at the bash shell prompt to get to your C drive is:

	cd /mnt/c

The Unix filesystem doesn’t have leading drive letters, so every full path begins at the root of the entire filesystem, which is represented by a leading forward slash. This command takes you to the root, moves into the mnt subdirectory, and then moves from there into the c subdirectory of mnt. Your files haven’t moved, though; if you go back to the PowerShell, you would still use the Windows navigation syntax there.

Your home directory in bash is in:

	/mnt/c/Users/username

(with your own username). Unix is case-sensitive, so the “c” has to be lower case and “Users’ has to have an initial upper-case “U”.

From your home directory, you can list the contents of your directory using the `ls` command. Inside your home directory you'll see directories like “Documents”, “Downloads”, and—if you’re a Dropbox user—“Dropbox”. To navigate into any of these, continue to use the change directory command `cd`.