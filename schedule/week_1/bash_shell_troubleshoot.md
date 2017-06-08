#Using Bash on Ubuntu on Windows for command line

[FAQ LINK](https://msdn.microsoft.com/en-us/commandline/wsl/faq)

Unlike the command prompt, Bash requires a few more path steps to get to the C drive.  You access your hard drive's files through what is called a "mount point," which will appear in the file path as mnt.  Below is the absolute path you can use to get access to your Documents folder.  

'$cd /mnt/c/Users/<your username here>'

From there, you can list the contents of your directory using command $ls.

Inside, you'll likely see directories like "Documents", "Downloads", and "Dropbox".  To navigate into any of these, continue to use the change directory command $cd.