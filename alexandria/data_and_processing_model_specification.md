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
    [dates}1874-1963{]] }h
[s}[l [n}144{n]}He manages to keep the upper hand{l]
[l [n}145{n]}On his own farm.{s] [s}He's boss.{s] [s}But as to hens:{l]
[l [n}146{n]}We fence our flowers in and the hens range.{l]{s]
{excerpt]
```

Conversion:  

Text nodes:  

0. New line only text node
1. "He manages to keep the upper hand"
2. New line only text node
2. "On his own farm"
3. " " whitespace only text node
4. "He's boss."
5. " " whitespace only text node
6. "But as to hens:" 
7. New line only text node
7. "We fence our flowers in and the hens range."
8. New line only text node


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
5. TODO: add hyperedges for text
6. 

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

Annotation -> Text hyperedges:

1. HE connecting t1 with [excerpt, s1, l1].
2. HE connecting t2 with [excerpt, s1, l2].
3. HE connecting t4 with [excerpt, s2, l2].
4. HE connecting t5 with [excerpt, l2]. (whitespace)
4. HE connecting t6 with [excerpt, s3, l2].
5. HE connecting t7 with [excerpt, s3, l3].
6.  

