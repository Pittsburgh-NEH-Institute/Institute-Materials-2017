# XPath navigation

## Why XPath?

XPath is a technology for traversing an XML document to perform tasks like “find all speeches by Hamlet” or “find all chapters that contain only one paragraph”. Developers use XPath to explore their XML and ways to interact with it, but XPath is also important as an *ancillary* technology used by XSLT (to transform XML), XQuery (to … er … query XML), or Schematron (to validate XML against constraint rules). Everything interesting that we can do with XML starts from XQuery!

We’ll use XPath in this Institute to examine what it means to interact with documents that have been modeled as ordered trees. It turns out tht some traversal are easier than others, not only because of the distance and route, but also because XPath deals more idiomatically with some types of traversal than others.

## XPath components

### Overview

XPath consists of three principal types of components:

* **Path expressions** are used to navigate and traverse the tree. For example, we can use a path expression to find all speeches in a play.
* **Functions** take input (typically from the tree) and produce output. For example, we can use an XPath function to take each speech in an XML document (a single string of text) and separate it into words by dividing on white space or punctuation.
* **Predicates** filter XPath expressions. For example, we can use an XPath expression to find all speeches in a play and then use a predicate to return only those spoken by Hamlet, or only those spoken by Hamlet that contain more than 100 words.

### Path expressions: walking the tree

Open `hamlet.xml` from schedule/week_2 in your local repo. In the upper right, configure the XPath browser box to use XPath 3.0. You’ll type XPath expressions into the browser box and hit `Return` to navigate within the document.

This document is a TEI-encoded edition of a play. To navigate within an XML document you need to know how it has been marked up. If it’s in TEI, you can rely on what you know about TEI. If not, skim through the document in \<oXygen/\> to explore how it tags different components.

Path basics:

* Paths are made up of path steps. Each one starts from the current location; where you end up becomes the new “current location” for the next step.
* A slash means “look at the children of the last path step”. 
* A double slash means “look at the descendants of the last path step”. It is also possible to navigate upward (to parents and higher ancestors), leftward (to preceding siblings or all preceding nodes), and rightward (to following siblings or all following nodes). 
* Because trees are fully connected, from any location in the tree there is at least one path to any other location or set of locations. 

Sample paths:

* `/TEI/text/body/div` finds all acts. A path expression that begins with a slash starts at the docuemnt node, the top of the document tree. Each subsequent slashes navigates to the children of the last step.
* `//body/div` finds all acts. A double slash means “look at my descendants”. A path that begins with a double slash means “start at the document node and look at the descendants”, that is, look at everything.

## XPath functions

* `//body/div/count(descendant::sp)`. This counts the speeches in each act. The last path step is a function, it counts the descendants of the preceding path step, that is, of each act.

## Filtering with predicates

* `//body/div[2]` finds Act 2. This is a *numerical predicate*. It finds all acts and then filters them to keep only the second in the sequence.
* `//body/div[descendant::speaker = 'Ophelia']`. This finds all acts and filters them to keep only the ones that have a descendant `<speaker>` element of “Ophelia”, that is, all acts in which Ophelia speaks.

## Your turn

* How many scenes are there in each act? Hint: Acts are `<div>` children of `<body>` and scenes are `<div>` children of acts. The answer for the five acts, in order, is is 5, 2, 4, 7, 2.
* In which scenes does Hamlet speak? Hint: If Hamlet speaks in a scene, that scene has a descendant `<speaker>` element equal to the string 'Hamlet'. The answer is that Hamlet speaks in Act 1, Scene 2; Act 1, Scene 4; Act 1, Scene 5; Act 2, Scene 2; Act 3, Scene 1; Act 3, Scene 2; Act 3, Scene 3; Act 3, Scene 4; Act 4, Scene 2; Act 4, Scene 3; Act 4, Scene 4; Act 5, Scene 1; and Act 5, Scene 2.
* If you’ve completed the preceding tasks, feel free to explore the ones linked at <http://dh.obdurodon.org/#xpath>. The answer keys are there, with explanations, so you can check your results.
 
## Further reading

* [What can XPath do for me?](http://dh.obdurodon.org/introduction-xpath.xhtml)
* [XPath and XQuery Functions and Operators 3.1
W3C Recommendation 21 March 2017](https://www.w3.org/TR/xpath-functions-31/)