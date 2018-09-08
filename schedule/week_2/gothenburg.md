# The Gothenburg model of textual variation (GM)

GM emerged from a 2009 symposium within the frameworks of the EU-funded research projects COST Action 32 and Interedition, the output of which was the modularization of the study of textual variance into five stages:

1. [tokenization](tokenization.md)
2. normalization
3. [alignment](alignment.md)
4. [analysis](analysis.md)
4. visualization

Many of the components of GM are also useful outside the context of the study of textual variation.

One motivation for GM is that the high-level GM concepts are likely to be part of any study of textual variation, but the way they are understood and implemented may be informed in specific ways by the language, the text, and the research question. The modular structure makes it possible to customize one part of the process without having to rewrite the others. In other words, GM is a _pipeline_ model, where the five stages happen in order, the output of each serves as the input to the next, and no stage has to know about the inner workings of any other. 
