# Data model, syntax, and markup semantics

## Data model

A data model is an abstract understanding of structure, independently of its representation. For example, a list may be represented as bullet points:

```
• Curly
• Larry
• Moe
```

or as a comma-delimited string:

```
Curly, Larry, Moe
```

or in other ways, but it is still a list of three stooges.

## Syntax

We use the terms *syntax* and *serialization* to refer to an *expression* of a model. Information structured according to a model may be *serialized* as textual characters that are governed by syntactic rules. Information may also be serialized in other ways, such as graphically. For example (and we’ll return to this later today), the XML data model is a tree, but the textual serialization of XML is a string of characters that include angle brackets, with syntactic rules that govern the use of the angle brackets in a way that enables them to express the tree structure.

As was noted above, a list (in the case below, of the most frequent words in a document) is a textual representation that may be serialized in different ways. An ordered list (vertical and bulleted or horizontal and comma-separated) is one approach to serialization. Another is a word cloud, which represents the text of the words as characters, but their frequency is expressed not through vertical or horizontal linear order, as in a list, but through size and proximity to the center of the image.

Here is the text of Abraham Lincoln’s Gettysburg Address (we removed punctuation and converted everything to lower case before generating frequency lists and word clouds):

> Four score and seven years ago our fathers brought forth on this continent, a new nation, conceived in Liberty, and dedicated to the proposition that all men are created equal.  
Now we are engaged in a great civil war, testing whether that nation, or any nation so conceived and so dedicated, can long endure. We are met on a great battle-field of that war. We have come to dedicate a portion of that field, as a final resting place for those who here gave their lives that that nation might live. It is altogether fitting and proper that we should do this.  
But, in a larger sense, we can not dedicate -- we can not consecrate -- we can not hallow -- this ground. The brave men, living and dead, who struggled here, have consecrated it, far above our poor power to add or detract. The world will little note, nor long remember what we say here, but it can never forget what they did here. It is for us the living, rather, to be dedicated here to the unfinished work which they who fought here have thus far so nobly advanced. It is rather for us to be here dedicated to the great task remaining before us -- that from these honored dead we take increased devotion to that cause for which they gave the last full measure of devotion -- that we here highly resolve that these dead shall not have died in vain -- that this nation, under God, shall have a new birth of freedom -- and that government of the people, by the people, for the people, shall not perish from the earth.

Here is a list of the 25 most frequent words:

Word | Frequency
---- | ----
nation | 5
dedicated | 4
people | 3
dead | 3
great | 3
far | 2
living | 2
conceived | 2
men | 2
devotion | 2
new | 2
field | 2
rather | 2
gave | 2
war | 2
long | 2
dedicate | 2
testing | 1
birth | 1
forth | 1
civil | 1
come | 1
larger | 1
take | 1
struggled | 1

Here is word cloud of the text:

<img src="Images/gettysburg_word-cloud.png" width="99%" alt="[Gettysburg Address word cloud]"/>

The data model we employ to represent the most frequent words is an ordered list, which may be serialized as either a table or a word cloud, two models that are governed by different syntactic rules. Note that they also have different expressive capabilities. For example, how are ties represented in the frequency table and the word cloud? How is the difference in representation determined by the different syntactic properties of the two serializations?

[Text of the Bliss copy of Abraham Lincoln’s Gettysburg Address is from <http://www.abrahamlincolnonline.org/lincoln/speeches/gettysburg.htm>. The frequency list was generated at <http://www.wordcounter.com/>, with stop words removed. The Word Cloud was generated at <https://www.jasondavies.com/wordcloud/> using default values.]

## Markup semantics

As far as the XML data model is concerned, element and attribute names are arbitrary, which is to say that they have no semantics within the XML data model. They may be chosen for mnemonic convenience, but an XML processor doesn’t know or care what the names mean as words. Schema validation allows the user to impose constraints beyond well-formedness that are motivated by markup semantics; for example, we can use schema validation to permit footnotes inside paragraphs in main text but not inside paragraphs that are in footnotes. But an XML processor still doesn’t know what a paragraph or a footnote is.

Markup semantics can be used to control processing only at the application level, which is to say that there are document properties we may wish to model that cannot be expressed entirely through markup, even with schema validation. For example, the children of an XML element are always ordered in the XML data model, which is what we normally want, since, for example, if you rearrange the order of paragraphs in a chapter, the meaning of the documents is not the same. But the TEI uses a `<choice>` element to represent items that may not be inherently ordered, such as an abbreviation and its expansion or an error and its correction. This means that if two TEI documents differ only in the order of the children of an instance of `<choice>`, a XML parser cannot know that this situation is different from rearranging the paragraphs in a chapter. This means that any application that needs to know that order is sometimes informational and sometimes not needs to be told that. 

The challenge is that XML models a document as an ordered tree, and although an application can be told to ignore the order in certain circumstances, the model itself is incapable of represented where order is and is not informational. TexMECS, on the other hand, is capable of representing both ordered and unordered child elements ([TexMECS. An experimental markup meta-language for complex documents](http://mlcd.blackmesatech.com/mlcd/2003/Papers/texmecs.html)). This is one example of how TexMECS syntax represents a different data model than XML syntax.