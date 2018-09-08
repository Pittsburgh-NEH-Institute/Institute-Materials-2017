# What’s hard in XML

In previous sessions, we discussed that XML deals naturally with documents that conform to the OHCO (ordered hierarchy of content objects) model because XML and OHCO are both ordered trees, but XML may struggle to represent document properties that contradict the OHCO model. For many such case, one or more workarounds exist.  

In all of the following cases there are well-known workarounds to model the textual phenomena, so none of these awkward moments should be understood as something that *cannot* be modeled in XML. Rather, these are structures can cannot be modeled *in a natural way* in XML but which can be dealt with using a workaround. As is implicit in the term “workaround”, these do come with disadvantages. In the following, we will not list the various (often project-specific) workarounds, but only examplify the textual phenomena that pose a challenge for XML modeling.

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

As you may well know, dealing with overlapping structures is a key issue for the text modeling and markup communities. We will therefore explore this topic further in the next unit: [Overlap in XML](https://github.com/Pittsburgh-NEH-Institute/Institute-Materials-2017/blob/master/schedule/week_2/overlap_xml.md).

## Discontinuity

The following line from Lewis Carroll’s *Alice in Wonderland* has a single speech act divided by a narrative interpolation:

> Alice was beginning to get very tired of sitting by her sister on the bank, and of having nothing to do: once or twice she had peeped into the book her sister was reading, but it had no pictures or conversations in it, “and what is the use of a book,” thought Alice “without pictures or conversation?”
 
In this example, XML is unable to tag the two parts of the quotation as a single element; instead it needs to consist of two `<q>` elements:

```xml
<q>"and what is the use of a book,"</q> thought Alice <q>"without pictures or conversation?"</q>
```

## Containment vs dominance

Jeni Tennison writes:

> Containment is a happenstance relationship between ranges while dominance is one that has a meaningful semantic. A page may happen to *contain* a stanza, but a poem *dominates* the stanzas that it contains.

XML does not distinguish containment from dominance. Furthermore, if an entire paragraph consists of an entire quotation, in XML terms either the paragraph is a child of the quotation or vice versa: 

```xml
<s><q>"And what is the use of a book, without pictures or conversation?"</q></s>
```
or

```xml
<q><s>"And what is the use of a book, without pictures or conversation?"</s></q>
```

This means that not only does XML not distinguish containment from dominance, but it also has no concept of coextensiveness other than a parent/child relationship that simultaneously and obligatorily expresses both containment and dominance.

## White space tokenization

To a human, a line of poetry with metrically strong syllables tagged, along the lines of:

```xml
<line>Two v<stress>a</stress>st and tr<stress>u</stress>nkless l<stress>e</stress>gs of st<stress>o</stress>ne</line>
```

is a sequence of seven words with markup on strong syllables. But there is no graceful way to tag the words individually using XML processing with XPath, because the white space does not delimit items that have been modeled in a machine-actionable way as content objects. From an XPath perspective, the children of the `<line>` element are:

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

See also the ["Making explicit"](https://github.com/Pittsburgh-NEH-Institute/Institute-Materials-2017/blob/master/schedule/week_2/explicit.md) section about white space as pseudo-markup and the unit with instructions about XML processing with [XPath](https://github.com/Pittsburgh-NEH-Institute/Institute-Materials-2017/blob/master/schedule/week_2/xpath.md).

## Artifactual hierarchy

We have discussed artifactual hierarchy in relation to the [OHCO model](https://github.com/Pittsburgh-NEH-Institute/Institute-Materials-2017/blob/master/schedule/week_2/ohco.md) before. Let's briefly go back to the example:

```xml
<title><name>Romeo</name> and <name>Juliet</name></title>
```

A human would think of this as a three-word title, where two of the words happen to be personal names, but XML markup puts the three words onto different levels of the hierarchy:

<img src="images/romeo_xml.png" alt="[Artifactual hierarchy illustration]"/>

Here, the XML model places the names "Romeo" and "Juliet" on a different hierarchical level than the conjunction "and". In XML, then, the title doesn't consists of three words but rather of two content objects (the `<name>` elements) and a word between them. 

## Scope of reference

With "scope of reference" we mean that we cannot explicitly mark the scope of XML elements like `<footnote>` or `<note>`. In the example below, it is not clear whether the footnote about David Young's study points to the preceding word(s), sentences, or to the entire paragraph:

```xml
<p>
  <s>The myth of himself Yeats took such pains to manufacture, is repeatedly and faithfully taken up in biographical studies of his poetry.</s>
  <s>It is itself the golden bird of his <title>Byzantium</title> that artificial monument in which he figures his own mortality.</s>
  <footnote>David Young, in his chapter on <title>Byzantium</title> also reads the poem as a working out of the artist's desire for immortality.</footnote>
</p>

```

XML can represent footnotes with inline elements (e.g., TEI `<note>`), but a note at the end of a paragraph does not refer unambiguously to the last sentence, the last two sentences, the entire paragraph, etc.

## Sources

Haentjens Dekker, Ronald, and David J. Birnbaum. "It's more than just overlap: Text As Graph." Presented at Balisage: The Markup Conference 2017, Washington, DC, August 1 - 4, 2017. In _Proceedings of Balisage: The Markup Conference 2017. Balisage Series on Markup Technologies_, vol. 19 (2017). <https://doi.org/10.4242/BalisageVol19.Dekker01.>


