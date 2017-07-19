# Linked Open Data

## A Primer on URIs

### URLs
#### `https://digitallatin.github.io/guidelines/LDLT-Guidelines.html#apparatus-criticus`

|protocol|server name|path|fragment identifier|
|--------|-----------|----|-------------------|
|https|digitallatin.github.io|/guidelines/LDLT-Guidelines.html|apparatus-criticus|

#### `http://papyri.info/search?STRING=(στρατηγ)&no_caps=on&no_marks=on&target=text&DATE_MODE=LOOSE&DOCS_PER_PAGE=15`
|protocol|server name|path|query parameters|
|--------|-----------|----|-------------------|
|http|papyri.info|/search|STRING=(στρατηγ), no_caps=on, no_marks=on, target=text, DATE_MODE=LOOSE, DOCS_PER_PAGE=15|

### URNs
#### `urn:cts:latinLit:phi0830.phi001`

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
