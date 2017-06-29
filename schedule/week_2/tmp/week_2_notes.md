# Week 2, Day 1 notes

Two state-of-the-art text models:

* tree model
* string model

We can move between them. The simplest way to “mark up” a plain text file is word tokenization.

Plain text has pseudo-markup, but so does XML, e.g., in the white space between words.

Some work with plain text doesn't care about subcomponents, e.g., authorship attribution. Other work, e.g., distinguishing dialog from narrative voice, requires structure.

Third model: TAG (cf. also LMNL, GODDAG; all attempts to understand “what text really is”). Can go from TAG to tree and to plain text; the other way is harder. Markup is making the implicit explicit syntactically; modeling is making it explicit in the ... er ... model. Cf. also JSON for modeling some types of information, but not primarily for documents.

Gothenburg model is about modularizing thinking about text, not just about modeling variation, so it’s relevant even if there isn’t collation/variation. E.g., even with a unique witness, there may be tokenization and normalization in service of linguistic or orthographic analysis.

If you want to make an edition now, the only mature technologies are XML and plain text.

Transcription is easier with XML than plain text, but tokenization is easier with plain text because you have to flatten the markup. Normalization adds additional information, so that’s easier in XML (or JSON).
____

Put activities in broader perspective: after modeling comes processing pipelines, then publishing, then the user takes over. GM is pipeline stages, as are NLTK POS/lemma tagging (a form of normalization). Building computational pipelines is the track that keeps the whole week together. Transformations from one model to another (e.g., XML to plain text). Collation is one of the pieces, but not the focus. This will articulate better with Mike's parts.

Python/XML example is a computational pipeline: tokenization, then POS tagging.

Tokenization recurs: NLTK, regex, Python `split()`, `<xsl:for-each-group>`, XPath `tokenize()`, `<xsl:analyze-string>`. Case normalization, Unicode canonicalization, whitespace normalization. Focus on concepts more than tools, e.g., what is tokenization, why do we do it, where, when. Focus on Python for illustration, but acknowledge XSLT and XQuery alternatives.

Tokenizing plain text is easy. Tokenizing XML is harder, but sometimes inevitable. Why is tokenizing tagged text difficult? The focus is on modeling and processing, yet sometimes the model competes with the processing.

Put this all in a broader context: tokenization has many implements; so does normalization. Collation is just one thing to do in a pipeline. This is where Python scripting enters the picture: what to do with Python vs XSLT/XQuery?

Mike uses plain text models (e.g., bag of words); he’ll also tokenize. So several computational steps will be repeated throughout the week.

Avoid foregrounding GM; these are just general steps in text processing. GM works even in situations that don’t involve alignment. Near matching is a kind of normalization, but it happens later. Near matching is completely different from exact matching for the computer, but not for humans, who calculate edit distance in parallel. Take focus away from GM; it’s just as an example.

<https://github.com/bleekere/Institute-Materials-2017/blob/master/schedule/week_2/planning-week-2-suggested.ipynb>

Split Python/XML tutorial: just tokenization, then add POS and lemma as normalization, then add text with real tags (stress, add, del), flatten the XML. This provides context for why we introduce LMNL and TAG, that is, for why we want to innovate.

Normalization during transcription. “Things are simultaneously the same and different”: alignment, linguistic statistics. Visualization as a bridge from editing (you have to plan ahead) to publishing (it’s a view of the documents).

Just as normalization means many things, so does annotation. Traditionally, it’s a note on the text. For us, it’s making the implicit explicit. How is a language corpus different from an edition.

Install Java SDK, Docker

The pipeline adds intelligence in the form of data and the organization of data

Language identification is an early step in the pipeline, and at different levels of granularity.
