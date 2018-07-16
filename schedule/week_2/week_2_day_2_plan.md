# Week 2, Day 2: Tuesday, July 18
## Synopsis

The first half of Week 2, Day 2 continues the focus on document modeling from the previous day, with attention to three models of text: XML (text as tree), LMNL (text as ranges), and TAG (text as graph). The second half of the day introduces the idea of developing a digital edition as a computational pipeline. We illustrate the pipeline with the Gothenburg model of textual variation, and then begin to explore the first two stages of that model, tokenization and normalization. 

Before we go on, ensure that you have Java SE installed for your operating system. For the Java SE installation, see: 
<http://www.oracle.com/technetwork/java/javase/downloads/index.html>.

## Outcome goals

At the end of day 2, you will be able to: 

* Understand modeling perspectives (tree, ranges, graph) and communities
* Think about modular development: approach the development of a digital edition as a computational pipeline
* Take first steps toward tokenizing texts
* Take first steps toward normalizing texts


## Legend

* **Presentation:** by instructors
* **Discussion:** instructors and participants
* **Talk lab:** participants discuss or plan in small groups
* **Code lab:** participants code alone or in small groups

* * *

## 9:00–10:30: Transcription with markup: LMNL

We start with a brief recap of what we discussed and learned the previous day. This includes (but is not limited to) prevailing data models for text, working around the limitations of the XML model, processing XML files with XPath and querying XML with XQuery. If something is not clear, this is a moment to ask questions. We then go on to two explore other data models: first, the LMNL data model and its syntax (called "Sawtooth"), secondly the TAG data model.

Time | Topic | Type
---- | ---- | ---- 
20 min | Review of [week 2, day 1](week_2_day_1_plan.md) | Discussion
30 min | [Introduction to the LMNL data model and sawtooth syntax](lmnl_syntax.md) | Presentation
20 min | Tag "[Ozymandias](ozymandias.txt)" in LMNL | Code lab
20 min | Introduction to [TAG and Alexandria](tag.md) | Presentation

<!--- 15 min | [Alexandria installation](../week_3/alexandria.md) | Code lab -->
<!--- 15 min | [Visualization of LMNL in Alexandria](lmnl_alexandria.md) | Code lab -->
<!--- NOTE: In view of the ongoing developments on the TAG datamodel, its syntax, and Alexandria we considered it undesirable to include the units about Alexandria's installation and LMNL in Alexandria: it would confuse future users and force us to keep alive Alexandria's support for LMNL (EB 20180716) -->

## 10:30–11:00: Coffee break

## 11:00–12:30: Theory of edition

This unit focuses on some fundamental theoretical questions you have to ask before embarking on the creation of a digital edition. Are you making an edition of a manuscript or of a text? What is the role of language and orthography in your edition? How will the text be presented? How will users interact with the views? What will be the role of graphic visualization?

Time | Topic | Type
---- | ---- | ---- 
20 min | Explore [edition terms and concepts](edition_terms_and_concepts.md) and the [digital workstation](../week_3/digital_workstation.md) | Discussion
20 min | It isn’t just words! [What story are you trying to tell?](sample_visualizations.md) | Discussion
30 min | Explore participant data in light of terms and concepts | Talk lab
20 min | General discussion of Talk lab results | Discussion

## 12:30–2:00: Lunch

## 2:00–3:30: Tokenization

The afternoon session is devoted to the basic concepts of tokenization and normalization in the context of a digital edition. These two steps constitute the foundation of many forms of digital text processing; we discuss them in relation to studying textual variation but if you carry out stylometric analysis you would also tokenize and normalize your text. As tokanization and normalization constitute the first two steps of the pipeline of the Gothenburg model, they also serve as practical illustrations of the concept of computational pipelines for textual analysis.

Time | Topic | Type
---- | ---- | ---- 
10 min | [CollateX installation](https://github.com/Pittsburgh-NEH-Institute/Institute-Materials-2017/blob/master/schedule/week_2/collatex_installation.ipynb) | Discussion
30 min | [Tokenizing plain text](https://github.com/Pittsburgh-NEH-Institute/Institute-Materials-2017/blob/master/schedule/week_2/Tokenization.ipynb) | Code lab
30 min | [Tokenizing XML](https://github.com/Pittsburgh-NEH-Institute/Institute-Materials-2017/blob/master/schedule/week_2/Tokenization.ipynb) (scroll to “The next step: tokenizing XML”) | Code lab
20 min | [Further challenges in tokenization](tokenization.md) | Discussion

## 3:30–4:00: Coffee break

## 4:00–5:30: Normalization

Before we start, prepare your work environment: 

1. Navigate to your fork of our Institute repo and run `git pull upstream remote`. 
2. Start Jupyter notebook either from the Anaconda launcher or by navigating to your home directory and typing `jupyter notebook`. 
3. Within the main Jupyter notebook web page, navigate to `schedule/week_2` in your fork of our repo and open `Normalization.ipynb`, `Unicode-normalization.ipynb`, `Normalization_examples.ipynb`, and `Integrating_XML_with_Python.ipynb`.

Time | Topic | Type
---- | ---- | ---- 
30 min | [About normalization](https://github.com/Pittsburgh-NEH-Institute/Institute-Materials-2017/blob/master/schedule/week_2/Normalization.ipynb) | Code lab
10 min | [Unicode normalization](https://github.com/Pittsburgh-NEH-Institute/Institute-Materials-2017/blob/master/schedule/week_2/Unicode_normalization.ipynb) | Presentation
20 min | [Normalization examples](https://github.com/Pittsburgh-NEH-Institute/Institute-Materials-2017/blob/master/schedule/week_2/Normalization.ipynb) | Presentation
30 min | [Normalizing XML input](https://github.com/Pittsburgh-NEH-Institute/Institute-Materials-2017/blob/master/schedule/week_2/Integrating_XML_with_Python.ipynb) | Code lab

We’ll end each day with a request for feedback, based on a general version of the day’s outcome goals, and we’ll try to adapt on the fly to your responses. Please complete [Week 2, Day 2 feedback](week_2_day_2_feedback.md) (just copy and paste it into a plain-text document) and email your response to Kaylen at [kaylensanders@pitt.edu](mailto:kaylensanders@pitt.edu) with the subject heading “Week 2, Day 2 feedback”.