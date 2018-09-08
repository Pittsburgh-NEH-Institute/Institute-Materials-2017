# LMNL

## Preliminaries

### What is LMNL

We briefly mentioned LMNL in the unit about [other data models](https://github.com/Pittsburgh-NEH-Institute/Institute-Materials-2017/blob/master/schedule/week_2/other_models.md). LMNL stands for "Layered Markup and Annotation Language" and is a data model based on the expression of *ranges* over strings of *atoms*, which are typically characters. LMNL may be expressed using *sawtooth* syntax, where `[stuff}` and `{stuff]` are the start and end tags for a range that has the `name` property value “stuff”. 

### LMNL in our Institute

LMNL is a young technology that (like TAG) does not have the infrastructure support (tools, community, etc.) of XML. We introduce it in the Institute because the unfamiliarity makes us work more slowly and more carefully, and focuses our attention on the relationship between model and markup. What is more, LMNL provide a means to easily model structures that overlap.

## Working with LMNL

### Tagging ranges in LMNL

Range tags behave differently from XML element tags because LMNL ranges are allowed to overlap. Consider the following three lines by Robert Frost (the examples on this page are taken from from <http://piez.org/wendell/LMNL/Amsterdam2008/presentation-slides.html>):

> He manages to keep the upper hand  
On his own farm. He’s boss. But as to hens:  
We fence our flowers in and the hens range.

The three lines correspond to two sentences. As we saw when we examined Percy Bysshe Shelley’s [“Ozymandias” in XML](https://github.com/Pittsburgh-NEH-Institute/Institute-Materials-2017/blob/master/schedule/week_2/overlap_xml.md), it isn’t possible to tag both lines and sentences with TEI `<l>` and `<s>` elements because the two hierarchies overlap.

Overlap isn’t a problem in LMNL because, as we note above, LMNL ranges are permitted to overlap:

```
[s}[l}He manages to keep the upper hand{l]
[l}On his own farm.{s] [s}He’s boss.{s] [s}But as to hens:{l]
[l}We fence our flowers in and the hens range.{l]{s]
```

Note that:

1. Where a sentence range and a line range begin or end at the same place, it doesn’t matter which tag comes first.
2. Unlike with XML, LMNL documents are not required to have a root element (although one is permitted).

### Annotation on ranges

LMNL ranges may have *annotations*, which are roughly similar to XML attributes. Here we use annotations to number the poetic lines:

```
[s}[l [n}144{n]}He manages to keep the upper hand{l]  
[l [n}145{n]}On his own farm.{s] [s}He's boss.{s] [s}But as to hens:{l]  
[l [n}146{n]}We fence our flowers in and the hens range.{l]{s]
```

Annotations have the same delimiters as ranges, but annotations are stored inside the start tag (or the end tag, but in this example the annotation is inside the start tag). For example, `[l [n}144{n]}` has a start tag `[l}` with an annotation `[n}144{n]` inside it.

### Markup and annotation on annotation text

LMNL annotation text, unlike the values of XML attributes, may be marked up. Here is an expansion of the preceding example, where metadata is provided in annotations on the `[excerpt}` range, the text of the metadata being marked up and annotated:

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

## Your turn

Open a [plain text version of “Ozymandias”](ozymandias.txt) in a plain text editor, such as Notepad++ or BBEdit and tag it in LMNL for the same features as you used with XML (e.g., lines, sentences, phrases, speakers, words, feet, syllables, stress). We’d suggest starting with lines and phrases, which overlap. 

Tagging in LMNL is more challenging than tagging in XML not only because of the unfamiliarity, but also because we don’t have a validating LMNL editor (comparable to using \<oXygen/\> to edit XML), which means that it’s easy to make an error without realizing it. The repo contains a copy of [“Ozymandias with well-formed LMNL markup”](ozymandias.lmnl) , which you can use for comparison, but 1) you don’t have to use the same range names as our example, and 2) you don’t have to tag all of the same features. The main point of this exercise is to get you thinking about what and how you would tag if you are not working in XML and if you do not have to worry about overlap.

## Optional: LMNL well-formedness checking

We won’t do the following in the Institute sessions because it takes a while and we aren’t going to do much with LMNL after today. But if you’d like to install a well-formedness checker for LMNL, you’ll need to do the following. If you try it and anything goes wrong, let us know and we’ll help you troubleshoot it.

1. Run `java -version`. If the command tells you that you don’t have Java installed, install it from <https://www.java.com/en/>. If it tells you that you are running a version that does not begin with “1.7” or “1.8”, upgrade your Java installation from <https://www.java.com/en/>.
2. Install [Calabash](http://xmlcalabash.com/).
3. Clone <https://github.com/djbpitt/Luminescent>.

We’d suggest configuring a shell alias for Calabash once you’ve installed it. For example, the alias instruction in our `.bash_profile` reads:

```bash
alias calabash='java -Xmx1024m -jar /Applications/xmlcalabash-1.1.16-97/xmlcalabash-1.1.16-97.jar'
```

You’ll have to change the path to wherever your `xmlcalabash-1.1.16-97.jar` is installed.

To run the well-formedness checker after you’ve done all of the preceding, type:

```bash
calabash -dtext/plain@ozymandias.lmnl /Users/djb/Luminescent/LMNL-wf-check.xpl
```

but first make the following changes:

1. Replace our “ozymandias.lmnl” with the path to the LMNL file you want to check. If you’re running the checker inside the directory that contains that file, you can type just the filename, and that’s what we do in the example above.
2. Replace the path to Luminescent with the path to where you cloned it on your system. 

If your LMNL is well formed, you’ll see:

```
You are well formed
```

If not, you’ll see something like:

```
No end tag matches start tag [voice} at 3:34,
Error reported for at 3:93,
Error reported for at 3:94,
Error UNRECOGNIZED-TAGGING reported for UNRECOGNIZED-TAGGING at 12:84,
No start tag matches end tag {agent] at 12:116,
Error reported for at 12:123,
Error UNRECOGNIZED-TAGGING reported for UNRECOGNIZED-TAGGING at 15:93,
```

The numbers in the error messages are line numbers and character offsets within the line, so that, for example, “3:34” means the 34th character from the beginning of the third line.
