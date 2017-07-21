# Exploring the model with XQuery
We have previously seen different ways to represent our models.
We have a set of xml documents:


* [test.xml](test.xml)
* [test1.xml](test1.xml)
* [ozymandias.xml](ozymandias.xml)
* [ozymandias_2.xml](ozymandias_2.xml)
* [hamlet.xml](hamlet.xml)

We will explore them with XQuery in eXist-db. [eXist-db.org homepage](http://exist-db.org/exist/apps/homepage/index.html)
Direct download: <https://bintray.com/existdb/releases/exist/3.3.0/view>

eXist-db 3.3.0 requires Java SE 1.8, so if you did not install it earlier this week (or have it installed) please do so now: <http://www.oracle.com/technetwork/java/javase/downloads/index.html> 

To our help we are going to use eXide the integrated development environment (IDE) of eXist-db. 
After you installed eXist-db you find its IDE here: <http://localhost:8080/exist/apps/eXide/index.html>

You have all function help and documentation available locally inside the database <http://localhost:8080/exist/apps/fundocs/index.html>. You can also check the documentation out in our demo server: <http://demo.exist-db.org/exist/apps/fundocs/index.html>. You can also run eXide and use interactive tutorials on our demo server any time you like.

When in the IDE we explore some similarities and differences of XQuery compared to the previously learned languages, e.g. Python, Bash shell scripting and XPath. 

Since XPath is a subset of XQuery the first query we enter is `0` or `"a string"`. If this query gives itself as result you are set to go!

* Error messages are given inbetween the query area and the result area (usually the important information is at the end).  
* Don't forget to look at the keyboard shortcuts, e.g. using `Ctrl+Enter/Cmd+Enter` will save you some time executing the queries.
* In theresult area you can page forward and backwards with the double arrows showing if your result set is larger than your page size.

Tomorrow we will continue with some more XQuery and the use it to explore your model in addition to our common documents above.
