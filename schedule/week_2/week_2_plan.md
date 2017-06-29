# Week 2 plan

____

##Developer note

Separate daily plans into their own markdown files before publication, but keep it all together on this page while we’re working on it.

____

##General plan

Time/Day | Monday | Tuesday | Wednesday | Thursday | Friday
--- | --- | --- | --- | --- | ---
9:00–10:00 | Model, syntax, and markup semantics  | Modeling (transcriptions), Transcription, Markup 1 | Modeling (collation), Transcription, Markup 2 | Modeling (annotations), Transcription, Markup 3 | Modeling (queries and visualization), Markup, Annotation 
10:30–11:00 | Coffee break | Coffee break | Coffee break | Coffee break | Coffee break
11:30–12:30 | Transcription with markup: XML | Markup, Tokenization 1 | Tokenization 2 | Annotation 1 | Queries 1
12:30–2:00 | Lunch | Lunch | Lunch | Lunch | Lunch
2:00–3:30 | XML as a tree | Normalization | Collation | Text analytics 1 | Queries 2
3:30–4:00 | Coffee break | Coffee break | Coffee break | Coffee break | Coffee break
4:00–5:30 | Transcription with markup (LMNL, Alexandria) | Review | Collation | Review | Visualization, Review

Bumped to make room for Mike: Annotation 2 and review (Thursday); Queries 2, visualization, and review (Friday)

____

## Week 2, Day 1: Monday, July 17

### Synopsis

Week 2, Day 1 concentrates on modeling textual documents, with attention to alternative models and their syntactic expressions. 

#### Outcome goals

* The digital edition as a computational pipeline
* Where data modeling belongs in the work flow
* Markup as an expression of a data model; making the implicit explicit and machine-actionable
* Model, syntax, and markup semantics
* How XML copes with limitations of the tree as a document model
* What’s so bad about work-arounds and relying on application-level semantics?

### 9:00–10:30: Model, syntax, and markup semantics

#### Topics and activities

* The digital edition as a computational pipeline
* Model, syntax, and markup semantics
* XML, LMNL (model, sawtooth syntax), GODDAG, TexMECS, TAG. How they're similar and different, and how they only *appear* to be similar and different
* XML is the only framework that is production ready today

#### Outcome goals

* How can the elaboration of a digital edition be modularized?
* How are *model*, *syntax*, and *markup semantics* similar and different? 

#### Reading

* **[Add rhd/djb Balisage paper]** (optional)

### 11:00–12:30: Transcription with markup: XML

#### Topics and activities

* Making the implicit explicit with markup
* XML as a tree (OHCO: “ordered hierarchy of content objects”)
* **Hands on:** Tag [“Ozymandias”](ozymandias.txt) in XML (e.g., lines, phrases, sentences, speakers, words, feet, syllables)
* What’s hard in XML: overlap, discontinuity, containment vs dominance, white space tokenization, artificial hierarchy, scope of reference

#### Outcome goals

* How are documents like trees and how are they different?
* What is represented by the model alone (the XML tree), and what requires markup semantics (schema)?

####Reading

* [“Refining our notion of what text really is: the problem of overlapping hierarchies”](http://cds.library.brown.edu/resources/stg/monographs/ohco.html) (optional)

### 2:00–3:30: XML as a tree

#### Topics and activities

* XPath as a way of navigating the tree
* XPath path expressions: axes and node type selectors
* **Hands on:** XPath navigation of [*Hamlet*](hamlet.xml) in \<oXygen/\> 
* **Hands on:** XPath navigation of overlap in [“Ozymandias”](ozymandias.xml) (Trojan milestones, the XPath `is` operator)
* What’s so bad about markup semantics, the application layer, and workarounds?

#### Outcome goals

* XML looks like a string (and it’s defined that way in the spec), but it’s really a tree. This requires workarounds not only in the markup, but also in the query.

#### Reading

* [“What can XPath do for me?”](http://dh.obdurodon.org/introduction-xpath.xhtml) (optional

### 4:00-5:30: Transcription with markup: LMNL

#### Topics and activities

* XML and LMNL sawtooth syntax only look alike, and LMNL isn’t just XML with overlap
* **Hands on:** Tag [“Ozymandias”](ozymandias.txt) in LMNL
* What is Alexandria?
* Validation of LMNL with Luminescent
* Visualization of LMNL in Alexandria

#### Outcome goals

* How do XML (tree) and LMNL (range) model “what text really is”? 
* Why does it matter as long as the workarounds work?

## Week 2, Day 2: Tuesday, July 18

### Synopsis

Week 2, Day 2 introduces the [Gothenburg model of textual variation](gothenburg.md) (GM) with the goal of focusing on the modular and algorithmic aspects of textual criticism. **Outcome goals:**

* A modular understanding of textual criticism
* Modular approaches to designing and implementing an edition
* The five components of GM: tokenization, normalization, alignment, analysis, visualization
* The role of GM components outside the analysis of variation
* Tokenization in Python and in XSLT
* Normalization in Python and in XSLT

### 9:00–10:30: The Gothenburg model of textual variation (GM)

* [Introduction to the Gothenburg model of textual variation (GM)](gothenburg.md)

**[The following isn’t the plan for 9:00–10:30; it’s just a holding pen for taks to be scheduled]**

* LMNL ranges and TAG sets: similarities and differences (e.g., discontinuity; Shaw sample in repo as text **need to add LMNL**)
* Data model ~ syntax ~ markup semantics
* Using a schema to bring markup semantics into the model
* Looking at and working with non-XML markup expands our ways of thinking about text, and about the workarounds we need in XML.
* Successful modeling reduces iterations of the document analysis → schema development → markup pipeline.
* **Community-driven** vs **research-driven** analysis; “how do I do this in X?” vs “how should I model this?” 
* Research-driven annotation: 1) What are the inherent properties of the text, and 2) What do I need for my research? Research questions →  data model (including query facilities) →  markup/annotation.

### 11:00–12:30

### 2:00–3:30

### 4:00-5:30

## Week 2, Day 3: Wednesday, July 19

### 9:00–10:30

### 11:00–12:30

### 2:00–3:30

### 4:00-5:30

## Week 2, Day 4: Thursday, July 20

### 9:00–10:30

### 11:00–12:30

### 2:00–3:30: Text analytics 1

MK: Bag of words, text processing, text as tables, query the tables

### 4:00-5:30: Text analytics 2

MK: Bag of words, text processing, text as tables, query the tables (continued)

## Week 2, Day 5: Friday, July 21

### 9:00–10:30

### 11:00–12:30

### 2:00–3:30: Text analytics 3

MK: Unsupervised learning, cluster analysis, PCA, paleographic analysis

### 4:00-5:30: Text analytics 4

MK: Unsupervised learning, cluster analysis, PCA, paleographic analysis (continued)


