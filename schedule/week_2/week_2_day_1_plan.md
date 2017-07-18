# Week 2, Day 1: Monday, July 17

## Synopsis

Scholars create digital editions to serve research purposes that may differ from project to project. The first day of Week 2 begins by exploring the role in project planning of defining research goals (which includes defining *non-goals* in order to avoid *scope-creep*). From planning and research questions we move to modeling, and then to an exploration of XML markup and processing from a modeling perspective.

## Outcome goals

* Don’t touch that keyboard! Planning *your* edition: starting with research questions
* Where data modeling belongs in the workflow
* Markup as an expression of a data model; making the implicit explicit and machine-actionable
* The relationships among model, syntax, and markup semantics
* How modeling reduces iterations of the document analysis → schema development → markup pipeline
* XML looks like a string but it’s really a tree. What does this mean for modeling, markup, and querying or processing?

## Legend

* **Presentation:** by instructors
* **Discussion:** instructors and participants
* **Talk lab:** participants discuss or plan in small groups
* **Code lab:** participants code alone or in small groups

______

## 9:00–10:30: Planning your project

There cannot be a single set of *best practice* recommendations for all digital editions because scholars create editions to meet different research goals, and they do that under different working conditions. What’s the purpose of your edition, and what are the resources at your disposal and the constraints on your efforts?

Time | Topic | Type
---- | ----  | ----
10 min | Overview of Week 2 | Presentation
30 min | Explore [project planning questions](project_planning.md) | Discussion
25 min | Apply project planning questions to your own project (individually or collaboratively) | Talk lab
25 min | General discussion of Talk lab results | Discussion

## 10:30–11:00: Coffee break

## 11:00–12:30: Model, syntax, and markup semantics

How can the elaboration of a digital edition be modularized? How are *model*, *syntax*, and *markup semantics* similar and different?

Time | Topic | Type
---- | ---- | ----
20 min | Explore [model, syntax, and markup semantics](model_syntax_semantics.md) | Presentation
25 min | Explore [plain text as model and expression](plain.md) | Discussion
25 min | Explore [XML as model and expression](xml_model.md) | Discussion
20 min| Explore [other models and their expressions: LMNL, GODDAG, TexMECS, TAG](other_models.md) | Presentation

## 12:30–2:00 Lunch

## 2:00–3:30: Transcription with markup: XML

How are documents like trees and how are they different? What is represented by the model alone (the XML tree), and what requires markup semantics (schema)? What’s hard in XML and how do we do it anyway?

Time | Topic | Type
---- | ---- | ----
10 min | Create [your own fork of our Institute GitHub repository](fork.md) | Code lab
20 min | XML as a tree ([OHCO: “ordered hierarchy of content objects”](ohco.md)) | Discussion
15 min | [Making the implicit explicit with markup](explicit.md) | Discussion
30 min | Tag [“Ozymandias”](ozymandias.txt) in XML (e.g., lines, sentences, phrases, speakers, words, feet, syllables, stress) | Code lab
15 min | [What’s hard in XML](xml_limitations.md) | Discussion

## 3:30–4:00: Coffee break

## 4:00–5:30: XML as a tree / XPath

### Topics and activities

Time | Topic | Type
---- | ---- | ----
10 min | Review of [Week 2, Day 1](week_2_day_1_plan.md)<br/>Modeling and communities | Discussion
35 min | [XPath as a way of navigating the tree](xpath.md) (using [*Hamlet*](hamlet.xml) in \<oXygen/\>) | Code Lab
20 min | XPath navigation of overlap in [“Ozymandias”](ozymandias.xml):<br/>Find 1) phrases, 2) enjambments, and 3) metrical lines| Code lab
15 min | The [cost of workarounds during processing](overlap_xml.md) | Presentation
10 min | What’s so bad about markup semantics, the application layer, and workarounds? | Discussion

## Homework

We’ll end each day with a request for feedback, based on a general version of the day’s outcome goals, and we’ll try to adapt on the fly to your responses. Please complete [Week 2, Day 1 feedback](week_2_day_1_feedback.md) (just copy and paste it into a plain-text document) and email your response to Kaylen at [kaylensanders@pitt.edu](mailto:kaylensanders@pitt.edu) with the subject heading “Week 2, Day 1 feedback”.

## Readings (optional)

The following readings are mentioned in the individual activities for this day.

* Barnard, David, Ron Hayter, Maria Karababa, George Logan, and John McFadden. [“SGML-based markup for literary texts: two problems and some solutions.”](http://www.jstor.org/stable/30200136) *Computers and the humanities*, Vol. 22, No. 4 (1988), pp. 265–76.
* Birnbaum, David J. [“What can XPath do for me?”](http://dh.obdurodon.org/introduction-xpath.xhtml).
* Birnbaum, David J. [What is XML and why should humanists care? An even gentler introduction to XML](http://dh.obdurodon.org/what-is-xml.xhtml).
* Birnbaum, David J. and Elise Thorsen, [“Markup and meter: Using XML tools to teach a computer to think about versification.”](https://www.balisage.net/Proceedings/vol15/html/Birnbaum01/BalisageVol15-Birnbaum01.html) Presented at Balisage: The Markup Conference 2015, Washington, DC, August 11-14, 2015. In *Proceedings of Balisage: The Markup Conference 2015*. Balisage Series on Markup Technologies, vol. 15 (2015). DOI: 10.4242/BalisageVol15.Birnbaum01.
* Cayless, Hugh ["Graphs, Trees, and Streams: the TEI Data Model"](http://blogs.library.duke.edu/dcthree/2013/08/26/graphs-trees-and-streams-the-tei-data-model/). Blog post (2013).
* [_CCSG_] Brepols publishers. [“Instructions and stylebook for the publication of texts in CCSG [_Corpus christianorum series graeca_].”](http://www.corpuschristianorum.org/series/pdf/CCSG_Guidelines.pdf)
* DeRose, Steven J., David G. Durand, Elli Mylonas, and Allen H. Renear. [“What is text, really?”](http://www.cip.ifi.lmu.de/~langeh/test/1990%20-%20DeRose%20-%20What%20is%20Text,%20really%3F.pdf), *Journal of computing in higher education*, 1.2 (1990): 3–26. doi:10.1007/BF02941632.
* [DocBook: The definitive guide](http://tdg.docbook.org/tdg/5.2/para.html)
* Haentjens Dekker, Ronald and David J. Birnbaum. [“It’s more than just overlap: Text As Graph”.](balisage-tag/Bal2017dekk0505.html) To be presented at Balisage: The Markup Conference 2017.
* [HTML5. A vocabulary and associated APIs for HTML and XHTML.
W3C Recommendation 28 October 2014](https://www.w3.org/TR/html5/)
* Renear, Allen, Elli Mylonas, and David Durand. [“Refining our notion of what text really is: the problem of overlapping hierarchies”.](http://cds.library.brown.edu/resources/stg/monographs/ohco.html)
* Sels, Lara and David J. Birnbaum 2015. [“Editing the _Bdinski sbornik_ as a multilayered reality.”](../../general/2014-01-14_bdinski-sofia-paper.pdf) _Агиославика. Проблеми и подходи в изследването на Станиславовия чети-миней: доклади от едноименната конференция - 21 май 2013 г._ (_Hagioslavica. Issues and approaches in the study of the_ Stanislav Reading Menaion: _presentations from the conference of May 21, 2013._), ed. Diana Atanasova. Sofia: Kliment Oxridski University, pp. 184–99.
* [TEI P5: Guidelines for Electronic Text Encoding and Interchange](http://www.tei-c.org/release/doc/tei-p5-doc/en/html/index.html)
* Tennison, Jeni. [“Overlap, containment and dominance. Jeni’s musings, 2008-12-06”]( http://www.jenitennison.com/2008/12/06/overlap-containment-and-dominance.html).
