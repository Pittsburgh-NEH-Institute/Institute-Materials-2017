# Computing requirements

This guide describes the minimum operating system (OS) and infrastructure requirements for the Institute.

## All users

* All users must bring a laptop running Microsoft Windows, MacOS, or Linux. Details about recommended and minimum OS requirements are below.
* You must have administrative rights to your machine, that is, you must be able to install new software. OS-specific instructions for checking this are below. If you use a machine issued by your employer, it is likely that you were not given administrative rights, and if that is the case, you should either arrange to have those rights configured or bring a different machine.
* All users must install Git. Follow the instructions for your OS at <https://git-scm.com/book/en/v2/Getting-Started-Installing-Git>.

## Windows

Windows users must be running a 64-bit version of Windows 10, 8, or 7. 

* **[Check your version]** If you can possibly upgrade to Windows 10, this would be a good time to do that.
* **[Check for 32 ~ 64 bit]** You must be running a 64-bit version of Windows. It is impossible to support some of the core Institute technologies on a 32-bit version of Windows.
* Windows 10 users should install the bash shell, following the instructions at <http://www.windowscentral.com/how-install-bash-shell-command-line-windows-10>. The Windows version of the bash shell works only in Windows 10.

## Apple

* Mac users must be running MacOS 10.10.3 (Yosemite) or later. You can check your OS version clicking on the apple image in the upper left corner of your screen and then selecting “About This Mac”. You can upgrade your OS version by clicking on the apple, then “App Store …”, then “Updates”.
* You can check for administrative rights by typing `sudo ls` and supplying your password when prompted. If you get a file listing of the current directory, you have administrative rights. If you get an error message, you don’t.
* 
## Linux

* Linux distros must meet the version requirements for Docker, as described at <https://docs.docker.com/engine/installation/linux/>. 
* You can check for administrative rights by typing `sudo ls` and supplying your password when prompted. If you get a file listing of the current directory, you have administrative rights. If you get an error message, you don’t.