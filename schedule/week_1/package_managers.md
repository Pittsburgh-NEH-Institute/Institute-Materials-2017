# Package managers

As you become more adept on the command line, you’ll learn about small, specialized Unix utilities used for system and file management that may not be installed by default on your MacOS machine. In a Unix/Linux environment, such programs are typically installed using a _package manager_, such as **apt-get** for Debian Linux or **yum** for Centos Linux. When these packages are ported to MacOS, they are often installed not by downloading a clickable **dmg** or **pkg** file, but by using a package manager on the command line. For example, when someone tells you that you can rename a bunch of files all at once with the [rename](https://www.tecmint.com/rename-multiple-files-in-linux/) command, and you try to run it on the command line and get a message that it doesn’t exist, you can use a package manager to install it.

## Mac
If you plan to install packages on MacOS, start by installing [Xcode](http://itunes.apple.com/us/app/xcode/id497799835), the MacOS development suite (allow a lot of time for the installation). Once that’s in place, there are three package managers in wide use on MacOS:

* [Homebrew](https://brew.sh/) (*recommended*)
* [MacPorts](https://www.macports.org/)
* [Fink](http://www.finkproject.org/)

They all work as advertised, and they often overlap in the resources they provide. Where there’s a choice, we usually prefer Homebrew because the installation procedure is generally faster and less complex.

## Windows
If you plan to install packages on Windows, your options are more limited:

* [Chocolatey](https://chocolatey.org) (*guardedly recommended*)
* [Cygwin](https://www.cygwin.com)

Chocolatey works more or less like the Mac package managers, but is new and still somewhat experimental. Cygwin is another, rather more heavyweight, way to run Unix software on Windows, which we will not cover in this bootcamp.
