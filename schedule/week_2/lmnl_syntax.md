# LMNL

LMNL (Layered markup and annotation language) is a data model based on the expression of *ranges* over strings of *atoms*, which are typically characters. LMNL may be expressed using *sawtooth* syntax, where `[stuff}` and `{stuff]` are the start and end tags for a range that has the `name` property value “stuff”. 

## Tagging ranges

Range tags behave differently from XML element tags because LMNL ranges are allowed to overlap. Consider the following three lines by Robert Frost (the examples on this page are taken from from <http://piez.org/wendell/LMNL/Amsterdam2008/presentation-slides.html>):

> He manages to keep the upper hand  
On his own farm. He’s boss. But as to hens:  
We fence our flowers in and the hens range.

The three lines correspond to two sentences. As we saw when we examined Percy Bysshe Shelley’s “Ozymandias” in XML, it isn’t possible to tag both lines and sentences with TEI `<l>` and `<s>` elements because the two hierarchies overlap.

Overlap isn’t a problem in LMNL because, as we note above, LMNL ranges are permitted to overlap:

```
[s}[l}He manages to keep the upper hand{l]
[l}On his own farm.{s] [s}He’s boss.{s] [s}But as to hens:{l]
[l}We fence our flowers in and the hens range.{l]{s]
```

Note that:

1. Where a sentence range and a line range begin or end at the same place, it doesn’t matter which tag comes first.
2. Unlike with XML, LMNL documents are not required to have a root element (although one is permitted).

## Annotation on ranges

LMNL ranges may have *annotations*, which are roughly similar to XML attributes. Here we use annotations to number the poetic lines:

```
[s}[l [n}144{n]}He manages to keep the upper hand{l]  
[l [n}145{n]}On his own farm.{s] [s}He's boss.{s] [s}But as to hens:{l]  
[l [n}146{n]}We fence our flowers in and the hens range.{l]{s]
```

Annotations have the same delimiters as ranges, but annotations are stored inside the start tag (or the end tag, but in this example the annotation is inside the start tag). For example, `[l [n}144{n]}` has a start tag `[l}` with an annotation `[n}144{n]` inside it.

## Markup and annotation on annotation text

LMNL annotation text, unlike the values of XML attributes, may be marked up. Here is an expansion of the preceding example, where metadata is provided in annotations, the text of which is marked up and annotated:

```
[excerpt}
[s}[l [n}144{n]}He manages to keep the upper hand{l]
[l [n}145{n]}On his own farm.{s] [s}He's boss.{s] [s}But as to hens:{l]
[l [n}146{n]}We fence our flowers in and the hens range.{l]{s]
{excerpt
  [source
    [title}The Housekeeper{title]
    [loc}lines 144-146{loc]
    [source
      [title}North of Boston{title]
      [date}1915{date]]]
  [author
    [name}[given}Robert{given] [family}Frost{family]{name]
    [date}1874-1963{date]] ]
```

In this case there are two annotations on the `[excerpt}` range, and they are specified in the end tag. One provides information about the source (which itself has a source), and the other provides information about the author (for whom name and date information is given).