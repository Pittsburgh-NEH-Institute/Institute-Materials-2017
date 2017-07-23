# Week 2, Day 1: Monday, July 17
## Synopsis

Scholars create digital editions to serve research purposes that may differ from project to project. The first day of Week 2 begins by exploring the role in project planning of defining research goals (which includes defining *non-goals* in order to avoid *scope-creep*). From planning and research questions we move to modeling and structuring the digital edition workflow as a computational pipeline, encouraging a modular perspective on digital editing.

## Outcome goals
* Don’t touch that keyboard! Planning *your* edition: starting with research questions
* Where data modeling belongs in the workflow
* Markup as an expression of a data model; making the implicit explicit and machine-actionable The relationships among model, syntax, and markup semantics
* How modeling reduces iterations of the document analysis → schema development → markup pipeline XML looks like a string but it’s really a tree. What does this mean for modeling, markup, and querying or processing?
## Legend

* **Presentation:** by instructors
* **Discussion:** instructors and participants
* **Talk lab:** participants discuss or plan in small groups
* **Code lab:** participants code alone or in small groups

* * *
## 9:00–10:30: Planning your project

There cannot be a single set of *best practice* recommendations for all digital editions because scholars create editions to meet different research goals, and they do that under different working conditions. What’s the purpose of your edition, and what are the resources at your disposal and the constraints on your efforts?

Time | Topic | Type
---- | ---- | ---- 
10 min | [Overview of Week 2](topics.md) | Presentation
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
20 min | Explore [other models and their expressions: LMNL, GODDAG, TexMECS, TAG](other_models.md) | Presentation

## 12:30–2:00: Lunch

## 2:00–3:30: Transcription with markup: XML

How are documents like trees and how are they different? What is represented by the model alone (the XML tree), and what requires markup semantics (schema)? What’s hard in XML and how do we do it anyway?

Time | Topic | Type
---- | ---- | ---- 
10 min | Create [your own fork of our Institute GitHub repository](fork.md) | Code lab
20 min | XML as a tree ([OHCO: “ordered hierarchy of content objects”])(ohco.md) | Discussion
15 min | [Making the implicit explicit with markup](explicit.md) | Discussion
30 min | Tag ["Oxymandias"](ozymandias.txt) in XML (e.g., lines, sentences, phrases, speakers, words, feet, syllables, stress) | Code lab
15 min | [What's hard in XML](xml_limitations.md) | Discussion

## 3:30–4:00: Coffee break

## 4:00–5:30: XML as a tree / XPath

Time | Topic | Type
---- | ---- | ---- 
10 min | Review of [Week 2, Day 1](week_2_day_1_plan.md), Modeling and communities | Discussion
35 min | [XPath as a way of navigating the tree](xpath.md) (using [Hamlet](hamlet.xml)) | Code lab
20 min | XPath navigation of overlap in ["Ozymandias"](ozymandias.xml): Find 1) phrases, 2) enjambments, and 3) metrical lines | Code lab
15 min | The [cost of workarounds during processing](overlap_xml.md) | Presentation
10 min | What’s so bad about markup semantics, the application layer, and workarounds? | Discussion

We’ll end each day with a request for feedback, based on a general version of the day’s outcome goals, and we’ll try to adapt on the fly to your responses. Please complete [Week 2, Day 1 feedback](week_2_day_1_feedback.md) (just copy and paste it into a plain-text document) and email your response to Kaylen at [kaylensanders@pitt.edu](mailto:kaylensanders@pitt.edu) with the subject heading “Week 2, Day 1 feedback”.