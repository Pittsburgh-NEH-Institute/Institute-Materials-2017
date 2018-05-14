# Introducing XQuery

## A 10-minute introduction to XQuery

Michael Kay's [Learn XQuery in 10 Minutes](http://www.stylusstudio.com/xquery-primer.html) tutorial will take you more than 10 minutes to do, but is a great resource for reference. Kay describes XQuery "as a query language for data stored in XML form. So its main role is to get information out of XML databases — this includes relational databases that store XML data, or that present an XML view of the data they hold." Unlike XSLT, which is a programming language for transforming XML documents, XQuery is not written in XML. For this reason, it's more intuitive (if you've ever worked with a database language before, it's very similar) and easier to write than XSLT. Because you use it in a database, it allows you to write dynamic HTML to serve on a website and allows you to query many documents at a time. Don't let learning XQuery turn you away from using XSLT; although they overlap for many uses, XSLT can still more useful, and in many cases simpler, than XQuery.

We will explore XQuery in eXist-db. [eXist-db.org homepage](http://exist-db.org/exist/apps/homepage/index.html)
Direct download: <https://bintray.com/existdb/releases/exist/3.3.0/view>

eXist-db 3.3.0 requires Java SE 1.8, so if you did not install it earlier this week (or have it installed) please do so now: <http://www.oracle.com/technetwork/java/javase/downloads/index.html> 

We will use eXide the integrated development environment (IDE) of eXist-db. 
After you installed eXist-db you find its IDE here: <http://localhost:8080/exist/apps/eXide/index.html>

You have all function help and documentation [available locally](http://localhost:8080/exist/apps/fundocs/index.html). You can check the documentation out in our demo server: <http://demo.exist-db.org/exist/apps/fundocs/index.html> inside the database. You also run eXide and use interactive tutorials on the demo server any time you like.

When in the IDE you will notice some similarities and differences of XQuery compared to the previously learned languages, e.g. Python, Bash shell scripting and XPath. 

For these tutorials, we'll be using the following XML documents, which you can download from the GitHub repo, or by clicking the link, using Ctrl + a, and copying into an XML document. You'll want to move the document into a folder in your eXist database, which you can do by clicking the "Collections" page once you've gotten the program set up and running.

* [test_1.xml](test_1.xml)
* [test_2.xml](test_2.xml)
* [ozymandias.xml](ozymandias.xml)
* [ozymandias_2.xml](ozymandias_2.xml)
* [hamlet.xml](hamlet.xml)

## Quick notes

* Error messages are given inbetween the query area and the result area (usually the important information is at the end), or along the bottom if you've shifted your result area to the right side of your screen.  
* Don't forget to look at the keyboard shortcuts, e.g. using `Ctrl+Enter/Cmd+Enter` will save you some time executing the queries.
* In the result area you can page forward and backwards with the double arrows showing if your result set is larger than your page size.

## Namespace declaration and function call

When writing XQuery for TEI texts, or any text in a namespace, you must use `declare namespace tei="http://www.tei-c.org/ns/1.0";` in order to traverse the documents.

In order to start writing XQuery to explore documents, we first have to call those documents. The eXist-db is a hierarchical file system with a single root directory, so we can navigate to a file with a path like any other. The eXist database maintains an index of your files to make queries quicker and more efficient, so when you travel through the hierarchy, you're telling the database where to look in those indexes.

To call the specific document or collections you wish to work with from the database, you'll set a variable either the `doc()` or `collection()` function, with the full path as the argument, like this:

```let $data := doc("/db/neh-2017/hamlet.xml")```

or

```declare variable data=doc("/db/neh-2017/hamlet.xml");

Notice that the use of the `let` statement requires a `$` before the variable name and a `:=` rather than just an equals sign, while the `declare` statement requires a semi-colon at the end. These small differences exist because of FLWOR statement constructions, which we'll get into a little bit later on. 

In summary, each XQuery you write will begin with something like the following:

```
xquery version "3.1";
declare namespace tei="http://www.tei-c.org/ns/1.0";

let $data := collection("/db/neh-2017")
```
If you aren't sure what namespace your documents are in (or if they have more than one namespace), you can call them using a wildcard namespace.

```
let $wildcards := $data//*:p  
```

## Writing XPath in eXide

All XPath works in eXist, for the simple reason that eXist includes an XPath parser because XQuery depends on XPath.  Not all XQuery will work in an 
XPath parser, however as of XPath 3.1, you can use `let` in your XPath expressions to declare variables. Below you'll find some XPath that finds the title of *Hamlet* that you can run in eXide:

```
declare namespace tei="http://www.tei-c.org/ns/1.0";
doc('/db/neh-2017/hamlet.xml')//tei:titleStmt/tei:title
```

This path returns the element, including the angle brackets and the namespace attribute. If we want just the title, we can use the `text()` node as the last path step.

## Using XQuery FLWOR expressions

FLWOR (pronounced 'flower') expressions make up most of the XQuery you'll write. The acronym stands for each clause type in an expression:
* **for** loops over items in a sequence
* **let** declares a variable and defines its value
* **where** filters items based on parameters you defines
* **order by** sorts items before returning them
* **return** returns the items


As an example, we'll write a FLWOR expression that does the same thing as our XPath above, separating each part of processing out into an individual step.

```
declare namespace tei="http://www.tei-c.org/ns/1.0";
let $hamlet := doc('/db/neh-2017/hamlet.xml')
let $title := $hamlet//tei:titleStmt/tei:title
return $title

```

If we want to return only the text of that title, we'll either append a `text()` node to the value of the $title variable, or we'll create another variable that adds that path step to $title and calls it something else.

Writing expressions this way is useful because it lets you save intermediate variables on your way to a solution. Let's say you want to create a variable to count the number of distinct speakers in the play. To do this in XPath, you would write a single path:
```
declare namespace tei="http://www.tei-c.org/ns/1.0";
count(distinct-values(doc('/db/neh-2017/hamlet.xml')//tei:speaker))
```

Everything happens in one line here, which makes it significantly more difficult to alter the output once you've gotten it.

With a FLWOR expression, it's easier to segment, change, and build your results.

```
declare namespace tei="http://www.tei-c.org/ns/1.0";
let $hamlet := doc('/db/neh-2017/hamlet.xml')
let $speakers := $hamlet//tei:speaker
let $distinct := distinct-values($speakers)
let $count := count($distinct)
return $count
```

No one would ever write such a simple expression this way, but this example shows you how you can create individual steps by declaring variables. If we wanted to change this to focus on a single scene, to get us the distinct speakers for each act, or to count those speakers by act, we can do so by adding a few lines and editing the result. Play around with writing your own clauses, and then we'll tackle Michael Kay's ["Blooming FLWOR - An Introduction to the XQuery FLWOR Expression"](http://www.stylusstudio.com/xquery-flwor.html) together.





