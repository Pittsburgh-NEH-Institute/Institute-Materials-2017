# Markdown and pandoc
____

## What is Markdown?
Markdown is a simpler way to create web pages.  Rather than writing this site in HTML 5, which is prohibitively structural and complex, Markdown documents do the work of presentation so you can focus on content.  By using hash marks, white space, and reserved characters, Markdown allows you to format simply and use prefab CSS packages to present your material online.

## Guidelines
Once you begin, Markdown is pretty easy to predict.  All formatting of paragraphs is done automatically, but other formatting elements are listed below  There are many [Markdown guides](https://guides.github.com/pdfs/Markdown-cheatsheet-online.pdf) available online.

### Headers
* h1: type # My title
* h2: type ## My secondary title
* h3: type ### My tertiary title

### Lists 
An unordered list item uses the asterisk at the beginning of the line, like below:

\* milk

\* eggs

\* bread

Ordered lists use a number followed by a period:

1. hummus
2. spinach
3. butter

The reserved character (either asterisk or digit-period) must be set off by a space directly after, otherwise Markdown prints it as text in a paragraph.

### Links
Linking can either be done with a full URL, such as http://www.github.com, or by using brackets around the desired link, followed directly by the URL in parentheses, as below.

\[Github\]\(www.github.com\)

### Code
Code is denoted using \`backticks\`, which make your code look like this:
`<greeting>Hello!</greeting>`

## Flavors
Markdown has many *flavors*, or syntax variations, that introduce differences into your documents.  Flavors exist for different implementations, so the program that renders your .md file into something presentable may treat your syntax differently than other program.  These differences are not generally significant.  We use Github flavored Markdown because we publish to a Git pages site, but there are plenty of [others](https://github.com/jgm/CommonMark/wiki/Markdown-Flavors).

## Implementations
* oXygen in-editor split screen
* pandoc
* [many more](https://github.com/jgm/CommonMark/wiki/Markdown-Flavors)

## What is Pandoc?
Pandoc is a way to convert a file from one form of markup to another. For example, you might have a text file written in Markdown format and want to convert it to LaTeX, HTML, or a number of other formats. Pandoc allows you to easily do this via the command line.

## Installing Pandoc

**Mac OS X**

Use the Mac OS X package installer at Pandoc's [download page](https://github.com/jgm/pandoc/releases/tag/1.19.2.1). You'll also need to install LaTeX for PDF output. We recommend [MacTeX](https://tug.org/mactex/).

**Windows**

Use the Windows package installer at Pandoc's [download page](https://github.com/jgm/pandoc/releases/tag/1.19.2.1). You'll also need to install LaTeX for PDF output. We recommend [MiKTeX](https://miktex.org/).

**Linux**

Try checking your package manager, since Pandoc might already be in your respository. If it is not already there, try installing with `apt-get install haskell-platform`. You'll also need to install LaTeX for PDF output. We recommend [TeX Live](http://www.tug.org/texlive/), which can be installed through your package manager with `apt-get install texlive`.

## Using Pandoc

Pandoc has no graphic user interface, so you will need to open the command line to use it.

### Check that Pandoc is installed

In your terminal window, type:

`pandoc --version`

If Pandoc is properly installed, a message with info about your installed version of Pandoc should appear.

### Create a subdirectory

Navigate to your Documents directory. To create a subdirectory called `pandoc-test`, type:

`mkdir pandoc-test`

Then navigate to the `pandoc-test` directory. Type:

`cd pandoc-test`

### Convert a file

Open a text editor where you can create a text file written in Markdown. Type:

	Test!

	This is a test of *pandoc*.

	- list one
	- list two

Save this text file as `test1.md` in your `pandoc-test` directory (`Documents/pandoc-test`). 

In terminal, make sure that you are in the `pandoc-test` directory, and type `ls` to view all of the files. You should see the `test1.md` file that you just created. Now we can try to convert this Markdown file to a different format.

####To HTML

`pandoc test1.md -s -o test1.html`

####To LaTeX

`pandoc test1.md -s -o test1.tex`

####To a Word document

`pandoc test1.md -s -o test1.docx`

####To a PDF

`pandoc test1.md -s -o test1.pdf`

### Check that the file has been converted

Type `ls` again. You should now see the newly converted file with the appropriate file extension. Try opening the file to see the converted version.