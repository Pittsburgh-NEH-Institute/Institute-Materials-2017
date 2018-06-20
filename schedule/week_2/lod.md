# Linked Open Data (LOD)

(summarized from <https://www.w3.org/DesignIssues/LinkedData.html>)

1. Publish your data with an open license
2. Use machine-readable formats
3. Better, use machine-readable *open* formats
4. And use open web standards to describe your data
5. And best of all, do all the above and link to other people’s data too

\#4 explicitly calls out the standards around the [Resource Description Framework (RDF)](https://www.w3.org/standards/techs/rdf#w3c_all) and the query language defined for it, [SPARQL](https://www.w3.org/TR/sparql11-query/). These are powerful and useful tools, but it’s important not to put the cart before the horse. You need to get your data in good shape before you start thinking about modeling it in RDF.

## The foundations of Linked Open Data

1. **Open licenses:** Can people use our data once they’ve got it? Can they re-publish it? Build on it?
1. **Stable URIs:** Can people link to our resources and expect they will stay available?
1. **Open standards:** Will people be able to understand and use the formats we publish in for the foreseeable future?
1. **Referenceable data resources:** Can people link to the parts of the data they’re interested in? Or is everything hidden behind a search interface?

### 1. Open licenses

[Creative Commons licenses](https://creativecommons.org/choose/) are generally good for content. The less restrictive, the better. This obviously depends on copyright and what you’r allowed to do with the data (after all, you have to own the Copyright—or have the owner’s permission—in order to be able to apply a license). You should think about the code as well as the data. There are licenses that work better for code, such as the GNU GPL, Apache, and others; see <https://choosealicense.com/> for comparative information.

Licensing involves cultural, political, and social decisions more than technological ones. In many cases, open-access, open-license is the best possible outcome. With regards to data related to indigenous peoples, there are often [community-implemented restrictions](https://responsibledata.io/2017/09/22/indigenous-peoples-responsible-data-readings/) designed to preserve cultural heritage. When choosing a license, you must ask: What will the content owner allow? What are your licensing goals? What will your institution allow? Funders will often insist on open licenses.


### 2. Stable URIs

“Cool URIs don’t change.” (<https://www.w3.org/Provider/Style/URI>) 

The linking part of this requires that we spend some time understanding how links work, which is not as simple as it may at first appear. URIs are _Uniform Resource Identifiers_—they *identify*, that is, name, resources on the Web. They may do this by giving us an address, in which case they are _Locators_ (_URL_s) or by simply naming the resource (_URN_s). URIs deal only in basic ASCII text, so if you need, for example, to include a Greek character in your URI, you have to escape it. RDF technologies add another layer with *Internationalized* Resource Indentifiers (_IRI_s), which can have Unicode characters in them. If we’re going to link to things, a) we want there to be web resources we can link to—so that we can retrieve them by clicking on a link, and b) we want those links to persist. If they’re going to last, we probably want the form of our URIs not to be too dependent on the technology used to present them, which has some design implications.

#### URLs

##### `https://digitallatin.github.io/guidelines/LDLT-Guidelines.html#apparatus-criticus`

|protocol|server name|path|fragment identifier|
|--------|-----------|----|-------------------|
|https|digitallatin.github.io|/guidelines/LDLT-Guidelines.html|apparatus-criticus|

This example links to a particular section of an HTML document. The protocol tells the client (whether that be a web browser or something else) how to retrieve it, the server name tells it what system to ask for the resource, and the path, what to ask that system for. As far as the server is concerned, that’s it—that is, the server communication ignores the fragment identifier part. If you’re using a web browser, it will probably scroll to that section of the document, but what to do with the fragment identifier portion of the URL is a client concern. You may have used web applications called _single page applications_, where what you see in the browser is entirely dependent on the content of the fragment identifier. What this means is that there is code running in the browser that either fetches additional data or decides from the data it has what to display based on the fragment identifier. This meets the needs of a person using a browser, but less so for other types of client. To an archiving service, for example, a single-page application looks like just that, a single web page, and not a rich set of web resources.

##### `http://papyri.info/search?STRING=(στρατηγ)&no_caps=on&no_marks=on&target=text&DATE_MODE=LOOSE&DOCS_PER_PAGE=15`
|protocol|server name|path|query parameters|
|--------|-----------|----|-------------------|
|http|papyri.info|/search|STRING=(στρατηγ), no_caps=on, no_marks=on, target=text, DATE_MODE=LOOSE, DOCS_PER_PAGE=15|

This example shows the use of _query parameters_ in a URL, and query parameters, which are common search interfaces (such as the one above), *are* processed by the server, unlike fragment identifiers. In essence, the client is sending some information to the server, which is using it to tailor the response it returns. 

Linked Data URLs tend to look more like a) `https://example.com/resource/123` than b) `https://example.com/resource?id=123`. Partly, this is just convention. What happens on the server before a request is answered is totally opaque to the client. The server could be simply reading a file off disk and sending the data to the client, or it could be retrieving data from one or more databases, combining it, transforming it, and then returning the result. In general though, URLs with parameters like (b) tend to be used for functions like search, and URLs like (a) tend to be used for naming and retrieving resources.

#### URNs

##### `urn:cts:latinLit:phi0830.phi001`

URNs uniquely _name_ resources, but they don’t contain within them instructions for retrieving the named resources. This means that they need to be plugged into some sort of resolution service if they are to return the thing they name. That doesn’t stop them from being useful as identifiers, though—not to mention that sometimes we need to talk about things that are not web resources. The URN above uses the [Canonical Text Services (CTS)](http://www.homermultitext.org/hmt-doc/cite/cts-urn-overview.html) naming scheme to identify the *Eclogues* of a Latin poet named Calpurnius Siculus. There are several editions of these texts, some available on the web, and the URN doesn’t name a particular edition. It refers instead to the abstract idea or group of physical and digital works with this author and title.

To sum up, URIs can be used not just to _retrieve_ resources over the web, but also to _identify_ them uniquely. We want resource URIs to persist, because users will depend on them, which means that we need to make sensible decisions about how to design them so that they’re independent of the underlying implementation. This is partially a technological question, but it has more to do with long-term sustainability and management. Having stable URIs means having control over your web infrastructure and being able to do things like set up redirects from one URI to another. Again, there are political and cultural questions here: Will your system administrators cooperate and let you design your URIs? Will the stakeholders be able to agree on what data gets a URI?

## 3. Open standards

Standards come into play throughout LOD, starting with the formats for storing data and continuing though the protocols and formats used to deliver data.

### Examples

* Encoding formats
	* Text: TEI, plain text, HTML 
	* Images: JPEG, TIFF, PNG 
	* Tabular data: CSV, TSV, DSV
* Protocols and delivery formats
	* HTTP/S (GET rather than POST) 
	* XML 
	* JSON-LD

Standards are definitely a technological question, but here, too, other factors may influence your decisions. These may include stakeholders’ and users’ willingess to adopt certain standards or workflows (e.g., “our users won’t type angle brackets”). 

## 4. Referenceable resources

Referenceable resources are an information design issue. What things do you want to represent in your website? Ideally, everything you might want to refer to should have its own (stable) URL. 

### Examples

* `http://example.com/person/123` (information about a person)
* `http://example.com/document/456` (a document)
* `http://example.com/document/456#ch1` (section in a larger document) or maybe `http://example.com/document/456/ch1` (chunked large document with referenceable sections)

Another important design question has to do with the _opacity_ of your URIs. Should you refer to things using a human-readable name or a random id? Compare `http://papyri.info/ddbdp/p.fay;;110` (“P.Fay 110” is a citation to an edition of a papyrus in *Fayum towns and their papyri*, ed. B. P. Grenfell, A. S. Hunt, and D. G. Hogarth. London, 1900) to `http://papyri.info/hgv/10775`. These two URIs resolve to the same document, which aggregates information about the papyrus. `http://papyri.info/ddbdp/p.fay;;110` is the edition, and `http://papyri.info/hgv/10775` provides data about the source document and the edition. The Duke Databank of Documentary Papyri (DDbDP) has human-legible identifiers and the Heidelberger Gesamtverzeichnis der griechischen Papyrusurkunden Ägyptens (HGV) uses opaque numbers. There isn’t a single right or wrong answer here, but note that the DDbDP has to mint and redirect to a new URI when a new edition comes out, and HGV just has to update a record. This strategy may be acceptable, or even desirable, but it also demonstrates that choices about URIs have downstream implications that are worth thinking about.

## A recipe for usable Linked Open Data

1. Get your data in shape
  1. How good is it? Do you have the metadata you need? Is it licensed appropriately?
  2. Will it be updated? Should you version it?
2. Think about how people will get and use your data
  1. Big chunks? 
  2. Individual records/documents?
  3. Both? It’s common to provide data both as records or documents and in one big download.
3. Think about how users will navigate your data
  1. Links, both internal and external
  2. What kinds of links will you have?
4. **Now** you can think about semantic web concerns, including LOD


### Exercise: look at <http://papyri.info/ddbdp/p.fay;;110>

 1. Open a terminal and try the following commands:
 2. `curl -v -L -H "Accept: text/turtle" "http://papyri.info/ddbdp/p.fay;;110"`
 3. `curl -v -L -H "Accept: text/turtle" "http://papyri.info/ddbdp/p.fay;;110/source"`

## RDF
 
The command above uses a program named [curl](https://curl.haxx.se/). The option `-v` tells it to be verbose (i.e., tell you what it’s doing), so it will both log what it does and display the request and response headers. `-L` tells it follow redirects—if the server says “what you want is actually over *here*”, `curl` will automatically get the resource at the new location. `-H "Accept: text/turtle"` tells it to send a request header informing the server of the format it wants as a response (HTTP(S) communication takes the form of a header and a body). Finally, the command gives the URL from which the data should be retrieved. 

The response is in the form of an RDF *serialization* (a format for writing out the data) called _Turtle_, an understanding of which requires us first to talk about RDF. RDF represents _facts_ using lists of three-part statements. Statements consist of _subject_, _predicate_, _object_ _triples_, where the subject and predicate are URIs, and the object may be a URI or a _Literal_ (some data, like a number or a string). The response you got back from #2, above, should look like the folllowing:

```turtle
@prefix dc:      <http://purl.org/dc/terms/> .
@prefix rdfs:    <http://www.w3.org/2000/01/rdf-schema#> .
@prefix foaf:    <http://xmlns.com/foaf/0.1/> .
@prefix oa:      <http://www.openannotation.org/ns/> .
@prefix cito:    <http://purl.org/spar/cito/> .
@prefix rdf:     <http://www.w3.org/1999/02/22-rdf-syntax-ns#> .
@prefix lawd:    <http://lawd.info/ontology/> .

<http://papyri.info/ddbdp/p.fay;;110>
      foaf:topic    <http://papyri.info/ddbdp/p.fay;;110/source> ;
      foaf:topic    <http://papyri.info/hgv/10775/source> .

<http://papyri.info/ddbdp/p.fay;;110/annotation/1ada6e40334262008d8ca4840e01ef9f>
      oa:hasTarget  <http://papyri.info/ddbdp/p.fay;;110> .

<http://papyri.info/ddbdp/p.fay;;110/source>
      foaf:page     <http://papyri.info/ddbdp/p.fay;;110> .

<http://papyri.info/hgv/10775/source>
      foaf:page     <http://papyri.info/ddbdp/p.fay;;110> .
```

The prefixes are just a way to shorten commonly-used URIs; the predicates (or properties) in RDF tend to be repeated a lot, so we shorten them. So what is this saying? First, `http://papyri.info/ddbdp/p.fay;;110` is about (has as a `foaf:topic`, or `http://xmlns.com/foaf/0.1/topic` to give it its expanded form) `http://papyri.info/ddbdp/p.fay;;110/source` and `http://papyri.info/hgv/10775/source`. These two both have the same web page, `http://papyri.info/ddbdp/p.fay;;110`. And there’s also an annotation, `http://papyri.info/ddbdp/p.fay;;110/annotation/1ada6e40334262008d8ca4840e01ef9f`, which also points at `http://papyri.info/ddbdp/p.fay;;110`. That’s it—just a list of facts. If we go ahead and interrogate one of the objects of `foaf:topic`, as example #3 did, we see more information. <http://papyri.info/ddbdp/p.fay;;110> is a web page that aggregates information from several sources, and <http://papyri.info/ddbdp/p.fay;;110/source> is one of those sources, a TEI edition. It has `dc:relation`s to the other documents aggregated with it, one of which, <http://www.trismegistos.org/text/10775>, is located on another website. It is `dc:isPartOf` the collection corresponding to the print volume in which it was originally published, <http://papyri.info/ddbdp/p.fay>. 

As we follow these chains of information around, we can start to see that RDF is a graph. Subjects in one triple can be objects in another, and vice versa. Properties can be subjects or objects too, and in fact this is how RDF schemas work, by defining the properties and types of entities in an RDF graph. Because RDF triples have *direction* (subject, predicate, object), the kind of graph they instantiate is called a *directed* graph. And, because the URIs we’re using in our RDF graph are also names for web resources, we’re tying everything on our website together in a machine-readable way.

Having our data in RDF can be useful because we can use existing facts to produce new facts. For example:

* A is related to B.
* B is related to C.
* So:	A is related to C.

That is, we can take existing triples and make new triples using the facts therein. This process is called *inferencing*.

## SPARQL: querying RDF

### Complications

#### IRs and NIRs

What do I do if I want to say something about a non-web resource? Like an actual person? These sorts of things are sometimes referred to as *non-information resources* (NIRs). If we want to be able to make RDF statements about NIRs, we will have to assign them URIs just like we do with Information Resources (IRs). But what should those URIs do when we visit them? There are a handful of solutions:

* Have the server issue a HTTP 303 (“see other”) redirect. Try it: paste `http://viaf.org/viaf/88342447` (Ovid) into your browser. Notice you end up at `https://viaf.org/viaf/88342447/` (with a trailing slash). Or even better, try using `curl` as above (which returns an explicit `See Other: https://viaf.org/viaf/88342447/`). The web server is responding to the request for an NIR with a pointer to a related IR. The advantage of this method is that it’s unambiguous, but it means you have to have enough control of the web server to get it to issue these kinds of redirects.
* Abuse the fragment identifier. Have a convention that `http://example.com/person/123#this` is the person, and `http://example.com/person/123` is the web page. Because the server doesn’t process the fragment identifier, you can have a different URI that will return the same page. This method has the advantage that you don’t need control of the web server to make it work.
* Punning. After all, who’s going to confuse the actual person with a web page? It can get tricky when you’re talking about more easily confused things, such as documents, though.
 
The central problem remains that this is confusing and no-one cares. Or, more precisely, most of your users won’t care (or, indeed, even notice) that your system is doing this.

#### Which RDF ontology should I use?

Again, there are a few approaches you can take:

* One ontology to rule them all. This is the CIDOC-CRM (<http://www.cidoc-crm.org>) approach. 
* Mix and match. Pick the properties and types you need from several ontologies. Lots of ontologies are designed to do just one thing, and therefore can work well together, although you may need to do some work to support the combination. This is the approach <http://lawd.info> takes.
* Fake it till you make it. Don’t worry about what ontology to use; just define your own properties as needed. Once you’ve worked on it for a while, you should have a good feel for what you need and be able to decide on a properly defined ontolgy.

#### How do I know things about my facts?

RDF triples don’t have context, so how do I know where a particular _fact_ came from? What if I have, for example, conflicting date or place information about a resource?

* RDF triple stores and SPARQL have support for _named graphs_. More simply, they are actually quad stores, with an extra column for the graph (a URI) to which each triple belongs. Because these are URIs, you can say things about them in RDF.
* Another solution is simply not to use RDF for contingent information. RDF is not a good universal data format and you may be better off choosing a file format like TEI XML that you can annotate and version.

## Reasons to do Linked Open Data

If we cooperate and use the same URIs for things we talk about (places, people, etc.), then we can discover and connect contextual information about our resources coming from other websites.

Following Linked Open Data principles makes for good web architecture and thus makes our sites more discoverable and more navigable. Using “cool” URIs for our resources makes for good long-term sustainability.

But be a little wary of the semantic web. It’s powerful, but confusing, it has a steep learning curve, and it can take a lot of time. How useful are interfaces like <https://collection.britishmuseum.org/sparql> or <http://dbpedia.org/snorql/>?

## Some Linked Data Sites

### Pleiades <https://pleiades.stoa.org/>

Pleiades is a digital gazetteer of the ancient world. See, e.g. <https://pleiades.stoa.org/places/736909>.

### Geonames <http://www.geonames.org/>

The GeoNames geographical database includes over eleven million placenames. See <http://www.geonames.org/export/web-services.html> for documentation of API access.

### Pelagios <http://commons.pelagios.org/>

Pelagios focuses on linking distributed resources around geographic locations. API documentation is available at <https://github.com/pelagios/pelagios-cookbook/wiki>.

### Nomisma <http://nomisma.org/>

See, e.g., <http://nomisma.org/id/ephesus>.

### Perseus Catalog <http://catalog.perseus.org/>

See, for example, <http://catalog.perseus.org/catalog/urn:cts:latinLit:phi0830.phi001> and <http://catalog.perseus.org/catalog/urn:cite:perseus:author.317>

### Perio.do <http://perio.do/>

A gazetteer of period definitions for linking and visualizing data.

### VIAF

See, for example, <http://viaf.org/viaf/100165075> (Calpurnius Siculus again).

## Talk Lab: What are the things you want to name? (20 minutes)

## Examples of vocabularies and RDF

### Dublin Core—basic metadata <http://dublincore.org/documents/dcmi-terms/>

`dcterms: <http://purl.org/dc/terms/>`

### CiTO—citation typing ontology <http://www.sparontologies.net/ontologies/cito/source.html>

`cito: <http://purl.org/spar/cito/>`

### FOAF—Friend of a friend, linking people and web resources <http://xmlns.com/foaf/spec/>

`foaf: <http://xmlns.com/foaf/0.1/>`

### SKOS—making taxonomies <https://www.w3.org/2004/02/skos/>

`skos: <http://www.w3.org/2004/02/skos/core#>`

### LAWD—I got angry and made my own <https://github.com/lawdi/LAWD>

`lawd: <http://lawd.info/ontology/>`

## Discussion: How are your things related? (20 minutes)

## RDF, SPARQL

### Hands-on exploration

 * Formats: N3, Turtle, RDF/XML
 * Try the following in the terminal:
  * `curl -L -H "Accept: text/n3" "http://papyri.info/ddbdp/p.fay;;110/source"`
  * `curl -L -H "Accept: application/rdf+xml" "http://papyri.info/ddbdp/p.fay;;110/source"`
  * And, just to compare: `curl -L -H "Accept: text/turtle" "http://papyri.info/ddbdp/p.fay;;110/source"`

### SPARQL endpoints:

Nomisma: <http://nomisma.org/sparql>
The British Museum: <http://collection.britishmuseum.org/sparql>

### Wrap up: Don’t overdo it!

<http://blogs.library.duke.edu/dcthree/2013/07/27/the-trouble-with-triples/>
