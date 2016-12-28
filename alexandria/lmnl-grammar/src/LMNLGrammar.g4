// Grammar for the LMNL overlapping markup language format
// @author: Ronald Haentjens Dekker
// Question: Because of the overlapping annotations it is not possible to construct a parse tree?
// Implementation of Name, DIGIT and NameChar are taken from ANTL XML grammar


lexer grammar LMNLGrammar;

// In the default mode we are outside a Range
// we might expect text nodes here, but that is not yet implemented! [TODO]


// moves into range
OPEN_RANGE        :   '['                     -> pushMode(INSIDE_RANGE) ;


// ----------------- Everything INSIDE of a RANGE ---------------------
mode INSIDE_RANGE;

CLOSE_RANGE :   ']'                     -> popMode ;
Name        :   NameStartChar NameChar* ;
S           :   [ \t\r\n]               -> skip ;
OPEN_ANNO   :   '['                     -> pushMode(INSIDE_ANNOTATION) ;


// ------------------ Everything INSIDE of a ANNOTATION ---------------
mode INSIDE_ANNOTATION;

Annotation_Name        :   NameStartChar NameChar* ;




// ----------------- lots of repeated stuff --------------------------
fragment
DIGIT       :   [0-9] ;

fragment
NameChar    :   NameStartChar
            |   '-' | '_' | '.' | DIGIT
            |   '\u00B7'
            |   '\u0300'..'\u036F'
            |   '\u203F'..'\u2040'
            ;

fragment
NameStartChar
            :   [:a-zA-Z]
            |   '\u2070'..'\u218F'
            |   '\u2C00'..'\u2FEF'
            |   '\u3001'..'\uD7FF'
            |   '\uF900'..'\uFDCF'
            |   '\uFDF0'..'\uFFFD'
            ;

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