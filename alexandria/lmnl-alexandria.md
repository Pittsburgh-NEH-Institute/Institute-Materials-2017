# LMNL and Alexandria

2016-12-24 rhd, djb

## About LMNL

LMNL offers a data model (range algebra) and syntax. References from [the Lost archives of LMNL](http://lmnl-markup.org/specs/):

* [LMNL data model](http://lmnl-markup.org/specs/archive/LMNL_data_model.xhtml)
* [Range relationships](http://lmnl-markup.org/specs/archive/Range_relationships.xhtml)
* [LMNL syntax](http://lmnl-markup.org/specs/archive/LMNL_syntax.xhtml)
* [Liminal object model (LOM)](http://lmnl-markup.org/specs/archive/LOM.xhtml)

The CREOLE schema language for LMNL, which has not been implemented in production, is described in Jeni Tennison’s [Creole: validating overlapping markup](http://www.princexml.com/howcome/2007/xtech/papers/output/0077-30/index.xhtml). See also [her comments](http://www.jenitennison.com/2007/05/16/xtech-creole-presentation-fallout.html) about the discussion that followed the preceding presentation.

[Luminescent](https://github.com/wendellpiez/Luminescent) implements a LMNL processing library as an XSLT 2.0 pipeline, using Apache Cocoon. The Luminescent GitHub repo includes sample literary texts with LMNL markup. For discussion see Wendell Piez’s 2012 Balisage presentation: [Luminescent: parsing LMNL by XSLT upconversion](http://balisage.net/Proceedings/vol8/html/Piez01/BalisageVol8-Piez01.html), which also describes xLMNL, an XML-based representation of the LMNL data model.

LMNL is not necessarily hierarchical. For a discussion of hierarchical issues see Wendell’s 2014 Balisage presentation: [Hierarchies within range space](http://balisage.net/Proceedings/vol13/html/Piez01/BalisageVol13-Piez01.html), with illustrations from _Frankenstein_ and sonnets. Appendix C includes examples of XQuery code that can be executed over a compiled xLMNL representation of a LMNL document.

## About Alexandria

Alexandria is a text repository, graph database, and annotation server. For more information see the [Alexandria documentation](https://github.com/Pittsburgh-NEH-Institute/Institute-Materials-2017/blob/master/alexandria/alexandria_documentation.md) materials prepared for [Make _your_ edition: models and methods for digital textual scholarship](https://github.com/Pittsburgh-NEH-Institute/Institute-Materials-2017).

At present, Alexandria incorporates the following characteristics:

* Navigation is by XPath. This necessarily means engaging, at least in some respects, with a tree view of the structure.
* It does not incorporate a programming language. This means that it has the following limitations to its ability to transform documents:
	* Users can create new markup by adding annotations, but they cannot create new content.
	* Users can configure views of documents (e.g., hiding certain markup or content), but they cannot create new documents (e.g., by removing, rearranging, or rewriting content).
	* Although Alexandria can include information about multiple overlapping hierarchies, there is no recommended method for encoding and importing such documents. Alexandria can import XML with a single hierarchy and other hierarchies can be erected over the same document within Alexandria by creating annotations.

As a graph database, Alexandria is not constrained by the XML tree model, and can deal with overlap and other challenges to XML modeling in a more intuitive way than the workarounds now widely in use. Challenges to representing documents within the XML tree model include:

* Multiple overlapping hierarchies. Example:
	* Find all paragraphs that begin on an even-numbered page that do not end on that same page.
* Discontinuity. Example:
	* Find all speeches by a particular character, counting “‘Hello,’ he said, ‘how are you?’” as a single speech.
* Mixed content. Example:
	* Tokenize a line of verse with stressed vowels tagged as `<stress>` elements into words.

## About LMNL and Alexandria

LMNL and Alexandria both seek to overcome the single-hierarchy limitations of XML. LMNL offers a data model for conceptualizing overlap (not necessarily hierarchical) and a syntax for representing it, plus an implementation in Luminscent. Alexandria offers an opportunity for a second implementation, whether of original LMNL or of a derivative. Possible avenues for exploration:

* Alexandria could incorporate a LMNL parser that could import LMNL with overlap already encoded and create the overlapping annotations as part of the import process.
* Alexandria could incorporate a mechanism for validating LMNL, whether based on CREOLE or independent of it.