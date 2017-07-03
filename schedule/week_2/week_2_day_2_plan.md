# Week 2, Day 2: Tuesday, July 18

## Synopsis

Week 2, Day 2 introduces the idea of digital edition development as a computational pipeline for text processing. The [Gothenburg model of textual variation](gothenburg.md) (GM) serves as an example of a computational pipeline from the perspective of textual criticism. 

## Outcome goals

* Community-driven (prescriptive) vs research-driven (descriptive) analysis; “how do I represent this in system X?” vs “what do I think this is and how should I model it?”
* Modular development: the digital edition as a computational pipeline
* XML looks like a string (and it’s defined that way in the spec), but it’s really a tree. This requires workarounds not only in the markup, but also in the query.
* How XML copes with limitations of the tree as a document model
* What’s so bad about work-arounds and relying on application-level semantics?  

## Legend

* **Presentation:** by instructors
* **Discussion:** instructors and participants
* **Talk lab:** participants discuss or plan in small groups
* **Code lab:** participants code alone or in small groups

______

## 9:00–10:30: XML as a tree / XPath

### Topics and activities

Time | Topic | Type
---- | ---- | ----
15 min | Review of [Week 2, Day 1](week_2_day_1_plan.md) | Discussion
30 min | [XPath as a way of navigating the tree](xpath.md) (using [*Hamlet*](hamlet.xml) in \<oXygen/\>) | Code Lab
20 min | XPath navigation of overlap in [“Ozymandias”](ozymandias.xml):<br/>Find 1) phrases, 2) enjambments, and 3) metrical lines| Code lab
10 min | The [cost of workarounds during processing](overlap_xml.md) | Presentation
15 min | What’s so bad about markup semantics, the application layer, and workarounds? | Discussion

## 10:30-11:00: Coffee break

## 11:00-12:30: Transcription with markup: LMNL

### Topics and activities

* XML and LMNL sawtooth syntax only look alike, and LMNL isn’t just XML with overlap
* **Hands on:** Tag [“Ozymandias”](ozymandias.txt) in LMNL
* What is Alexandria?
* Validation of LMNL with Luminescent
* Visualization of LMNL in Alexandria

### Outcome goals

* Looking at and working with non-XML markup expands our ways of thinking about text, and about the workarounds we need in XML
* How do XML (tree) and LMNL (range) model “what text really is”? 
* Why does it matter as long as the workarounds work?

## 12:30-2:00: Lunch (on your own)

## 2:00-3:30: Models and computational pipelines
  
### Outcome goals

* The digital edition as a computational pipeline
* Conceptualizing digital editing as several steps or stadia, starting from one or several research questions and leading to an outcome
* The five components of GM: tokenization, normalization, alignment, analysis, visualization
* Understanding the GM as a computational pipeline — not only for the study of textual variation 

## 3:30-4:00: Coffee break

## 4:00-5:30: Tokenization 1

**[note: base this section partly on djb tutorial on XML processing]**

### Topics and Activities
* NLTK
* Tokenization in Python and in XSLT

### Outcome goals
* ***[some text here]***

## Readings (optional)

* [“What can XPath do for me?”](http://dh.obdurodon.org/introduction-xpath.xhtml)
