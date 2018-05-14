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

### XQuery 3 features

Even if you have prior experience with XQuery 2.0, you should acquaint yourself with new features available in XQuery 3.1, including:

* maps
* arrays
* the arrow operator
* string constructors

Here are some examples:

```xquery
xquery version "3.1";
declare namespace array="http://www.w3.org/2005/xpath-functions/array";

(: Maps :)
let $map-empty := map { } (: empty map :)
let $map-two-entries := map { 'boolskt': true(), 'sequence': (<a>a</a>, <b>b</b>) }  (: map with two entries :)
let $map-ten-entries := 
map:merge(                                  (: map with ten entries :)
  for $i in 1 to 10
  return map { $i: 'value ' || $i }
)
let $map-put := map:put($map-empty, "put", $map-two-entries?sequence)
let $map-neh := map { 'what': 'NEH-Instutute', 'when': 2017, 'where': 'Pittsburgh' }

(:  Arrays :)
let $array-empty := [] (: empty array :)
let $array-one-member := [ (1, 2) ]    (: array with single member :)
let $array-two-members := array { ('ett', 'två'), 'tre' }  (: array with two members :)
let $array-three-members := array { 1 to 2, 'TRE' }  (: array with three members :)
(: array:size() :)
(: Arrow operator :)
let $seq-three-items := ('ett', 'två', 'tre' )

(: String constructors :)
let $string-constr := ``["A new way to 'create' strings."]``
let $string-constr-var := ``["A new way to use variables in, `{$seq-three-items}`, strings."]``
return 
    <root>
        <map>{$map-two-entries?boolskt}</map>
        <map>{$map-two-entries?sequence}</map>
        <map>{$map-ten-entries?5}</map>
        <map>{$map-ten-entries?((1, 3))}</map>
        <map>{$map-ten-entries?*}</map>
        <map>{$map-put?put}</map>
        <map>{$map-neh?('what')}</map>
        <map>{$map-neh?where}</map>
        <map>{$map-neh?where[. = 'Pittsburgh']}</map>
        <array>{$array-empty}</array>
        <array>{try { $array-one-member(2) } catch err:FOAY0001 { "Expected error: index greater than actual size" } }</array>
        <array>{$array-two-members(2)}</array> 
        <array>{$array-three-members?2}</array> 
        <array>{$array-three-members(3)}</array>
        <array>{array:reverse($array-three-members)}</array>
        <array>{$array-three-members?*}</array>
        <arrow>{$seq-three-items => count()}</arrow>
        <arrow>{$seq-three-items => string-join("-") => upper-case()}</arrow>
        <array>{for $i in 'NEH-Institute' => string-to-codepoints() return $i}</array>
        <string-constr>{$string-constr}</string-constr>
        <string-constr>{$string-constr-var}</string-constr>
    </root>
```

The output is:

```xml
<root>
    <map>true</map>
    <map>
        <a>a</a>
        <b>b</b>
    </map>
    <map>value 5</map>
    <map>value 1 value 3</map>
    <map>value 1 value 2 value 3 value 4 value 5 value 6 value 7 value 8 value 9 value 10</map>
    <map>
        <a>a</a>
        <b>b</b>
    </map>
    <map>NEH-Instutute</map>
    <map>Pittsburgh</map>
    <map>Pittsburgh</map>
    <array/>
    <array>Expected error: index greater than actual size</array>
    <array>två</array>
    <array>2</array>
    <array>TRE</array>
    <array>TRE 2 1</array>
    <array>1 2 TRE</array>
    <arrow>3</arrow>
    <arrow>ETT-TVÅ-TRE</arrow>
    <array>78 69 72 45 73 110 115 116 105 116 117 116 101</array>
    <string-constr>"A new way to 'create' strings."</string-constr>
    <string-constr>"A new way to use variables in, ett två tre, strings."</string-constr>
</root>
```

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

