# Configuring Alexandria

Alexandria is a text repository and database that supports Text As Graph (TAG). We’ll use it in the Institute to gain perspective on modeling by exploring non-XML structured text representations.

##  What is Alexandria?
### Introduction
Briefly put, _Alexandria_ is a text repository system in which you can store and edit documents. It is the reference implementation of [TAG](https://huygensing.github.io/TAG/), a flexible graph data model for text. Here, the term "reference implementation" means that _Alexandria_ implements all the properties of the TAG model. So, by working with _Alexandria_ you'll learn more about TAG. And vice versa, if you want to experiment with the flexibilities of the TAG model _Alexandria_ is where you start. We already [talked about](https://github.com/Pittsburgh-NEH-Institute/Institute-Materials-2017/blob/master/schedule/week_2/tag.md) TAG and its modeling potential(Text-as-Graph); now it’s time to experiment with it.

You'll quickly find out that _Alexandria_ is not just any text repository. It builds on the idea that a text can be studied from various perspectives. For example, you can model a text according to a textual perspective or a documentary perspective; you can focus on adding linguistic annotations of a text, or rather information about structure of its verses. In _Alexandria_, you can store those different perspectives on the same text. What is more, Alexandria is build along the principles of a distributed architecture. It is a command line tool and it can be integrated in your own editor of choice.

By bringing together a wide range of information about a text in a structural and distributed way, _Alexandria_ facilitates the exchange and reuse of scholarly data. In short, _Alexandria_ is a powerful modeling instrument for digital textual research.


### Why should I use it?
If you enjoy experimenting with data models and advanced text analysis, _Alexandria_ is the tool for you. If you're used to working with XML, it is highly enlightening to work with a data model in which you can easily model overlapping structures, discontinuous elements, and nonlinear text without having to resort to workarounds.

### Can I use it?
Yes, you can. Keep in mind that both the TAG data model and the _Alexandria_ implementation are under development. This means that by using _Alexandria_ you will make a valuable contribution to the development process. We therefore encourage you to try it out and [share your thoughts](mailto:research-development@di.huc.knaw.nl).

As noted, _Alexandria_ is under active development. Navigate to [the GitHub repository](https://github.com/HuygensING/alexandria-markup-server) and use the up-to-date project README to download and use the latest version.