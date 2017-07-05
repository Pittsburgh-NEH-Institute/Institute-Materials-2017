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
