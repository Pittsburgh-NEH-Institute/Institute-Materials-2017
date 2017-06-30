# Week 2 plan

____

##Developer note

Separate daily plans into their own markdown files before publication, but keep it all together on this page while we’re working on it.

____

##General plan

Time/Day | Monday | Tuesday | Wednesday | Thursday | Friday
--- | --- | --- | --- | --- | ---
9:00–10:00 | Project planning  | XML as tree (XPath) | Normalization 1 | Modeling, Annotations | Modeling (queries and visualization), Markup, Annotation 
10:30–11:00 | Coffee break | Coffee break | Coffee break | Coffee break | Coffee break
11:30–12:30 | Theory of edition | Transcription, LMNL, TAG | Modeling, Collation | Collation 2 | Queries 1
12:30–2:00 | Lunch | Lunch | Lunch | Lunch | Lunch
2:00–3:30 | Syntax and Semantics | Modeling, Computational Pipelines | Tokenization 2 | Text analytics 1 | Queries 2
3:30–4:00 | Coffee break | Coffee break | Coffee break | Coffee break | Coffee break
4:00–5:30 | Transcription XML | Tokenization 1 | Normalization 2 | Review | Visualization, Review

Bumped to make room for Mike: Annotation 2 and review (Thursday); Queries 2, visualization, and review (Friday)

____

## Week 2, Day 1: Monday, July 17

### 2:00–3:30: XML as a tree

#### Topics and activities

* XPath as a way of navigating the tree
* XPath path expressions: axes and node type selectors
* **Hands on:** XPath navigation of [*Hamlet*](hamlet.xml) in \<oXygen/\> 
* **Hands on:** XPath navigation of overlap in [“Ozymandias”](ozymandias.xml)
* What’s so bad about markup semantics, the application layer, and workarounds?
* The [cost of workarounds during processing](overlap_xml.md)

#### Outcome goals

* XML looks like a string (and it’s defined that way in the spec), but it’s really a tree. This requires workarounds not only in the markup, but also in the query.

#### Reading

* [“What can XPath do for me?”](http://dh.obdurodon.org/introduction-xpath.xhtml) (optional)

### 4:00-5:30: Transcription with markup: LMNL

#### Topics and activities

* XML and LMNL sawtooth syntax only look alike, and LMNL isn’t just XML with overlap
* **Hands on:** Tag [“Ozymandias”](ozymandias.txt) in LMNL
* What is Alexandria?
* Validation of LMNL with Luminescent
* Visualization of LMNL in Alexandria

#### Outcome goals

* Looking at and working with non-XML markup expands our ways of thinking about text, and about the workarounds we need in XML
* How do XML (tree) and LMNL (range) model “what text really is”? 
* Why does it matter as long as the workarounds work?

## Week 2, Day 2: Tuesday, July 18

### Synopsis

Week 2, Day 2 introduces the [Gothenburg model of textual variation](gothenburg.md) (GM) as an example of a computational pipeline perspective textual criticism. 

#### Outcome goals

* Digital editions as computational pipelines
* The five components of GM: tokenization, normalization, alignment, analysis, visualization
* The role of GM components outside the analysis of variation
* Tokenization in Python and in XSLT
* Normalization in Python and in XSLT

### 9:00–10:30: Introducing Text as Graph (TAG)

#### Topics and activities 

* Review of Week 2, day 1
	* The digital edition as a computational pipeline
	* Where data modeling belongs in the work flow
	* Markup as an expression of a data model; making the implicit explicit and machine-actionable
	* Model, syntax, and markup semantics
	* How XML copes with limitations of the tree as a document model
	* What’s so bad about work-arounds and relying on application-level semantics?
* Research-driven annotation: 1) What are the inherent properties of the text, and 2) What do I need for my research? Research questions →  data model (including query facilities) →  markup/annotation.
* Introduction to Text as Graph (TAG)
* Modeling overlap and discontinuity in XML, LMNL, and TAG
* Using a schema to bring markup semantics into the model at the application level
* LMNL ranges and TAG sets: similarities and differences: Mrs. Warren’s profession as [plain text](shaw.txt), XML, LMNL, and in TAG

#### Outcome goals

* Fundamentals of TAG: hypergraph
* Modeling discontinuity
* **Community-driven** vs **research-driven** analysis; “how do I do this in X?” vs “how should I model this?” 

### 11:00–12:30: The Gothenburg model of textual variation (GM)

#### Topics and activities

* Successful modeling reduces iterations of the document analysis → schema development → markup pipeline.
* The [Gothenburg model of textual variation (GM)](gothenburg.md) as a computational pipeline

#### Outcome goals

* GM as a computational pipeline—and not only for the study of variation

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


