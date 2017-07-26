# Week 2, Day 2: Tuesday, July 18
## Synopsis

The first half of Week 2, Day 2 continues the focus on document modeling from the previous day, with attention to three models of text: XML (text as tree), LMNL (text as ranges), and TAG (text as graph). The second half of the day introduces the idea of developing a digital edition as a computational pipeline. We illustrate the pipeline with the Gothenburg model of textual variation, and then begin to explore the first two stages of that model, tokenization and normalization. Java SE installation: <"http://www.oracle.com/technetwork/java/javase/downloads/index.html">. Choose Java SE for your operating system

## Outcome goals
* Understanding modeling perspectives (tree, ranges, graph) and communities Modular development: thinking about digital edition development as a computational pipeline
* Beginning to tokenize texts
* Beginning to normalize texts
## Legend

* **Presentation:** by instructors
* **Discussion:** instructors and participants
* **Talk lab:** participants discuss or plan in small groups
* **Code lab:** participants code alone or in small groups

* * *
## 9:00–10:30: Transcription with markup: LMNL

Time | Topic | Type
---- | ---- | ---- 
10 min | Review of [week 2, day 1](week_2_day_1_plan.md) | Discussion
10 min | [Introduction to the LMNL data model and sawtooth syntax](lmnl_syntax.md) | Presentation
20 min | Tag "[Ozymandias](ozymandias.txt)" in LMNL | Code lab
20 min | Introduction to TAG and Alexandria | Presentation
15 min | [Alexandria installation](alexandria.md) | Code lab
15 min | Visualization of LMNL in Alexandria | Code lab

## 10:30–11:00: Coffee break

## 11:00–12:30: Theory of edition

Are you making an edition of a manuscript or of a text? What is the role of language and orthography in your edition? How will the text be presented? How will users interact with the views? What will be the role of graphic visualization?

Time | Topic | Type
---- | ---- | ---- 
20 min | Explore [edition terms and concepts](edition_terms_and_concepts.md) | Discussion
20 min | It isn’t just words! [What story are you trying to tell?](sample_visualizations.md) | Discussion
30 min | Explore participant data in light of terms and concepts | Talk lab
20 min | General discussion of Talk lab results | Discussion

## 12:30–2:00: Lunch

## 2:00–3:30: Tokenization

Time | Topic | Type
---- | ---- | ---- 
10 min | Intro and setup | Discussion
30 min | Tokenizing plain text | Code lab
30 min | Tokenizing XML | Code lab
20 min | Further challenges in tokenization | Discussion

## 3:30–4:00: Coffee break

## 4:00–5:30: Normalization

Before we start: 1. Navigate to your fork of our Institute repo and run `git pull upstream remote`. 2. Start Jupyter notebook either from the Anaconda launcher or by navigating to your home directory and typing `jupyter notebook`. 3. Within the main Jupyter notebook web page, navigate to schedule/week_2 in your fork of our repo and open `Normalization.ipynb`, `Unicode-normalization.ipynb`, `Normalization_examples.ipynb`, and `Integrating_XML_with_Python.ipynb`.

Time | Topic | Type
---- | ---- | ---- 
30 min | About normalization (`Normalization.ipynb` notebook) | Code lab
10 min | Unicode normalization (`Unicode-normalization.ipynb` notebook) | Presentation
20 min | Normalization examples (`Normalization_examples.ipynb` notebook) | Presentation
30 min | Normalizing XML input (`Integrating_XML_with_Python.ipynb` notebook) | Code lab

We’ll end each day with a request for feedback, based on a general version of the day’s outcome goals, and we’ll try to adapt on the fly to your responses. Please complete [Week 2, Day 2 feedback](week_2_day_2_feedback.md) (just copy and paste it into a plain-text document) and email your response to Kaylen at [kaylensanders@pitt.edu](mailto:kaylensanders@pitt.edu) with the subject heading “Week 2, Day 2 feedback”.