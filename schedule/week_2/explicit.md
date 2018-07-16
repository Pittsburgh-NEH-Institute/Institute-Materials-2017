# Making the implicit explicit with markup

## Adding linguistic information to a text

Markup is famously referred to as "a means to making explicit an interpretation of a text" (see [Sperberg McQueen and Burnard 2004](http://www.tei-c.org/release/doc/tei-p4-doc/html/SG.html)). To understand what is meant with this, consider the following sentence:

```
Hamlet is a prince of Denmark.
```

A speaker of English can identify the parts of speech of each word in this sentence, as well as the lemma (dictionary form), but that information is only implicit in the written text. A computational system that has linguistic knowledge of English, such as the Python [Natural Language Toolkit (NLTK)](http://www.nltk.org/) package, can determine the parts of speech and the lemmata, but an edition that wishes to expose it might want to make an explicit part of the representation of the text, perhaps along the lines of:

```xml
<p>
    <word lemma="hamlet" pos="NNP">Hamlet</word>
    <word lemma="be" pos="VBZ">is</word>
    <word lemma="a" pos="DT">a</word>
    <word lemma="prince" pos="NN">prince</word>
    <word lemma="of" pos="IN">of</word>
    <word lemma="denmark" pos="NNP">Denmark</word>
    <word lemma="." pos=".">.</word>
</p>
```

One purpose of markup, then, can be understood as making the implicit explicit. 

## Typography, layout, pseudo-markup; presentational and descriptive markup

Sometimes information is already explicit, or, at least, partially so, through typographic or layout conventions. For example, paragraphs begin on new lines and may begin with indentation or be preceded by extra vertical space (e.g., a blank line), titles may be centered and embolded, etc. These particular examples are typically unambiguous to human readers, but not all typographic conventions are: printed text may use italics for emphasis, for foreign words, for book titles, and in other meanings. As a result, the meaning may have to be disambiguated by the reader on the basis of pragmatic knowledge or contextual information. A computer, of course, doesn't have these means of disambiguation: the only information it has is what we provide.

This is a classic example of the argument for the advantage of descriptive markup over presentational markup: a presentational element like `<italic>` leaves the meaning of the italics implicit, while descriptive elements like `<emphasis>` or `<foreign>` or `<bookTitle>` make it explicit.

## White space as pseudo-markup

In linguistic studies it is unusual to tag the individual words of a text. One reason is that the definition of a word is not always unambiguous; for example, “didn’t” might be considered a single word orthographically, since it is delimited by white space, but NLTK will tokenize it as “did” and “n’t”, which is correct in a different way. But even where word tokenization is unambiguous, we often don’t treat (or perhaps even recognize) it as pseudo-markup. <!--- Barnard et al.--> Coombs et al. make this clearer by reminding us that word spacing in European writing is a relatively recent orthographic convention:

> Figure 1: Forms of markup.
>
> NO MARKUP
>
> (This example may look artificial, but ancient writing was often in such scriptio
> continua, with virtually no interword spaces and little punctuation.)
>
> miltonexpressesthisideamostclearlylaterin the tracticannotpraiseafugitiveandcloisteredvirtueunexercisedandunbreathedthatneversa lliesoutandseesheradversarybutslinksoutoftheracewherethatimmortalgarlandistoberun fornotwithoutdustandheatsimilarlywordsworth
>
>PRESENTATIONAL
>
> Milton expresses this idea most clearly later in the tract:
>
> I cannot praise a fugitive and cloistered virtue, unexercised and unbreathed, that never sallies out and sees her adversary, but slinks out of the race where that immortal garland is to be run for, not without dust and heat.
>
> Similarly, Wordsworth . . . .    
>
> PROCEDURAL
>
> Milton expresses this idea most clearly later in the tract:  .sk 3 a;.in +10 -10;.ls 0;.cp 2            I cannot praise a fugitive and cloistered virtue, unexercised and unbreathed, that never sallies out and sees her adversary, but slinks out of the race where that immortal garland is to be run for, not without dust and heat. .sk 3 a;.in -10 +10;.cp 2;.ls 1               
>
> Similarly, Wordsworth . . . .  
>
> DESCRIPTIVE
>
> Milton expresses this idea most clearly later in the tract:  (lq)                 I cannot praise a fugitive and cloistered virtue, unexercised and unbreathed, that never sallies out and sees her adversary, but slinks out of the race where that immortal garland is to be run for, not without dust and heat.                          (/lq)                 Similarly, Wordsworth . . . .

The nature of white space as pseudo-markup helps explain why tokenizing tagged text is challenging in XML. Given the following verse line from Samuel Taylor Coleridge’s *Rime of the Ancient Mariner*:

> Water, water, every where, 

with stress markup:

```xml
<line>W<stress>a</stress>ter, w<stress>a</stress>ter, 
	<stress>e</stress>very wh<stress>e</stress>re,</line>
```

if we wish to divide the text into words, we cannot use the XPath `tokenize()` function because that *atomizes* its argument, that is, strips out the markup and treats it as a string of plain text. Workarounds take one of two forms:

* Convert the markup to plain text (such as Unicode PUA characters not otherwise in use), so that the entire line is plain text, tokenize on white space with the `tokenize()` function, and then convert the introduced pseudo-markup back into real markup.
* Replace white space characters in `text()` nodes with empty word-break elements (e.g., using `<xsl:analyze-string>`) and then use the newly introduced markup to find the words (e.g., with `<xsl:for-each-group>`) and tag them as elements with wrapper tags.

In other words, either the real markup must be converted to pseudo-markup or the white space pseudo-markup must be converted to real markup. The reason one or the other of those accommodations is necessary is that white space word delimiters are pseudo-markup, although it often flies below the radar.

One consequence of the pseudo-markup nature of white space is that it may also conceal overlap, which can frustrate with the tokenization strategies above. Here is a hypothetical XML excerpt with a deletion that begins in the middle of a word, representing an emendation of “… French cheeses and British biscuits.” to “… French cheese.”:

```xml
<excerpt>… French cheese<del>s and British biscuits</del>.</excerpt>
```

If we tokenize on white space in this case, the result would not be well formed. The `<del>` start tag will be bounded by the start and end tags of one word (`<w>cheese<del>s</w>`), and the corresponding `</del>` end tag will be bounded by the start and end tags of a different word (`<w>biscuits</del></w>`). We could work around this by treating the emendation as two independent deletions, i.e.:

```xml
<excerpt>… French cheese<del>s</del><del> and British biscuits</del>.</excerpt>
```

but this would distort the modeling in situations where our editorial judgment is that there was a single act of deletion.

In this situation, tagging the words makes the overlap a syntactic problem, but the overlap was always present, except that it was masked initially because the white space between words was pseudo-markup.

## Sources

The *scriptio continua* example is from <!--- David Barnard, Ron Hayter, Maria Karababa, George Logan, and John McFadden, “SGML-based markup for literary texts: two problems and some solutions.” *Computers and the humanities*, Vol. 22, No. 4 (1988), pp. 265–76. <http://www.jstor.org/stable/30200136>--> Coombs, James H., Allen H. Renear, and Steven J. DeRose. "Markup systems and the future of scholarly text processing." Communications of the ACM 30.11 (1987): 933-947. <https://vision.unipv.it/stm-cim/articoli/p933-coombs.pdf>

White space as pseudo-markup is discussed in the section headed “Tokenizing mixed content” in David J. Birnbaum and Elise Thorsen, “Markup and meter: Using XML tools to teach a computer to think about versification.” Presented at Balisage: The Markup Conference 2015, Washington, DC, August 11-14, 2015. In *Proceedings of Balisage: The Markup Conference 2015.* Balisage Series on Markup Technologies, vol. 15 (2015). DOI: 10.4242/BalisageVol15.Birnbaum01. <https://www.balisage.net/Proceedings/vol15/html/Birnbaum01/BalisageVol15-Birnbaum01.html>