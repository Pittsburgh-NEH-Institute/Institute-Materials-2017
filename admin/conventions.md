# Conventions, typographic and otherwise

For use in the NEH Institute

## Acknowledging the NEH

I have created a boilerplate footer in our _includes_ subdirectory as _neh\_credit.md_, which links (absolute, so the path will not require modification) to the NEH logo (in our _images_ subdirectory). As far as I can tell, GitHub markdown does not support include files, so we have to copy and paste this explicitly into any page where it is to appear manually. At the moment I've included it only in the main _README.md_ file in the root directory of our repo, and I’ll inquire at the NEH about whether that meets their needs, or whether they require it to appear on every page.

## General typography

Except where specified otherwise below, follow the typographic and other formatting conventions at <http://chimera.labs.oreilly.com/books/1230000000969/ch03.html>.

## Additions to O’Reilly typographic guidelines

### Menu items or links to click

An inline text link or the textual label of a menu item to be clicked by the user should be surrounded by curly double quotation marks. Example:

Click on the link to “REST Acceptance Tests” in the footer. 

### Apostrophes and quotation marks

Apostrophes and quotation marks _in narrative text_ should be _curly_ (_typographic_) ones, and not straight. To enter opening and closing curly _double_ quotation marks in Mac OS, type Opt+[ for opening and Opt+Shift+[ for closing. To enter opening and closing curly _single_ quotation marks in Mac OS, type **`Opt+]`** for opening and **`Opt+Shift+]`** for closing. Example:

Hamlet said, “Hello, world!”

Strings as data objects should be enclosed in double straight quotation marks, and should be wrapped in backticks like any other text to be typed by the user into a program. Example:

To print the string `"Hello, world"` in Python …

Glosses (translations, interpretations) should be enclosed in single curly quotation marks. Example:

… the use of the **`*`** character to mean ‘everything’ …
