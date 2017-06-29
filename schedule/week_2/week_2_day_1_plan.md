# Week 2 - Day 1

## Week 2, Day 1: Monday, July 17

### Synopsis

Week 2, Day 1 concentrates on modeling textual documents, with attention to alternative models and their syntactic expressions. This day will also cover developing project specifications and defining goals and non-goals to avoid scope-creep.

### Legend

* **Presentation:** by instructors
* **Discussion:** instructors and participants
* **Talk lab:** participants discuss or plan in small groups
* **Code lab:** participants code alone or in small groups

______

### 9:00–10:30 Overview of Week 2 and planning your project

Time | Topic | Type
---- | ----  | ----
9:00–9:20 (20) | [Overview of Week 2](topics.md) | Presentation
9:20–9:40 (20) | Explore [project planning questions](project_planning.md) | Discussion
9:40–10:10 (30) | Apply project planning questions to your own project (individually or collaboratively) | Talk lab
10:10–10:30 (30) | General discussion of Talk lab results | Discussion

### 10:30–11:00 Coffee break

### 11:00–12:30 Theory of edition

Are you making an edition of a manuscript or of a text? What is the role of language and orthography in the edition? How will the text be presented? How can the user interact with the view? What will be the role of graphic visualization?

Time | Topic | Type
---- | ----  | ----
(20 min) | Explore [edition terms and concepts](edition_terms_and_concepts.md) | Discussion
(30 min) | [It isn’t just words! Explore [visualization as edition](sample_visualizations.md) _NOTE: might move to different day_] | Discussion
(20 min) | Explore participant data in light of terms and concepts | Talk lab
(20 min) | General discussion of Talk lab results | Discussion

### 12:30–14:00 Lunch (on your own)



--------
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
