# Week 2, Day 2: Tuesday, July 18

## Synopsis

The first half of Week 2, Day 2 continues the focus on document modeling from the previous day, with attention to three models of text: XML (text as tree), LMNL (text as ranges), and TAG (text as graph). The second half of the day introduces the idea of developing a digital edition as a computational pipeline. We illustrate the pipeline with the Gothenburg model of textual variation, and then begin to explore the first two stages of that model, tokenization and normalization. 

## Outcome goals

* Understanding modeling perspectives (tree, ranges, graph) and communities
* XML looks like a string but it’s really a tree. What does this mean for markup and for querying?
* Modular development: thinking about digital edition development as a computational pipeline
* Beginning to tokenize texts
* Beginning to normalize texts

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
10 min | Review of [Week 2, Day 1](week_2_day_1_plan.md)<br/>Modeling and communities | Discussion
35 min | [XPath as a way of navigating the tree](xpath.md) (using [*Hamlet*](hamlet.xml) in \<oXygen/\>) | Code Lab
20 min | XPath navigation of overlap in [“Ozymandias”](ozymandias.xml):<br/>Find 1) phrases, 2) enjambments, and 3) metrical lines| Code lab
15 min | The [cost of workarounds during processing](overlap_xml.md) | Presentation
10 min | What’s so bad about markup semantics, the application layer, and workarounds? | Discussion

## 10:30–11:00: Coffee break

## 11:00–12:30: Transcription with markup: LMNL

### Topics and activities

Time | Topic | Type
---- | ---- | ----
20 min | [Introduction to the LMNL data model and sawtooth syntax](lmnl_syntax.md) | Presentation
20 min | Tag [“Ozymandias”](ozymandias.txt) in LMNL | Code lab
20 min | Introduction to TAG and Alexandria | Presentation
20 min | [Alexandria installation](alexandria.md) | Code lab
20 min | Visualization of LMNL in Alexandria | Code lab

## 12:30–2:00: Lunch

## 2:00–3:30: Tokenization
  
## 3:30–4:00: Coffee break

## 4:00–5:30: Normalization

## Homework

Please complete [Week 2, Day 2 feedback](week_2_day_2_feedback.md) (just copy and paste it into a plain-text document) and email your response to Kaylen at [kaylensanders@pitt.edu](mailto:kaylensanders@pitt.edu) with the subject heading “Week 2, Day 2 feedback”.

## Reading (optional)

* [“What can XPath do for me?”](http://dh.obdurodon.org/introduction-xpath.xhtml)

## Follow-up optional

You can check your LMNL for well-formedness with the following procedure:

2. Install [Calabash](http://xmlcalabash.com/), an XProc tool.
1. Clone [Luminescent](https://github.com/djbpitt/Luminescent), a LMNL processor.
2. Edit `LMNLwf-calabash.sh` in your Luminscent directory to point to your installation of Calabash.
3. Run `./LMNLwf-calabash.sh x.lmnl`, replacing the “x.lmnl” with the path to your LMNL file.
