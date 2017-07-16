# What’s hard in XML

XML deals naturally with documents that conform to the OHCO (ordered hierarchy of content objects) model because XML and OHCO are both ordered trees, but XML may struggle to represent document properties that contradict the OHCO model.

In all of the following cases there are well-known workarounds, so none of these awkward moments should be understood as something that cannot be modeled in XML. Rather, these are structures can cannot be modeled *in a natural way* in XML, and, as is implicit in the term “workaround”, they come with disadvantages.

## Overlap

Here is the beginning of Percy Bysshe Shelley’s “Ozymandias” (1818):

> I met a traveller from an antique land,  
Who said—“Two vast and trunkless legs of stone  
Stand in the desert. . . . Near them, on the sand,  
Half sunk a shattered visage lies, whose frown, 

The phrase that begins on the second line continues onto the third, crossing the line boundary, which creates an overlap situation that cannot be modeled by `<line>` and `<phrase>` elements, as in the example below, which is not well formed:

```xml
<line><phrase>Who said —</phrase> <phrase>“Two vast and trunkless legs of stone</line>
<line>Stand in the desart….</phrase> <phrase>Near them,</phrase> <phrase>on the sand</phrase></line>

```

## Discontinuity

The following line from Lewis Carroll’s *Alice in Wonderland* has a single speech act divided by a narrative interpolation:

> Alice was beginning to get very tired of sitting by her sister on the bank, and of having nothing to do: once or twice she had peeped into the book her sister was reading, but it had no pictures or conversations in it, “and what is the use of a book,” thought Alice “without pictures or conversation?”
 
In this example, XML is unable to tag the two parts of the quotation as a single element.

## Containment vs dominance

Jeni Tennison writes:

> Containment is a happenstance relationship between ranges while dominance is one that has a meaningful semantic. A page may happen to *contain* a stanza, but a poem *dominates* the stanzas that it contains.

XML does not distinguish containment from dominance. Furthermore, if an entire paragraph consists of an entire quotation, in XML terms either the paragraph is a child of the quotation or vice versa. This means that not only does XML not distinguish containment from dominance, but it also has no concept of coextensiveness other than a parent/child relationship that simultaneously and obligatorily expresses both containment and dominance.

## White space tokenization

To a human, a line of poetry with metrically strong syllables tagged, along the lines of:

```xml
<line>Two v<stress>a</stress>st and tr<stress>u</stress>nkless l<stress>e</stress>gs of st<stress>o</stress>ne</line>
```

is a sequence of seven words with markup on strong syllables. But there is no graceful way to tag the words individually using XML processing because the white space does not delimit items that have been modeled in a machine-actionable way as content objects. From an XML perspective, the children of the `<line>` element are:

Node type | Value
---- | ----
`text()` | Two v
`element(stress)` | a
`text()` | st and tr
`element(stress)` | u
`text()` | nkless l
`element(stress)` | e
`text()` | gs of st
`element(stress)` | o
`text()` | ne

## Artifactual hierarchy

Given the title:

```xml
<title><name>Romeo</name> and <name>Juliet</name></title>
```

a human thinks of this as a three-word title, where two of the words happen to be personal names, but XML markup puts the three words onto different levels of the hierarchy:

<img src="Images/romeo_xml.png" alt="[Artifactual hierarchy illustration]"/>

## Scope of reference

XML can represent footnotes with inline elements (e.g., TEI `<note>`), but a note at the end of a paragraph does not refer unambiguously to the last sentence, the last two sentences, the entire paragraph, etc.