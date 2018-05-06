# Linked Open Data

(summarized from https://www.w3.org/DesignIssues/LinkedData.html) 
1. Publish your data with an open license
2. Use machine-readable formats
3. Better, use machine-readable *open* formats
4. And use open web standards to describe your data
5. And best of all, do all the above and link to other people's data too

`#4 explicitly calls out the standards around the Resource Description Framework (RDF) and the query language defined for it, SPARQL.

## A Primer on URIs

The linking part of this requires that we spend some time understanding how links work. It's not as simple as it may at first appear. URIs are Uniform Resource Identifiers—they *identify*, that is, name, resources on the Web. They may do this by giving us an address, in which case they are Locators (URLs) or by simply naming the resource (URNs). URIs deal only in basic ASCII text, so if you want, say, a Greek character in your URI, you have to escape it. RDF technologies add another layer with *Internationalized* Resource Indentifiers (IRIs), which can have Unicode characters in them. If we're going to link to things, we want a) there to be web resources we can link to—so that we can retrieve them by clicking on a link and b) we want those links to persist. If they're going to last, we probably want the form of our URIs not to be too dependent on the technology used to present them, which has some design implications.

### URLs
#### `https://digitallatin.github.io/guidelines/LDLT-Guidelines.html#apparatus-criticus`

|protocol|server name|path|fragment identifier|
|--------|-----------|----|-------------------|
|https|digitallatin.github.io|/guidelines/LDLT-Guidelines.html|apparatus-criticus|

This example links to a particular section of an HTML document. The protocol tells the client (whether that be a web browser or something else) how to retrieve it, the server name tells it what system to ask for the resource, the path, what to ask that system for. As far as the server is concerned, that's it. It ignores the fragment identifier part. If you're using a web browser, it will probably scroll to that section of the document, but what to do with that part of the URL is a client concern. You may have used web applications call "single page applications" where what you see in the browser is entirely dependent on the content of the fragment identifier. What this means is that there is code running in the browser that either fetches additional data or decides from the data it has what to display based on the fragment id. This is ok for someone using a browser, but less so for other types of client. To an archiving service, for example, a single-page app looks like just that, a single web page. Not a rich set of web resources.

#### `http://papyri.info/search?STRING=(στρατηγ)&no_caps=on&no_marks=on&target=text&DATE_MODE=LOOSE&DOCS_PER_PAGE=15`
|protocol|server name|path|query parameters|
|--------|-----------|----|-------------------|
|http|papyri.info|/search|STRING=(στρατηγ), no_caps=on, no_marks=on, target=text, DATE_MODE=LOOSE, DOCS_PER_PAGE=15|

This example shows the use of query parameters in a URL. These *are* processed by the server. They're very common in search interfaces, such as the one above. In essence, the client is sending some information to the server, which is using it to tailor the response it sends. Linked Data URLs tend to look more like a) `https://example.com/resource/123` than b) `https://example.com/resource?id=123`. Partly, this is just convention. What happens on the server before a request is answered is totally opaque to the client. The server could be simply reading a file off disk and sending the data to the client, or it could be retrieving data from one or more databases, combining it, and then sending that. In general though, URLs with parameters like #b tend to be used for functions like search, and URLs like #a tend to be used for naming and retrieving resources.

### URNs
#### `urn:cts:latinLit:phi0830.phi001`

URNs uniquely name resources, but they don't contain within them instructions for retrieving the named resources. So they have to be plugged in to some sort of resolution service for you to actually get something with them. That doesn't stop them from being useful as identifiers though. And sometimes you want to talk about things that are not web resources. The URN above is an identifier for the *Eclogues* of a Latin poet named Calpurnius Siculus. There are several editions of these, some available on the web, but this doesn't name a particular one of those. It refers to the abstract idea or group of physical and digital works with this author and name.

#### Exercise: look at <http://papyri.info/ddbdp/p.fay;;110>
 1. Open a terminal and try the following commands:
 2. `curl -v -L -H "Accept: text/turtle" "http://papyri.info/ddbdp/p.fay;;110"`
 3. `curl -v -L -H "Accept: text/turtle" "http://papyri.info/ddbdp/p.fay;;110/source"`

## So, Linked Open Data
<https://www.w3.org/DesignIssues/LinkedData.html>

Some history: Papyri.info and Ides.io

## Some Linked Data Sites

### Pleiades <https://pleiades.stoa.org/>
Pleiades is a digital gazetteer of the ancient world
 * See, e.g. <https://pleiades.stoa.org/places/736909>

### Geonames <http://www.geonames.org/>

### Pelagios <http://commons.pelagios.org/>
Pelagios focuses on linking distributed resources around geographic locations

### Nomisma <http://nomisma.org/>
 * e.g. <http://nomisma.org/id/ephesus>

### Perseus Catalog <http://catalog.perseus.org/>
 * e.g. <http://catalog.perseus.org/catalog/urn:cts:latinLit:phi0830.phi001>
 * and <http://catalog.perseus.org/catalog/urn:cite:perseus:author.317>

### Perio.do <http://perio.do/>
 * A gazetteer of period definitions for linking and visualizing data

### VIAF
 * e.g. <http://viaf.org/viaf/100165075> (Calpurnius Siculus again)

## Talk Lab: What are the things you want to name? (20 minutes)

## Vocabularies and RDF

### Some examples:

Dublin Core—basic metadata <http://dublincore.org/documents/dcmi-terms/>
 * `dcterms: <http://purl.org/dc/terms/>`

CiTO—citation typing <http://www.sparontologies.net/ontologies/cito/source.html>
 * `cito: <http://purl.org/spar/cito/>`

FOAF—Friend of a friend, linking people and web stuff <http://xmlns.com/foaf/spec/>
 * `foaf: <http://xmlns.com/foaf/0.1/>`

SKOS—making taxonomies <https://www.w3.org/2004/02/skos/>
 * `skos: <http://www.w3.org/2004/02/skos/core#>`

LAWD—I got angry and made my own <https://github.com/lawdi/LAWD>
 * `lawd: <http://lawd.info/ontology/>`

## Discussion: How are your things related? (20 minutes)

## RDF, SPARQL
 * Formats: N3, Turtle, RDF/XML
 * Try the following in the terminal:
  * `curl -L -H "Accept: text/n3" "http://papyri.info/ddbdp/p.fay;;110/source"`
  * `curl -L -H "Accept: application/rdf+xml" "http://papyri.info/ddbdp/p.fay;;110/source"`
  * and, just to compare: `curl -L -H "Accept: text/turtle" "http://papyri.info/ddbdp/p.fay;;110/source"`

### SPARQL Endpoints:
Nomisma: <http://nomisma.org/sparql>
The British Museum: <http://collection.britishmuseum.org/sparql>

### Wrap up. Don't overdo it!

<http://blogs.library.duke.edu/dcthree/2013/07/27/the-trouble-with-triples/>
