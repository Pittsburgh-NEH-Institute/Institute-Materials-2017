# Topics

## Week 2: Philcamp: Digital philology, creating a digital edition

### Day 1: Modeling 

On the first day of Week 2 we emphasize three foundational aspects of digital textual scholarship: _text as graph_ (TAG), _theory of edition_, and the _Gothenburg model_ of textual variance (GM). This day will also cover developing project specifications and defining goals and non-goals to avoid _scope-creep_.

_Text as graph:_ The general framework we employ for discussing digital approaches to textual scholarship is text as graph (TAG), which allows the user to model arbitrary relationships among pieces of a text. In XML the information has to be stored in a hierarchical context, while with a graph model no such hierarchy is imposed (although the information may be structured hierarchically if one chooses, which means that the graph model is backwards compatible with the XML tree model). We employ TAG in the Institute to model structures that are important in documents whether or not they are isomorphic with an XML tree model. On Day 1 the instructors will introduce participants to modeling their own texts as graphs, and to understanding how the graph model enables them to ask questions of those texts.

_Theory of edition:_ Textual editing requires attention to the relationship of manuscript to text, to documentary vs analytic functions, to text and language, to exemplar and copy, and to what we have called a _reader-oriented theory of edition_ (Sels and Birnbaum 2016). A scholar should seek not merely to edit and publish a text, but to edit and publish a text _for a set of reasons_. On Day 1 the instructors will guide the participants through conceptualizing a research-driven, user-oriented edition.

_The Gothenburg model of textual variance (GM):_ GM emerged from a 2009 symposium within the frameworks of the EU-funded research projects COST Action 32 and Interedition, the output of which was the modularization of the study of textual variance into stages: tokenization, normalization, alignment, analysis, and visualization. On Day 1 the instructors will introduce GM to the participants. We address all of its parts in greater detail during the rest of Week 2, with continued attention to visualization in Week 3.

### Day 2: Transcription, tokenization, and normalization

Manuscript materials must be digitized as character data for subsequent computational processing as text. Transcription, tokenization, and normalization are foundational issues in philology independently of computation, but the digital environment entails additional assumptions and consequences. On Day 2 the instructors will first introduce computer character set conventions (plain vs fancy text, character vs glyph, Unicode, etc.). They will then guide the participants through the division of continuous text into smaller units for subsequent comparison (tokenization), and discuss strategies for letting the research goals of the project guide decisions about normalization. This portion of the Institute will also explore contextual normalization, that is, ways of exploiting textual distinctions for some purposes while ignoring them for others.

### Day 3: Collation

On Day 3 the instructors will explore the alignment stage of GM, or collation, through a hands-on introduction to using the open-source CollateX framework to align the participants’ own documents. This introduction will explore collation as a philological process (determining what to align with what), as a matter of data modeling (employing the notion of the _variant graph_ [Schmidt 2009]), and as an engineering challenge (negotiating the ambiguities and complexities raised by repetition, transposition, order effects, exact vs fuzzy matching, etc.).

### Day 4: Markup and annotation

The analysis stage is the researcher’s opportunity to interact with the automated alignment. This day will explore ways to build on top of XML structures (for example, using ranges or graphs) to represent properties that are difficult to express and process efficiently solely within the XML tree model. Day 4 will draw attention to layers of annotation (base, linguistic, named entity, etc.), examining how annotation layers interact within an edition. Participants will learn about customized annotation (e.g., through XPath), about natural language processing tools (Stanford, NLTK) that can be recruited to support linguistic annotation, and about the integration of those formerly stand-alone, plaintext applications into an XML environment (such as the recent incorporation of the Stanford NLP tools into the eXist-db XML database by one of the Institute instructors).

Beginning in Week 2, Day 4 and continuing through Week 3, Day 1, the Institute will welcome Mike Kestemont, a founding member of the Computational Stylistics Group, whose expertise in stylometry during the transition from Week 2 to Week 3 will supplement the digital edition expertise of the core instructors. On Week 2, Day 4 participants will be introduced to annotation-related prerequisites for the statistical exploration and analysis of textual information.

### Day 5: Query and exploration

Week 2, Day 5 develops a query functionality that lets the user express research questions in a way that addresses relevant annotation layers and retrieves information in a variety of formats (e.g., table, tree, graphic visualization). To the user this may look like an XML database, but underneath it can integrate tree, range, and graph modeling. Day 5 will include a discussion of textual queries and the retrieval of textual results, on the one hand, and statistical queries and the graphic visualization of their results, on the other.

## References

Modern language association. “Guidelines for editors of scholarly editions”. Last revised 29 June 2011.
<https://www.mla.org/Resources/Research/Surveys-Reports-and-Other-Documents/Publishing-and-Scholarship/Reports-from-the-MLA-Committee-on-Scholarly-Editions/Guidelines-for-Editors-of-Scholarly-Editions>.
Includes annotated bibliography by Dirk Van Hulle and others, also available separately at
<https://www.mla.org/Resources/Research/Surveys-Reports-and-Other-Documents/Publishing-and-Scholarship/Reports-from-the-MLA-Committee-on-Scholarly-Editions/Annotated-Bibliography-Key-Works-in-the-Theory-of-Textual-Editing>.

_RIDE. A review journal for digital editions and resources._ <http://ride.i-d-e.de/>

Sahle, Patrick, in collaboration with Georg Vogeler and the members of the IDE. 
“Criteria for Reviewing Scholarly Digital Editions, version 1.1”. 
<http://www.i-d-e.de/publikationen/weitereschriften/criteria-version-1-1/>

Schmidt, Desmond. 2009. “Merging multi-version texts: a generic solution to the overlap problem.” Presented at Balisage: the markup conference 2009, Montréal, Canada, August 11–14, 2009. In _Proceedings of Balisage: the markup conference 2009._ Balisage series on markup technologies, 3. doi:10.4242/BalisageVol3.Schmidt01. <https://www.balisage.net/Proceedings/vol3/html/Schmidt01/BalisageVol3-Schmidt01.html>

Sels, Lara and David J. Birnbaum 2015. “Editing the _Bdinski sbornik_ as a multilayered reality.” _Агиославика. Проблеми и подходи в изследването на Станиславовия чети-миней: доклади от едноименната конференция - 21 май 2013 г._ (_Hagioslavica. Issues and approaches in the study of the_ Stanislav Reading Menaion_: presentations from the conference of May 21, 2013.), ed. Diana Atanasova. Sofia: Kliment Oxridski University, pp. 184–99. <https://github.com/Pittsburgh-NEH-Institute/Institute-Materials-2017/blob/master/general/2014-01-14\_bdinski-sofia-paper.pdf>
