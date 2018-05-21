# XQuery 3: eXist-db and webapps

We continue with XQuery and get into how to create webapps in eXist-db.

## httpclient

The `httpclient` module provides functions for interacting with resources using a REST API. The following example connects to a server at Clarin and returns information about technical contact persons. The `httpclient:get()` function takes three parameters: the URL to process, a Boolean value that indicates whether the HTTP state (cookies, credentials, etc.) should persist for the life of the query (we set this to `false()`), and optional request headers (in this case, the empty sequence). To construct the URLs dynamically we append different numbers to a base URL of the Clarin REST interface <http://www.clarin.eu/restxml/> using the XPath `concat()` function, and then cast the string to a URI with the XPath `xs:anyURI()` function. The `httpclient:get()` function returns a connection, to which we append the XPath path expression `//cmd:TechnicalContact/cmd:Person` to navigate to and return the information we need.

```xquery
xquery version "3.0";
declare namespace cmd="http://www.clarin.eu/cmd/";
<techContacts>{
	for $center-pos in ("1", "3", "4", "5", "6", "10", "11", "13", "20", "24", "25")
		(: (1 to 29) :)
	return
		httpclient:get(
    		xs:anyURI(concat("https://centres.clarin.eu/restxml/", $center-pos)),
    		false(),
    		())//cmd:TechnicalContact//cmd:Person
}</techContacts>
```
<!-- remove httpclient:post-form example because we didn’t use it
### httpclient example 2

```xquery
xquery version "3.1";

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
-->

## Index configuration

eXist-db constructs persistent indexes that support quick search and retrieval, much as a back-of-the-book index in a printed volume helps readers find specific content without having to look at every page. eXist-db will execute XQuery scripts with or without index support, but unindexed queries will be slow. For professional-quality results, you must configure indexes. In addition to the official [Configuring database indexes](https://exist-db.org/exist/apps/doc/indexing.xml) documentation, see the indexing section of [Tuning the database](http://exist-db.org/exist/apps/doc/tuning) for guidelines.

### Types of indexes

eXist-db constructs a structural index and an xml:id index for all XML documents automatically, but the other index types listed below have to be configured explicitly. 

* **structural:** element and attribute occurrences; created automatically
* **xml:id:** query with `id()`; created automatically
* **range:** typed node values (used with general and value comparison and some functions, such as `contains()`). eXist-db has both a _new range index_ and a _legacy range index_. New projects should use the new range index.
* **ngram:** character substrings inside nodes (query with `ngram:contains()`)
* **Lucene:** full index of tokenized text. There is also a _legacy full-text index_, which should not be used.
* **Other:** geospatial, rdf-sparql, and others

### Location of configuration files

* Configuration files can be created separately for each collection and subcollection and must be placed in `/db/system/config/db/<path-to-collection>`
* Configuration files must end in `.xconf`, and are typically called `collection.xconf`.
* The collection hierarchy is mirrored in `/db/system/config/db/<path-to-collection>`. For example, if the XML files for your project are in `/db/edition/xml`, the configuration file that controls indexing for those files would normally be `/db/system/config//db/edition/xml/collection.xconf`.
* Configurations on a lower level of the hierarchy overwrite configurations on higher levels

New documents are automatically indexed according to whatever indexes are in place when the documents are uploaded, but existing documents are not automatically reindexed when you update `collection.xconf`. To apply a revised configuration to existing documents, you must call `xmldb:reindex("/db/project/...")` in XQuery or use the Java admin client to reindex.

### Sample index configuration

The index configuration file is typically called `collection.xconf`, and you’ll need to read [Configuring database indexes](https://exist-db.org/exist/apps/doc/indexing.xml) to learn how to configure it. As a brief illustration, though, in the following example, we configure:

* The Lucene full-text index using the standard and whitespace analyzers, and we tell it to index specific elements and attributes. In this example, the standard analyzer is our default and we use the whitespace analyzer for `<head>` elements (specified in the `@analyzer` attribute on the corresponding `<text>` element). You can read about Lucene analyzers at <https://exist-db.org/exist/apps/doc/lucene.xml>.
* We create a new range index on the `@n` attribute. You can read about the new range index at <https://exist-db.org/exist/apps/doc/newrangeindex.xml>.
* We create an ngram index on `<head>` and `<p>` elements. You can read about the ngram index at <https://exist-db.org/exist/apps/doc/ngram>.

```xml
<collection xmlns="http://exist-db.org/collection-config/1.0">
    <index xmlns:tei="http://www.tei-c.org/ns/1.0" 
           xmlns:xs="http://www.w3.org/2001/XMLSchema-datatypes">
        <lucene>
            <analyzer class="org.apache.lucene.analysis.standard.StandardAnalyzer"/>
            <analyzer id="ws" class="org.apache.lucene.analysis.core.WhitespaceAnalyzer"/>
            <text qname="tei:w"/>
            <text qname="tei:head" analyzer="ws"/>
            <text qname="tei:p"/>
            <text qname="tei:lg"/>
            <text qname="tei:cell"/>
            <text qname="@atMost"/>
            <text field="age" qname="@atLeast"/>
            <ignore qname="tei:sic"/>
        </lucene>
        <range>
	        <create qname="@n" type="xs:string"/>
	    </range>
        <ngram qname="tei:head"/>
        <ngram qname="tei:p"/>
    </index>
</collection>
```

Namespace must be declared and referenced correctly.

### New range index

The new range index is used by:

* General and value comparison operators. The general comparison operators are `=`, `!=`, `<`, `<=`, `>`, `>=`. The value comparison operators are `eq`, `ne`, `lt`, `le`, `gt`, `ge`. The difference between general and value comparison is discussed at [What's the difference between "eq" and "="?](https://developer.marklogic.com/blog/comparison-operators-whats-the-difference).
* The functions `contains()`, `starts-with()`, and `ends-with()` (but not `matches()`).

The new range index requires you to specify a datatype, e.g., `xs:integer`, `xs:decimal`, or other numerical types; `xs:string`; `xs:dateTime`, or other date-time types; or `xs:boolean`. If you define an index with a specific type, all values in the indexed collections must be valid instances of this type.

### Lucene full-text index

The following example applies the Lucene full-text index to `<para>` elements anywhere and to `<section>` elements that are children of `<book>` elements. Within `<para>` elements, `<note>` descendants are not indexed and `<prefix>` descendants are treated as part of their parents. We specify `<inline>` to handle situations like `<para>... <prefix>un</prefix>clear ...</para>`. By default, the Lucene indexer assumes that words end at element boundaries, and therefore would not recognize “unclear” as an indexed word. By specifying that `<prefix>` is inline, we can force the system to index “unclear” as a single word.

```xml
...
<lucene>
  <text qname=”para”>
    <ignore qname=”note”/>
    <inline qname=”prefix”/>
  </text>
  <text match=”//book/section”/>
</lucene>
...
```
We use the Lucene full-text index in queries with `ft:query()`, as in the following example:

```xquery
xquery version "3.1";
declare namespace tei="http://www.tei-c.org/ns/1.0";
declare variable $ham as document-node() := doc('/db/apps/shakespeare/data/ham.xml');
ft:query($ham//tei:sp,'son')
```

If we have defined a Lucene full-text index on `<sp>` elements in this play, the query will return the `<sp>` elements that contain the word “son”. If we have not defined the index, though, it will return an empty sequence (not an error!). The query target above is expressed as a string, but it may also be expressed as an XML fragment using Lucene-specific markup (see <https://exist-db.org/exist/apps/doc/lucene.xml#D3.23.24> for more details):

```xquery
xquery version "3.1";
declare namespace tei="http://www.tei-c.org/ns/1.0";
declare variable $ham as document-node() := doc('/db/apps/shakespeare/data/ham.xml');
let $query := <query><term>son</term></query>
return ft:query($ham//tei:sp, $query)
```

The preceding query finds all speeches that contain “son”. The following query finds those that contain either “son” or “daughter”:

```xquery
xquery version "3.1";
declare namespace tei="http://www.tei-c.org/ns/1.0";
declare variable $ham as document-node() := doc('/db/apps/shakespeare/data/ham.xml');
let $query := 
    <query>
        <bool>
            <term>son</term>
            <term>daughter</term>
        </bool>
    </query>
return ft:query($ham//tei:sp, $query)
```

Lucene supports _wildcard_ queries. The following finds all `<p>` elements that contain words that begin with the characters “ha”:

```xquery
$data-collection//tei:p[ft:query(.,<query><wildcard>ha*</wildcard></query>)]
```

(Queries that begin with a wildcard can be slow and require special handling, and are best avoided.)

Lucene supports several string-query types:

* Wildcards: `photograph*`, `photographer?`
* Multiple terms: `native burmese`
* Phrase: `“native burmese”~10`
* Fuzzy: `photographer~`
* Required: `+buddhist +burmese`
* Excluded: `buddhist -burmese`
* Boost: `buddhist^10 burmese`
* And: `"caspian sea" AND tibet`
* Not: `"caspian sea" NOT tibet`

All of these have XML counterparts, e.g.:

```xml
<bool>
  <term occur=”must”>caspian</term>
  <term occur=”should”>sea</term>
  <term occur=”not”>tibet</term>
</bool>
```
```xml
<near>caspian sea</near>
```
```xml
<phrase>caspian sea</phrase>
```
```xml
<bool>
  <near occur="must">caspian sea</near>
  <term occur="must">tibet</term>
</bool>
```

## Webapps

### Recap of `typeswitch()` function

The `typeswitch()` function mimics the declarative template architecture of XSLT. The example below adds a UUID to all elements in _Hamlet_. It works by applying the `add-uid-attributes-to-fragment()` to the document (see the last line of the code). That function tests the datatype of its argument, and it treats the document node in one way (applies itself to all of the children), elements another way (adds a UUID and then applies itself to all of the children), and other nodes (attributes, text, comments, etc.) by just returning them. You can think of each `case` value as comparable to an XSLT template that matches a specific type of node.

```xquery
xquery version "3.1";
declare namespace tei="http://www.tei-c.org/ns/1.0";
declare function local:gen-uuid($prefix as xs:string?) as xs:string {
	concat($prefix, if (empty($prefix)) then "" else "-", util:uuid())
};
declare function local:add-uid-attributes-to-fragment($item as item()) as item() {
	typeswitch($item)
		case document-node() return
			for $child in $item/node()
        	return local:add-uid-attributes-to-fragment($child)
    	case element() return
      		element {node-name($item)} {
        	$item/@*,
        	if ($item[not(@uid)]) 
        		then attribute {"uid"} {local:gen-uuid(name($item))} else (),
       	for $child in $item/node()
        	return local:add-uid-attributes-to-fragment($child)
      		}
    	default return $item
};
let $hamlet := doc('/db/apps/shakespeare/data/ham.xml')
return local:add-uid-attributes-to-fragment($hamlet)
```

See <https://en.wikibooks.org/wiki/XQuery/Typeswitch_Transformations> for more information.

It is also possible to use XSLT within XQuery. For example, you could use XQuery to retrieve information from the database with its original markup, assemble it into an XML document, and then—within eXist-db—pipe it through XSLT to transform it. eXist-db has long supported XSLT with the `transform:transform()` function; XPath 3.1 introduces `transform()` as a regular (core) function, but it has not been incorporated into eXist-db as of v. 4.1, which therefore still requires the version that is in the `transform:` namespace.

### Serialization

```xquery
declare option exist:serialize "method=html5 enforce-xhtml=yes";
```

Serialization control how query output is sent to the browser. Serialization parameters are ignored in the output of “Eval” in eXide, but you can configure the output rendering  there in a dropdown list within eXide itself.

* Supported methods: `xml`, `xhtml`, `html5`, `text`, `json`
* `enforce-xhtml`: make sure all elements are in the XHTML default namespace

See <https://exist-db.org/exist/apps/doc/xquery.xml#serialization> for more information.

### Request

It is possible to pass values from a web form into eXist-db and use them as input into a query. The first argument to the `request:get-parameter()` function is the name of the parameter in the web form from which to retrieve the value, and the second is a default value to use if no value is passed in from the form. The following example:

```xquery
declare variable $title as xs:string := request:get-parameter("title", "Hamlet");
```

retrieves the value of the `title` input parameter from a web form and assigns it to a variable `$title` in the XQuery. If no title value is passed from the form, the value “Hamlet” is used instead.

For information about related functions, see the documentation for the [request](http://demo.exist-db.org/exist/apps/fundocs/view.html?uri=http://exist-db.org/xquery/request&location=java:org.exist.xquery.functions.request.RequestModule) and [response](http://demo.exist-db.org/exist/apps/fundocs/view.html?uri=http://exist-db.org/xquery/response&location=java:org.exist.xquery.functions.response.ResponseModule) modules.

## Structure your app

The [EXPath packaging system](http://expath.org/modules/pkg/) is an effort to standardize XQuery extension modules across implementations. It includes:

* Distribution of library modules (XQuery/Java/XSLT) as self-contained packages
* Registration of modules with the query engine
* Simple installation, with hot deployment into running database

### eXist-db application repository

eXist-db is not just an XQuery processor and not just an XML database. It can also serve as a content management system (CMS), which makes it possible to build and distribute an entire application, including data and the means to interact with the data, as an eXist-db application package. The eXist-db application repository:

* Extends EXPath packages
* Supports hot deployment and configuration of entire applications or services
* Supports self-contained, modular applications
* Provides a foundation for component reuse
* Simplifies the development process
* Supports deployment via the eXist-db dashboard

eXide builds in support for app development, and can generate an app template that guides the provision of data, metadata, and functionality. Inside eXide, select `Application → New application`.  Choose a name, fill in the metadata, and an application skeleton, ready for development, will be installed inside `/db/apps/`. The collection structure is:

* `modules/`: (Everything XQuery)
* `templates/`: (Page templates used by html files)
* `resources/`: (images, css, javascript) 
* `expath-pkg.xml`: (Package descriptor)
* `repo.xml`: (Application metadata)
* `index.html`: (Main page)
* `controller.xql`: (URL rewriter)
* `pre-install.xql`: (executed before deployment)

eXist applications implement the _Model-View-Controller_ concept:

* XML is the model
* HTML is the view
* XQuery provides the controller and implements application logic

For more information and tutorial instruction see [Getting started with web application development](https://exist-db.org/exist/apps/doc/development-starter.xml) (text) and [Getting started with app development in eXist-db 2.0](https://www.youtube.com/watch?v=o0KRyFM9kck) (video).


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

