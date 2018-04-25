# RDF and Sparql

## Getting RDF from your sources

Lots of ways to do this.

Let's look at our old friend, P.Fay 110:

1. Make a folder to save stuff into.
1. Go to <https://github.com/papyri/idp.data/blob/master/DDB_EpiDoc_XML/p.fay/p.fay.110.xml>
1. Click the "Raw" button, and save it to your folder as "p.fay.110.xml".
1. Go to  <https://github.com/papyri/idp.data/blob/master/HGV_meta_EpiDoc/HGV11/10775.xml>
1. Save that into the same folder.
1. Grab the following XSLT files: Visit <https://github.com/papyri/navigator/blob/master/pn-mapping/xslt/ddbdp-rdf.xsl> and <https://github.com/papyri/navigator/blob/master/pn-mapping/xslt/hgv-rdf.xsl> and save their raw versions as above.

We're going to open these in Oxygen and use the XSLTs to turn the XML sources into RDF.

What have we got, and what are we going to do with it? Let's use Python! I a terminal do:

1. `pip install rdflib` ([documentation](https://rdflib.readthedocs.io/en/stable/index.html))
1. Change directories into the folder you saved your XML and RDF into.
1. `python`

Now:
```
from rdflib import Graph
g = Graph()
g.parse("p.fay.110.rdf")
len(g)
g.parse("10775.rdf")
len(g)
```
What's going on? Let's see. We'll write it out:

`g.serialize("p.fay.110.ttl", format='turtle')`

What else could we do?

## Querying RDF

Go to <http://jena.apache.org/download/index.cgi> and download "Apache Jena Fuseki". Unpack the tar.gz or zip archive you've downloaded. In a terminal, cd into the expanded directory and run the server, using `./fuseki-server --port 9000` (Mac or Linux) or `fuseki-server.bat --port 9000` (Windows). Go to <http://localhost:9000>.

There's a good SPARQL tutorial at <http://jena.apache.org/tutorials/sparql.html>

Let's get some data: go to <https://pleiades.stoa.org/downloads> and download the pleiades-latest RDF.
