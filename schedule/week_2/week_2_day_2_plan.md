# Week 2, Day 2: Tuesday, July 18

## Synopsis

The first half of Week 2, Day 2 continues the focus on document modeling from the previous day, with attention to three models of text: XML (text as tree), LMNL (text as ranges), and TAG (text as graph). The second half of the day introduces the idea of developing a digital edition as a computational pipeline. We illustrate the pipeline with the Gothenburg model of textual variation, and then begin to explore the first two stages of that model, tokenization and normalization. 

## Outcome goals

* Understanding modeling perspectives (tree, ranges, graph) and communities
* Modular development: thinking about digital edition development as a computational pipeline
* Beginning to tokenize texts
* Beginning to normalize texts

## Legend

* **Presentation:** by instructors
* **Discussion:** instructors and participants
* **Talk lab:** participants discuss or plan in small groups
* **Code lab:** participants code alone or in small groups

______

## 9:00–10:30: Theory of edition

Are you making an edition of a manuscript or of a text? What is the role of language and orthography in your edition? How will the text be presented? How will users interact with the views? What will be the role of graphic visualization?

Time | Topic | Type
---- | ----  | ----
20 min | Explore [edition terms and concepts](edition_terms_and_concepts.md) | Discussion
20 min | It isn’t just words! [What story are you trying to tell?](sample_visualizations.md) | Discussion
30 min | Explore participant data in light of terms and concepts | Talk lab
20 min | General discussion of Talk lab results | Discussion

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
