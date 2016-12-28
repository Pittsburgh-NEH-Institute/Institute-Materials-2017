// Grammar for the LMNL overlapping markup language format
// @author: Ronald Haentjens Dekker
// Question: Because of the overlapping annotations it is not possible to construct a parse tree?

lexer grammar LMNLGrammar;

OPENTAG : '[';
CLOSETAG : ']';


//parser grammar P
//
//options { tokenVocab=L; }
//
//r1 : FOO r2;
//
//r2 : r3 FOO;
//
//
//lexer grammar L;
//
//FOO : 'foo';