# Exploring the model with XQuery 2

## Overview

### Goals

* General: become comfortable with XQuery
* Your own data: use XQuery to begin to explore your own data, especially with respect to features of the model. 

### eXide reminders 

* Use keyboard shortcuts. For example, `Ctrl+Enter` (Windows) or `Cmd+Enter` (MacOS) will save you some time executing the queries. You’ll find a list of keyboard shortcuts inside eXide: click on “Help” → “Keyboard shortcuts”.
* In the result area you can page forward and backwards with the double arrows if your result set is larger than your page size.

## Review of topics from [XQuery 1](xquery_1.md) session

* What is [eXist-db](https://exist-db.org), and how and why we use it
* Working with documents and namespaces
* Writing XPath in eXide
* Writing FLWOR statements in eXide 

## XQuery practice activity

### Explore a single document

We use `doc(/db/neh-2017/hamlet.xml`) because that’s where we’ve installed _Hamlet_ in our instance of eXist-db, but set the path to point to your own document (and use the correct namespace and element names).

```xquery
xquery version "3.1";
declare namespace tei="http://www.tei-c.org/ns/1.0";
let $data-doc := doc("/db/neh-2017/hamlet.xml")
let $heads := $data-doc//tei:head
for $head in $heads
return 
  if (contains($head,"a")) then $head else ()
```

### Quick questions

#### How may results do we get?

Two: “Dramatis Personae” and “Grave-diggers”.

#### What does `contains()` do and how does it work?

Look it up in the [function documentation](http://exist-db.org/exist/apps/fundocs/view.html?uri=http://www.w3.org/2005/xpath-functions#contains.2):

> _contains_
>                            
> `contains($source-string as xs:string?, $substring as xs:string?) as xs:boolean`
> 
> Returns an xs:boolean indicating whether or not the value of
$source-string contains (at the beginning, at the end, or anywhere
within) at least one sequence of collation units that provides a
minimal match to the collation units in the value of $substring,
according to the default collation.
> 
> **Parameters:**  
> `$source-string?`	The source-string  
> `$substring?`	The substring  
> **Returns:**  
> xs:boolean : true() if $source-string contains $substring, false() otherwise
```
#### How can you use this type of documentation to learn about XQuery? 

Note: The official documentation at [XPath and XQuery Functions and Operators 3.1
W3C Recommendation 21 March 2017](https://www.w3.org/TR/xpath-functions-31/) [see [§5.5.1 fn:contains](https://www.w3.org/TR/xpath-functions-31/#func-contains)]. is more complete and authoritative, but it may also be harder for new users to understand.

#### How does `if` work in the last line?

XPath and XQuery `if` structures have the following requirements:

* The condition (in this case, `contains($head,"a")`, which tests whether `$head` contains the character `"a"`) has to be enclosed in parentheses.
* There must be an `else` clause, even if you don’t want it to do anything. We specify “don’t do anything” with `()`, which represents an empty sequence.

In this case, for each `<head>` element we return the result of evaluating the `if` condition for that particular `<head>`. But we can do that evaluation earlier, with a `where` clause, if we want:

```xquery
xquery version "3.1";
declare namespace tei="http://www.tei-c.org/ns/1.0";
let $data-doc := doc("/db/apps/shakespeare/data/ham.xml")
let $heads := $data-doc//tei:head
for $head in $heads
where contains($head,"a")
return $head
```

#### Why do we need the `for` structure? 

We don’t! XPath and XQuery can return a sequence without iterating over it in a `for` loop:

```xquery
xquery version "3.1";
declare namespace tei="http://www.tei-c.org/ns/1.0";
let $data-doc := doc("/db/apps/shakespeare/data/ham.xml")
let $heads := $data-doc//tei:head
return $heads[contains(.,"a")]
```

In fact, we don’t need FLWOR at all for this task:

```xquery
xquery version "3.1";
declare namespace tei="http://www.tei-c.org/ns/1.0";
doc("/db/apps/shakespeare/data/ham.xml")//tei:head[contains(.,"a")]
```

Using an XPath expression to return a sequence that you filter with a predicate is sometimes called an _implicit `for`_.


### Functions

User-defined functions must be in a namespace. In XQuery (but not in XSLT) you can use the namespace prefix `local:` without having to declare it explicitly. Here’s an example of a pair of functions that cooperate to generate a [UUID](https://en.wikipedia.org/wiki/Universally_unique_identifier), prefixed with the generic identifier (element name), for each element in a document:

```xquery
xquery version "3.1";
declare function local:gen-uuid($prefix as xs:string) as xs:string {
  concat($prefix, '-', util:uuid())
};

declare function local:add-uid-attributes-to-fragment($item as item())
 as item() {
  typeswitch($item)
    case document-node() return
        for $child in $item/node()
        return local:add-uid-attributes-to-fragment($child)
    case element() return
      element {node-name($item)} {
        $item/@*,
        if ($item[not(@uid)]) then attribute {"uid"} {local:gen-uuid(name($item))} else (),
        for $child in $item/node()
        return local:add-uid-attributes-to-fragment($child)
      }
    default return $item
};

let $xml := 
    <stooges>
        <stooge type="primary">Curly</stooge>
        <stooge type="primary" uid="613a47fa-a524-456f-bec8-c89dbadde67d">Larry</stooge>
        <stooge type="primary">Moe</stooge>
        <stooge type="secondary">Joe</stooge>
        <stooge type="secondary">Shemp</stooge>
    </stooges>

return local:add-uid-attributes-to-fragment($xml)
```

This adds a UUID to each element as a `@uid` attribute value, unless the element already has a `@uid` attribute:
 
```xml
<stooges uid="stooges-1b308683-33f9-495c-9756-c3a7a9660529">
    <stooge type="primary" uid="stooge-1e393ed4-599b-4d9e-b079-c59ca0ed0501">Curly</stooge>
    <stooge type="primary" uid="613a47fa-a524-456f-bec8-c89dbadde67d">Larry</stooge>
    <stooge type="primary" uid="stooge-4d933ee2-1522-455f-a7f4-27acf98fd9b0">Moe</stooge>
    <stooge type="secondary" uid="stooge-f1c47a66-ee77-49a3-9ecf-111281b3a880">Joe</stooge>
    <stooge type="secondary" uid="stooge-90369a28-1cf4-4fd6-a2af-a8508a67a25f">Shemp</stooge>
</stooges>
```

(Your UUID values will differ from ours, and they’ll be different each time you run the query.)

While we doubt you'll need to give your elements unique UUIDs, this is a good example of how to write your own function to deal with complex problems.

### Working with your own texts

Add your own files to the database by clicking the “Collections” icon in your dashboard. Remember to add a new collection so you don't put your own work into the practice collection. When you're done, begin by writing XPath in the eXide window, and then adapting that into a FLWOR statement.

Challenge yourself by building on that initial query, or make a goal for processing an interesting feature in a new way. Instructors will be around to help.

