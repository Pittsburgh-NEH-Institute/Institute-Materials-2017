# Visualization as a view of the document

## Text and image are both views of information

Textual editions understandably foreground textual content, but from a modeling perspective, the text exists within a structure that may also be informational, and that may also be part of the way you conceptualize your edition. Meanwhile, a visual image, such as a chart of graph, tells a story about what it illustrates, and visualizations, even without words, may also be considered views of a document.

## Creating a visualization

Facsimile images are typically raster images, of which PNG and JPG are the most common (see our [overview of visualization file formats](visualization_formats.md) for descriptions of these and other formats). But charts and graphs created by the developer to reveal properties of the text are most often created programmatically, ultimately from the same sources (e.g., XML) that serve as the foundation of the reading view. From this perspective, the information is represented by the model (often, although not obligatorily, in XML), and a reading view in HTML or a graphic visualization in SVG are both created by transforming the XML using XSLT or XQuery or Python or other programming languages. 

## Choosing a visualization format

Choose SVG for interactivity

## Choosing a visualization type

Types of graphs and charts

## Visualization libraries

D3 vs DIY