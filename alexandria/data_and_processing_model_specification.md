A graph based data and processing model for text

Author: Ronald Haentjens Dekker  
Date: 26-12-2016  
Goal: Specification document meant as a guide line for implementations  
Status: WORK IN PROGRESS!   
Based on concepts and ideas behind the LMNL markup language and the Alexandria text repository project.

Datamodel:  

* Directed Acyclic Hypergraph  
 TODO: add description
* Annotation node   
 TODO: add description
* Annotation edge  
 TODO: add description  
* Text node  
 TODO: add description 
* Text edge  
 TODO: add description
* Annotation - text hyperedge  
 TODO: add description

Example LMNL:  

Taken from Wendell's paper "Luminescent: parsing LMNL by XSLT upconversion"

```
[excerpt
  [source [date}1915{][title}The Housekeeper{]]
  [author
    [name}Robert Frost{]
    [dates}1874-1963{]] }
[s}[l [n}144{n]}He manages to keep the upper hand{l]
[l [n}145{n]}On his own farm.{s] [s}He's boss.{s] [s}But as to hens:{l]
[l [n}146{n]}We fence our flowers in and the hens range.{l]{s]
{excerpt]
```

Conversion:  

TODO: add "attribute" values as text nodes.  
Goal: treat all textual concent the same on a conceptual level. Implementations can make various optimizations.

 
Text nodes:  

Note: ID's are assigned arbitrarly and are only used for the purpose of making references to the IDed node in this document.  

0. ID: WS1; WS/New line only text node
1. ID: TC1; "He manages to keep the upper hand"
2. ID: WS2; WS/New line only text node
2. ID: TC2; "On his own farm"
3. ID: WS3; " " whitespace only text node
4. ID: TC3; "He's boss."
5. ID: WS4; " " whitespace only text node
6. ID: TC4; "But as to hens:" 
7. ID: WS5; New line only text node
7. ID: TC5; "We fence our flowers in and the hens range."
8. ID: WS6; New line only text node


Annotation nodes:

1. Node for tag "excerpt"
2. Node for tag "source"
3. Node for tag "date" with value "1915"
4. Node for tag "title" with value "The housekeeper"
5. Node for tag "author"
6. Node for tag "name" with value "Robert Frost"
7. Node for tag "dates" with value "1874-1963"
8. Node for tag "s"
9. Node for tag "l"
10. Node for tag "n" with value "144"
11. Node for tag "l"
1. Node for tag "n" with value "145"
2. Node for tag "s"
12. Node for tag "l"
13. Node for tag "n" with value "146"


  
Edges:   

1. Annotation edge to connect 1 and 2
2. Annotation edge to connect 2 and 3
3. Annotation edge to connect 4 and 2
4. TODO: lots of edges to add
6. 

TODO: add edges between text nodes to the record order of the text.
TODO: add edges between nodes on annotations of the same annotation (annotations are order in LMNL)


Example repeated here for clarity:

```
[excerpt
  [source [date}1915{][title}The Housekeeper{]]
  [author
    [name}Robert Frost{]
    [dates}1874-1963{]] }
[s}[l [n}144{n]}He manages to keep the upper hand{l]
[l [n}145{n]}On his own farm.{s] [s}He's boss.{s] [s}But as to hens:{l]
[l [n}146{n]}We fence our flowers in and the hens range.{l]{s]
{excerpt]
```

Text -> annotation nodes hyperedges:

1. HE connecting WS1 with [excerpt].
2. HE connecting TC1 with [excerpt, s1, l1].
1. HE connecting WS2 with [excerpt, s1].
2. HE connecting TC2 with [excerpt, s1, l2].
3. HE connecting WS3 with [excerpt, l2].
3. HE connecting TC3 with [excerpt, s2, l2].
4. HE connecting WS4 with [excerpt, l2].
4. HE connecting TC4 with [excerpt, s3, l2].
4. HE connecting WS5 with [excerpt, s3].
5. HE connecting TC5 with [excerpt, s3, l3].
6. HE connecting WS6 with [excerpt].
 

