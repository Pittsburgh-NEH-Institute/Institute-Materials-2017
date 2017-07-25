# eXist-db XQuery 3 and webapps

## httpclient example 1
```xquery
xquery version "3.0";
 <techContacts>{
for $center-pos in ("1", "3", "4", "5", "6", "10", "11", "13", "20", "24", "25")
 (: (1 to 29) :)
return
httpclient:get(
    xs:anyURI(concat("https://centres.clarin.eu/restxml/", $center-pos)),
    false(), ())//cmd:TechnicalContact//cmd:Person
}</techContacts>
```

## httpclient example 2
```xquery
xquery version "3.0";

 httpclient:post-form(
 xs:anyURI("https://ws.example.com/wsauth/authenticate"), 
 <httpclient:fields>
    <httpclient:field name="username" value="{$username}" type="string"/>
    <httpclient:field name="password" value="{$password}" type="string"/>
    <httpclient:field name="checksum" value="{util:hash(concat($username, $passw
ord,
    $bas:config-doc//auth-salt), "md5")}" type="string"/>
 </httpclient:fields>,
 false(),
 <headers>
     <header name="Accept" value="text/xml"/>
 </headers>)
```

## FLWOR

## Index configuration
Types of indexes:
*Structural: element + attribute occurrences
* Range: node values (used with =, <, >, contains, matches …)
* N-gram: node values (ngram:contains)
* Lucene: tokenized text
* xml:id: use with fn:id (created automatically)
* Other: geospatial, sort, rdf-sparql ...

Location of configuration files:
* `/db/system/config/db/<project>...`
* Config files have to end in `.xconf`
* Collection hierarchy is mirrored in `/db/system/config/db/<project>...`
* Configurations on a lower level of the hierarchy overwrite configurations on higher levels


Updates to collection.xconf apply automatically to all newly stored documents. To re-apply the configuration to existing documents, you must call `xmldb:reindex("/db/project/...")` in XQuery or use the Java admin client to reindex.

Sample index configuration (collection.xconf):
```xml
<collection xmlns="http://exist-db.org/collection-config/1.0">
    <index xmlns:tei="http://www.tei-c.org/ns/1.0" xmlns:xs="http://www.w3.org/2001/XMLSchema-datatypes">
        <lucene>
            <analyzer class="org.apache.lucene.analysis.standard.StandardAnalyzer"/>
            <analyzer id="ws" class="org.apache.lucene.analysis.core.WhitespaceAnalyzer"/>
            <analyzer id="kw" class="org.apache.lucene.analysis.core.KeywordAnalyzer"/>
            <text qname="tei:w"/>
            <text qname="tei:head"/>
            <text qname="tei:p"/>
            <text qname="tei:lg"/>
            <text qname="tei:cell"/>
            <text qname="@atMost"/>
            <text field="age" qname="@atLeast"/>
            <ignore qname="tei:sic"/>
        </lucene>
        <create qname="@n" type="xs:string"/>
        <ngram qname="tei:head"/>
        <ngram qname="tei:p"/>
    </index>
</collection>
```
NB: Make sure the namespaces are defined correctly otherwise it won't work.

### Range index
* Used by operators `=, >, <, !=, eq, gt, …`
* Functions: `contains, starts-with, ends-with, matches`
* Type:
  - xs:integer, xs:decimal and subtypes
  - xs:string and subtypes
  - xs:dateTime, xs:date
  - xs:boolean

If you define an index with a specific type, all values in the indexed collections have to be valid instances of this type.
The operand has to match the defined index type:
* `//a[b = 99]` – correct type, `xs:integer` index used!
* `//a[b = “99”]` – wrong type, no index used!

All collections in the query context need to have the same index defined otherwise it will not be used:
```xquery
collection(“/db/<project>”)//tei:date[@when = 1866]
collection(“/db”)//tei:date[@when = 1866]
```

### Lucene full-text index

```xml
...
<lucene>
  <text qname=”para”>
    <ignore qname=”note”/>
    <inline qname=”emphasis”/>
  </text>
  <text match=”//book/section”/>
</lucene>
...
```
```xquery
ft:query($nodes as node()*, $query as item()) node()*
```
Requires a Lucene index on the collections in context.
The query, either as
* Lucene query string
* an XML fragment defining the Lucene query

Term example:
```xquery
xquery version "3.1";

declare namespace tei = "http://www.tei-c.org/ns/1.0";

let $text := xmldb:xcollection("/db/dramawebben/data/works/StrindbergA_FrokenJulie")//tei:text
let $query := <query><term>mindre</term></query>
let $result := ft:query($text/descendant::tei:p, $query)
```
Wildcard example:
```xquery
$data-collection//tei:p[ft:query(.,<query><wildcard>ha*</wildcard></query>)]
```

Lucene query string example:
```
Wildcards: geograph*, geographer?
Multiple terms: native chinese
Phrase: “native chinese”~10
Fuzzy: geographer~
Required: +buddhist +chinese
Excluded: buddhist -chinese
Boost: buddhist^10 chinese
And: "caspian sea" AND tibet
Not: "caspian sea" NOT tibet
```
vs:
```xml
<bool>
  <term occur=”must”>caspian</term>
  <term occur=”should”>sea</term>
  <term occur=”not”>tibet</term>
</bool>
<near>caspian sea</near>
<phrase>caspian sea</phrase>
<bool>
  <near occur="must">caspian sea</near>
  <term occur="must">tibet</term>
</bool>
```

## Webapps
Recap of `typeswitch` function:
```xquery
xquery version "3.1";

declare namespace tei="http://www.tei-c.org/ns/1.0";

declare function local:gen-uuid($prefix as xs:string?) as xs:string {
concat($prefix, if (empty($prefix)) then "" else "-", util:uuid())
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



let $data-collection := collection("/db/neh-2017")
let $result := "a string"
let $xml := <result><b val="b"> no bss</b> another word starting with a {$result}</result>

return local:add-uid-attributes-to-fragment($xml)
```

### Serialization
```xquery
declare option exist:serialize "method=html5 enforce-xhtml=yes";
```
* Controls how query output is sent to the browser
* Supported methods: `xml, xhtml, html5, text, json`
* `enforce-xhtml`: make sure all elements are in the XHTML default namespace

## Request
```xquery
request:get-parameter($name, $value)
```
`$name` is the name of the parameter and `$default`  is the default value to use if the parameter is not given.

## Structure your app
_EXPath_ is an effort to standardize XQuery extension modules across implementations.
* Distribution of library modules (XQuery/Java/XSLT) as self-contained packages
* Register modules with the query engine
* Simple installation, hot deployment into running database

### eXist-db's application repository
* Extends EXPath packages
* Hot deployment and configuration of entire applications or services
* Self-contained, modular applications
* Foundation for component reuse
* Simplifies development process
* Simple deployment via dashboard

`eXide` supports app development and generates app structure and puts your provided metadata in place. In eXide `Application->New application`.

Choose a name. You willfind it under `/db/apps/`. The collection structure is:
* `modules/` - (Everything XQuery)
* `templates/` - (Page templates used by html-files)
* `resouces/` - (images, css, javascript) 
* `expath-pkg.xml` - (Package descriptor)
* `repo.xml` - (Application metadata)
* `index.html`
* `controller.xql` (URL rewriter)
* `pre-install.xql` - (executed before deployment)

Model-View-Controller concept:
* XML - model
* html - view
* XQuery - controller, implementing application logic

### HTML templating
```xml
<div class="templates:surround?with=templates/page.html&amp;at=content">
```
calls
```xquery
declare function templates:surround($node as node(), 
	$params as element(parameters)?, $model as item()*)
```

* Templating searches known modules for matching function
* Function signature is the same for all template functions

```xquery
declare function templates:surround($node as node(), 
	$params as element(parameters)?, $model as item()*)
```
Parameters:
* `$node`: HTML node which called the template
* `$params`: parameters passed
* `$model`: arbitrary data to be forwarded to nested templates

### URL Rewriting
Typical tasks:
* Check if a user is logged in and redirect to a login page
* Error handling
* Import resources from the file system
* Create REST-style URIs

