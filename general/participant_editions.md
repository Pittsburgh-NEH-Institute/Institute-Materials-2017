# Digital editions by Institute participants

The following are selected editions prepared by members of our Institute. We define *digital edition* as ‘the digital publication of a text with editorial enhancement’. This is a broader definition than that employed by some other scholars within the digital editions community, such as [Patrick Sahle](http://www.digitale-edition.de/vlet-about.html) and [Greta Franzini](https://github.com/gfranzini/digEds_cat/wiki), whose focus is more specifically on editions that analyze variation during textual transmission. Institute participants are encouraged to contribute links for inclusion in this page, as a way of documenting the interests and accomplishments of our Institute community.

## Susanna Allés Torrent

[Vitae Illustrium Virorum](https://alfonsodepalencia.github.io/Vitae/) contains the first steps toward the conceptualization and implementation of a digital edition of a set of biographies written in Latin and translated into old Spanish during the fifteenth century. The edition is based on materials from my doctoral dissertation, “Parallelae sive Vitae Illustrium Virorum (Las Vidas de Plutarco, Sevilla, 1491). Estudio y edición crítica de la traducción de alfonso de Palencia de las vidas compuestas por Donato Acciaiuoli, Leonardo Bruni y Guarino Veronés”, defended at the University of Barcelona in 2012.

## Elisa Beshero-Bondar


[Amadis in translation](http://amadis.newtfire.org) is a bit of an experiment to see if my colleague and I can figure out *how much* an English nineteenth-century translator (Robert Southey) changed the sixteenth-century text of Amadis that he was translating. We’re preparing an edition (though the interface is not ready yet), but part of the goal is to highlight where semantic “chunks” of text line up with one another. You can see some graphs on the site that try to visualize how much was added, changed, transformed. It’s kind of an ongoing experiment, and our discussion of interfaces at the Institute last July has helped me lots in thinking about what we’ll do with the reading interface.

The most interesting part of the [Digital Mitford project](http://digitalmitford.org) at the moment is the letters, but we’ll be releasing our drama module with a group of plays, and the reading interface here is going to help draw the visitor to find letters related to the plays, and tie related materials together. We also need to work out a good searchable interface for our prosopography index—and I think Flask will help a lot here! 

The [Pittsburgh Frankenstein project](https://ebeshero.github.io/Pittsburgh_Frankenstein/) (currently just on GitHub), which I am pursuing together with Rikk Mulligan and other colleagues, is a collation of four editions of *Frankenstein* that seeks to reconcile two very different ways to encode a novel: the diplomatic (to try to represent the marks on handwritten manuscript pages with page-by-page attention to where margin notes sit, insertions, deletions, changing hands) and the simpler structural encoding we use for print editions of the novel. We were figuring this out during the Institute, and now (since October) we have worked out a way to reconcile these and get CollateX to show us how they align. For samples of aligned output see 
<https://github.com/ebeshero/Pittsburgh_Frankenstein/blob/master/collateXPrep/c56_textTableOutput/collation_C13.txt>
and <https://github.com/ebeshero/Pittsburgh_Frankenstein/tree/master/collateXPrep/c56_textTableOutput>.


## David J. Birnbaum

In the [e-PVL](http://pvl.obdurodon.org/browser.xhtml), I use CollateX to create a word-level alignment of variant readings. The digital [Codex Suprasliensis](http://suprasliensis.obdurodon.org/) is a fairly traditional diplomatic/facsimile edition. For something more original, which uses graphic visualization to represent and explore themes across linguistic traditions, see the [Digenis Akritis: Greek and Slavic](http://digenis.obdurodon.org/) and [Daniel the Prisoner: A virtual florilegium](http://zatochnik.obdurodon.org/). The texts at the [Annotated Afanas′ev library](http://aal.obdurodon.org/) form a pedagogical edition, with linguistic and folkloric annotations.

## Francesca Giovannetti

[Paolo Bufalini. Appunti (1981–1991)](https://github.com/marilenadaquino/bufalinis-notebook)

Between 1981 and 1991 Paolo Bufalini, Italian politician and renowned translator of Horace, kept a private notebook in which he gathered together his own thoughts, citations from Latin, Italian, and European classics, and translations. Bufalini’s aim was to reason about the history of literature, interpreting influences among his beloved authors and connecting their texts and ideas. The aim of the digital edition is to highlight all the aspects underpinning Bufalini’s network of citations, i.e., intertextuality and intratextuality.  

We decided to experiment with using semantic web technologies in combination with TEI to:

* represent inter/intratextual relations within a more expressive conceptual framework (ontologies vs schemas, graphs vs hierarchy);
* integrate data, allowing knowledge discovery across editions and other cultural resources on the web;
* make everything citable by associating persistent URIs with the entities composing the edition.

Collaborators: Marilena Daquino, Francesca Giovannetti, Francesca Tomasi

## Brian Long

I am working on the multilingual alignment of medieval scientific and medical texts, with the goal of supporting stylometry, text mining, and other investigations. Meant to be inclusive, the corpus integrates both works in the fields themselves and those that draw heavily upon scientific and medical materials, many of which have often been excluded from larger textual databases. The alignment tool is being developed at <https://github.com/mrgah/tralalign>.

## Rikk Mulligan

I am one of the developers of The [Pittsburgh Frankenstein project](https://ebeshero.github.io/Pittsburgh_Frankenstein/), described above under the entry for [Elisa Beshero-Bondar](#elisa-beshero-bondar).

## Christopher Ohge

My digital editing projects have covered quite a range of approaches. My first digital edition was a fairly traditional diplomatic-facsimile edition of journal by a minor Transcendentalist Christopher Cranch, which includes a fairly detailed personography: <http://scholarlyediting.org/2014/editions/intro.cranchjournal.html>.

When I was at the Mark Twain Project (c. 2014–2017), I used traditional approaches of eclectic text and documentary editing: <http://www.marktwainproject.org/homepage.html>. Because most of those texts involved very rigorous textual apparatus, we weren’t doing a lot of innovative mark-up. The app crit was enough work.

I’m currently a co-editor at the Melville Electronic Library, which employs a *fluid text* model of editing (for more on that you can read John Bryant’s *The fluid text* [U of Michigan P, 2002). For the past few years I’ve been working with a team on *Billy Budd* (still not done, but it’s getting there!): <https://mel.hofstra.edu/versions-of-billy-budd.html>.

You may recall that I quickly presented the following project on Mark Twain’s April Fool hoax (1884) at the Institute: <http://scholarlyediting.org/2017/editions/aprilfools/intro.html>.
This illustrates what I think is a more promising way of digital editing, in that it uses a variety of interfaces and considers the edition (as David has suggested) more broadly. In my case, this was an edition of an event, which included an annotated newspaper text, private documents with facsimiles, and a network graph. 

Thanks to the Institute, I’ve been thinking of ways that the curated data of editions can be extracted for other purposes. For example, with *Melville’s Marginalia Online* (<http://melvillesmarginalia.org>), on which I’m currently an associate editor, I’ve been working with a team to run quantitative analyses using R on the data of Melville’s reading of eight volumes of Shakespeare. Because the Melville-reading-Shakespeare files are marked up in XML, we can make distinctions in our analyses between marked passages and unmarked ones. Our GitHub repo with the R scripts (please note it is a work-in-progress) can be found at <https://github.com/melvillesmarks/ranalysis>. Eventually we’ll use this example to do analyses on larger data sets of Melville’s reading. 

## Nicola Reggiani

My research project (currently at the very beginning) stems from the Digital Corpus of the Greek Medical Papyri, launched at the Unversity of Parma by the late Professor Isabella Andorlini (project website: <http://www.papirologia.unipr.it/ERC>; source editions: <https://goo.gl/ZBbHkp>). The DCGMP consists of digital editions of Greek papyri of medical content, encoded in the TEI/EpiDoc-compliant Leiden+ papyrological markup on the SoSOL platform (<http://www.litpap.info>; source code at <https://github.com/DCLP>). My intention is to extend these editions with deep linguistic annotation; text alignment of parallels, intertext references, and translations; annotation of paratext (layout and graphical devices) and metatext (marginal/interlinear annotations, commentaries, glosses, etc.); and other tools that can help with the study and analysis of such a complex corpus of texts, deploying a very specialized technical language, an expression of what Hippocrates himself used to define a “long art”: ancient medicine.

## Gustavo Fernández Riva

I am developing an edition of Konrad von Würzburg’s short stories. The aim is to design a synoptic view that allows to explore textual variation. The edition offers different possible views for each text (paleographic, regularized, etc.), and users can easily compare the witnesses using the columns and functions provided in the interface or the embedded [Traviz](http://www.traviz.vizcovery.org/) tool. Until I find a better home for it, it is hosted in <http://kvwdigital.000webhostapp.com/>. The documentation can be found on <https://github.com/GusRiva/konrad-von-wuerzburg>.

