H1. Transcription markup example
SHOULD probably be moved to it's own file.


Example we first start without markup:


```
81 The Vanishing

Narrator (As if stung by a spasm) plunge into a chasm,
While they waited and listened in awe.

Baker “It’s a Snark!” was the sound that first came to their ears,
And seemed almost too good to be true.
Then followed a torrent of laughter and cheers:
Then the ominous words 
Baker “It’s a Boo-”

Then, silence. Some fancied they heard in the air
A weary and wandering sigh
That sounded like Baker “-jum!” but the others declare
It was only a breeze that went by.
```

We save this plain text transcription in a LMNL file.
When we import this file into Alexandria a graph is created. The graph is very simple: it only consists of 2 nodes and 1 edge. One Document node is created. One Text node is created, containing all of the text. An edge is created from the Document node to the text node associating the text with the document.

We see lines and phrases in the original,
lets add extra structure to the document, by a dding markup. Markup is indicated by adding [} and {] tags to the file. Formal syntax: [name} textual content {name]

Lets start by adding the lines by add tags with the "line" name.

```
[line}Narrator (As if stung by a spasm) plunge into a chasm,{line]
[line}While they waited and listened in awe.{line]

[line}Baker “It’s a Snark!” was the sound that first came to their ears,{line]
[line}And seemed almost too good to be true.{line]
[line}Then followed a torrent of laughter and cheers:{line]
[line}Then the ominous words Baker “It’s a Boo-” {line]
```

When we save and import this new file Alexandria the graph changes. There is still one Document node. However the single textnode is fragmented in one text node for each line. The Document node is connected to the first text segment. There are many more edges. The edges connect the text nodes to the next. therby containing the ordr of the text.

Note that there are two differences already the way we normally encode texts in TE/XML.
First of all the lines are individually modelled, with their own start and end tags and are not encoded as LB empty elements.

THe second thing to note here is that there is no root element. THIs means that there is no hierarchy in plca.e

There is an order to the lines, because there is an order to the text. But at the moment are not contained in anything. this is still a well-formed document for TAG.

We see that there a couple of phrases on the facsimile. Lets add tags to make that explicit.

```
[line}[phrase}Baker “It’s a Snark!” was the sound that first came to their ears,{line]
[line}And seemed almost too good to be true.{phrase]{line]
[line}[phrase}Then followed a torrent of laughter and cheers:{line]
[line}Then the ominous words Baker “It’s a Boo-” {line]

[line}Then, silence.{phrase] [phrase}Some fancied they heard in the air{line]
[line}A weary and wandering sigh{line]
[line}That sounded like Baker “-jum!” but the others declare{line]
[line}It was only a breeze that went by.{phrase]{line]
```

Notice how the line and phrase markup overlap each other and how that is not a problem in this markup language and in the conceptual model behind it. Again it is important to note that there is no hierarchical relation between the line and the phrase markup.

NExt step would be adding tags for the voices.



