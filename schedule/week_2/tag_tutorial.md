Goal of this block:

On Day 1 the instructors will introduce participants to modeling their own texts as graphs, and to understanding how the graph model enables them to ask questions of those texts.

Total time: 1:30 hours

It can be mostly theoretical, discussion oriented and some exercises.


There are two ways to model text as a graph: use a markup language that allows overlap or modelling the layers in separate files (thus duplicating the textual content)



OLD inspiration
TAG is multiple things. It is a data model for text and an accompanining markup language. It allows for overlap to be modelled natively.

the Markup fgile and the underlying graph are related.
END OLD

H2. Introduction

Text as a graph (TAG) is a data model for text that supports markup, overlap as well as discontinuity.
The markup files are read into memory and the graph is build.
A graph consists of a set of nodes and edges. Edges connect the nodes to each other. A TAG is a property graph, which is a data structure where all of the edges and nodes are typed and can have properties attached to them.

Lets look at an example.
Given a file that contains the plain text "hello world". this will produce the graph as pictured in figure 1.
The graph consists of just two nodes; one node of type Document and one node of type Text. The Document node is represented by the elipse. The Text node is represented by the  box with the rounded corners. The edge connects the document node and the text node together.



<img src="images/tag_tutorial_propertygraph simple_example.gif">

Adding extra text or changing existing text only changes the contents of the text node.
See figure 2. <img src="images/tag_tutorial_propertygraph simple_example2.gif"> 



Adding annotation
Fragmentation of the thext nodes
hyper edges when markup crosses text node boundaries.




  


