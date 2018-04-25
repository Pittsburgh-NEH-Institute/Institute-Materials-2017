# Text As Graph (TAG)

Text As Graph (TAG) models documents as a *hypergraph*. A *graph* consists of nodes and edges, where the edges point from one node to another. A hypergraph contains both regular edges, which point from one node to one other node, and *hyperedges*, which point from a *set of nodes* to another *set of nodes*.

## TAG counterparts to XML `text()` nodes

The text in a TAG document is a sequence of Text nodes, where the sequence begins with a Document node. The simplest TAG document, which contains only text and no markup, looks something like:

<img src="images/tag_no-markup.png" alt="[TAG without markup]"/>

## TAG Markup-to-Text hyperedges

TAG is a data model that does not (yet) have its own markup language, but the Alexandria implementation of TAG is capable of importing documents that have been marked up using LMNL sawtooth syntax. In this context, the sawtooth syntax is used to represent parts of the TAG hypergraph model, rather than the LMNL range model. The fact that the same syntax can be used to represent features of two data models highlights the difference between the data model and the syntax.

Below we add just a single Markup node (with a `name` property of “stuff”), in addition to connecting the Document node to the one Text node, TAG also creates a hyperedge that points from the Markup node to the Text node. Alexandria visualizes this as follows:

```
[stuff}Hello, World!{stuff]
```

<img src="images/tag_root_only.png" alt="[TAG with only root element]"/>

While in the LMNL model, “stuff” would be range expressed over the text, in TAG it would be a Markup node that serves as the head of a hyperedge, and the tail in this case contains a single Text node.

## Dividing text into Text nodes in TAG

With LMNL, as with XML, the document text is divided into Text nodes according to the markup structure, so that there are no adjacent Text nodes that have exactly the same markup. Here we tag the two names in a title “Romeo and Juliet”:

```
[title}[name}Romeo{name] and [name}Juliet{name]{title]
```

The visualization below shows that the text has been divided into three Text nodes in order to accommodate the markup. This TAG document contains the following objects:

* One Document node.
* Three Text nodes, with the values “Romeo”, “&#x0a; and &#x0a;” (note the spaces on either side of the conjunction), and “Juliet”.
* The Document node and the three Text nodes are connected by regular (one-to-one) edges into a chain that connects all of the text in the document.
* There are three Markup nodes (comparable to elements in XML), two of type “name” and one of type “title”.

<img src="images/tag_names.png" alt="[TAG with name markup]"/>

## TAG and overlap


