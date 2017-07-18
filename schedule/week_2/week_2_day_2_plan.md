# Week 2, Day 2: Tuesday, July 18

## Synopsis

The first half of Week 2, Day 2 begins by contextualizing the XML and XPath tasks from the preceding day, and then introduces LMNL and TAG as alternative data models. The morning continues with a collaborative exploration of theorizing an edition, and especially of theorizing its development as a computational pipeline. The second half of the day continues the theme of the computational pipeline, which we illustrate with the Gothenburg model of textual variation, and we then practice with the first two stages of that model, tokenization and normalization. 

## Installations

* Java SE installation: <http://www.oracle.com/technetwork/java/javase/downloads/index.html>
* Docker (we’ll do this together in session 1)
* Optional: Calabash and Luminescent (instructions at the bottom of this document)

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


## 9:00–10:30: Transcription with markup: LMNL

### Topics and activities

Time | Topic | Type
---- | ---- | ----
10 min | Review of [week 2, day 1](week_2_day_1_plan.md) | Discussion
10 min | [Introduction to the LMNL data model and sawtooth syntax](lmnl_syntax.md) | Presentation
20 min | Tag [“Ozymandias”](ozymandias.txt) in LMNL | Code lab
20 min | Introduction to TAG and Alexandria | Presentation
15 min | [Alexandria installation](alexandria.md) | Code lab
15 min | Visualization of LMNL in Alexandria | Code lab

## 10:30–11:00: Coffee break

## 11:00–12:30: Theory of edition

Are you making an edition of a manuscript or of a text? What is the role of language and orthography in your edition? How will the text be presented? How will users interact with the views? What will be the role of graphic visualization?

Time | Topic | Type
---- | ----  | ----
20 min | Explore [edition terms and concepts](edition_terms_and_concepts.md) | Discussion
20 min | It isn’t just words! [What story are you trying to tell?](sample_visualizations.md) | Discussion
30 min | Explore participant data in light of terms and concepts | Talk lab
20 min | General discussion of Talk lab results | Discussion

## 12:30–2:00: Lunch

## 2:00–3:30: [Tokenization](Tokenization.ipynb)

When you have transcribed your text and are ready to process it (this could mean making a collation, or making a word cloud, or doing some experiements with stylometrics, or many other things), you will need to transform the text into a list of words. Conceptually this doesn't seem like a big deal, but many pitfalls can lie within...

Time | Topic | Type
---- | ----- | ----
20 min | Intro and setup | Discussion, Code lab
30 min | Tokenizing plain text | Code lab
30 min | Tokenizing XML | Code lab
20 min | Further challenges in tokenization | Discussion
  
## 3:30–4:00: Coffee break

## 4:00–5:30: Normalization

### Before we start

1. Navigate to your fork of our Institute repo and run `git pull upstream master`.
2. Start Jupyter notebook either from the Anaconda launcher or by navigating to your home directory and typing `jupyter notebook`.
3. Within the main Jupyter notebook web page, navigate to schedule/week_2 in your fork of our repo and open `Normalization.ipynb`, `Unicode-normalization.ipynb`, `Normalization_examples.ipynb`, and `Integrating_XML_with_Python.ipynb`.

Time | Topic | Type
---- | ---- | ----
30 min | About normalization (`Normalization.ipynb` notebook) | Code lab
10 min | Unicode normalization (`Unicode-normalization.ipynb` notebook) | Presentation
20 min | Normalization examples (`Normalization_examples.ipynb` notebook) | Presentation
30 min | Normalizing XML input (`Integrating_XML_with_Python.ipynb` notebook) | Code lab

## Homework

Please complete [Week 2, Day 2 feedback](week_2_day_2_feedback.md) (just copy and paste it into a plain-text document) and email your response to Kaylen at [kaylensanders@pitt.edu](mailto:kaylensanders@pitt.edu) with the subject heading “Week 2, Day 2 feedback”.

## Unicode tools

* Richard Ishida’s [Unicode code converter](https://r12a.github.io/apps/conversion/)
* `xxd` (command line utility)
* [Unicode checker](http://earthlingsoft.net/UnicodeChecker/) (Mac OS only; sorry!)

## LMNL follow-up (optional)

You can check your LMNL for well-formedness with the following procedure:

2. Install [Calabash](http://xmlcalabash.com/), an XProc tool.
1. Clone [Luminescent](https://github.com/djbpitt/Luminescent), a LMNL processor.
2. Edit `LMNLwf-calabash.sh` in your Luminscent directory to point to your installation of Calabash.
3. Run `./LMNLwf-calabash.sh x.lmnl`, replacing the “x.lmnl” with the path to your LMNL file.
