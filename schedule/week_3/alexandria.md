# Configuring Alexandria

Alexandria is a text repository and database that supports Text As Graph (TAG). We’ll use it in the Institute to gain perspective on modeling by exploring non-XML structured text representations.

##  What is Alexandria?
### Introduction
Briefly put, _Alexandria_ is a text repository system in which you can store and edit documents. It is the reference implementation of [TAG](https://huygensing.github.io/TAG/), a flexible graph data model for text. Here, the term "reference implementation" means that _Alexandria_ implements all the properties of the TAG model. So, by working with _Alexandria_ you'll learn more about TAG. And vice versa, if you want to experiment with the flexibilities of the TAG model _Alexandria_ is where you start. We already [talked about](https://github.com/Pittsburgh-NEH-Institute/Institute-Materials-2017/blob/master/schedule/week_2/tag.md) TAG and its modeling potential; now it’s time to experiment with it.

You'll quickly find out that _Alexandria_ is not just any text repository. It builds on the idea that a text can be studied from various perspectives. For example, you can model a text according to a textual perspective or a documentary perspective; you can focus on adding linguistic annotations of a text, or rather information about structure of its verses. In _Alexandria_, you can store those different perspectives on the same text. What is more, Alexandria is build along the principles of a distributed architecture. It is a command line tool and it can be integrated in your own editor of choice.

By bringing together a wide range of information about a text in a structural and distributed way, _Alexandria_ facilitates the exchange and reuse of scholarly data. In short, _Alexandria_ is a powerful modeling instrument for digital textual research.


### Why should I use it?
If you enjoy experimenting with data models and advanced text analysis, _Alexandria_ is the tool for you. If you're used to working with XML, it is highly enlightening to work with a data model in which you can easily model overlapping structures, discontinuous elements, and nonlinear text without having to resort to workarounds.

### Can I use it?
<<<<<<< HEAD
Yes, you can. Below you’ll find the installation instructions. We also created a [tutorial](https://huygensing.github.io/alexandria-markup-server/tutorial/) in the form of a [Jupyter Notebook](http://nbviewer.jupyter.org/github/DiXiT-eu/collatex-tutorial/blob/master/unit1/Jupyter_notebook.ipynb). The notebook contains blocks of text and small snippets of code: commands that you give to your version of Alexandria. You can run these commands from within the notebook. The notebook, in other words, is a secure environment for you to play around with and get to know _Alexandria_. [The tutorial](https://huygensing.github.io/alexandria-markup-server/tutorial/) explains in detail how _Alexandria_ works and what you need to oprate it.

## Installation
### 1. Download
An up-to-date version of _Alexandria_ can be downloaded from <https://cdn.huygens.knaw.nl/alexandria/alexandria-app.zip>

### 2. Unpack the zip
Unpack the zip to a new directory of your choice. Remember the path to that directory. Now you have to make sure that your machine can always find the `bin` directory that contains the _Alexandria_ code when you call it. You have three options:

#### 2a. Create a permanent alias in your .bash_profile
Open your .bash_profile. If you're on a Unix machine, you can type `open -a "Sublime Text" ~/.bash_profile` in your terminal window. This will open your bash_profile in the Sublime Text editor (of course you can use an editor of your choice).  

You can create an alias for _Alexandria_ by writing `alias alexandria="<path to alexandria>"`. For instance, your alias could say `alias alexandria="/Users/alexandria-markup-server/bin/alexandria"`. Save and close your bash_profile. Before the alias works, you have to resource the bash_profile: type `source ~/.bash_profile` in your terminal.

#### 2b. Add the directory your `PATH`
In your terminal window, type: 
```
export PATH=$PATH:<path to alexandria>
```
For example:
```
export PATH=$PATH:/Users/alexandria-markup-server/bin/alexandria
```
if that's where you've stored _Alexandria_. You can check if it works by typing
```
echo $PATH
```
in your terminal window. It should return something like the following, with the path to _Alexandria_ directory newly added at the end:
```
/usr/bin:/bin:/usr/sbin:/sbin:/usr/local/bin:/Users/alexandria-markup-server/bin/alexandria
```

#### 2c. Create a softlink
If you don't like to change your path, you can create a softlink.

A soft link (also known as a symbolic link or symlink) consists of a special type of file that serves as a reference to another file or directory. You can create them on your command line: 
```
$ ln -s {source-filename} {symbolic-filename}
```

For example: 
```
$ ln -s /Users/alexandria-markup-server/bin/alexandria /usr/local/bin/alexandria
```

Verify if it works by running 
```
$ ls -l /usr/local/bin/alexandria
```

Your output will look something like:
```
lrwxr-xr-x  1 veryv  wheel  5 Mar  7 22:01 alexandria -> Users/alexandria-markup-server/bin/alexandria
```
Notice the `->` that indicates the link between the link name and the file.

### Working with _Alexandria_

Keep in mind that both the TAG data model and the _Alexandria_ implementation are under development. This means that by using _Alexandria_ you will make a valuable contribution to the development process. We therefore encourage you to try it out and [share your thoughts](mailto:research-development@di.huc.knaw.nl). 

If the links in this file appear to be broken, we advise you to navigate to [the GitHub repository](https://github.com/HuygensING/alexandria-markup-server) of the project and download the latest version there. In this repository you also find detailed installation instructions.
