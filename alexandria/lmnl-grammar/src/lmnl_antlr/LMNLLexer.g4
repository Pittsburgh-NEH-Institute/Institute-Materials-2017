// Grammar for the LMNL overlapping markup language format
// @author: Ronald Haentjens Dekker
// Question: I wonder whether I have too many modes. Is a range and an annotation start really that different?
// Implementation of Name, DIGIT and NameChar are taken from ANTL XML grammar


lexer grammar LMNLLexer;

// In the default mode we are outside a Range
// we might expect text nodes here, but that is not yet implemented! [TODO]


// moves into range
OPEN_RANGE        :   '['                     -> pushMode(INSIDE_RANGE_OPENER) ;
TEXT              :   ~[{\\[]+ ;        // match any 16 bit char other than { (start close tag) and [ (start open tag)
CLOSE_RANGE       :   '{'                     -> pushMode(INSIDE_RANGE_CLOSE) ;

// ----------------- Everything INSIDE of a RANGE ---------------------
mode INSIDE_RANGE_OPENER;

CLOSE_RANGE_ANO :   ']'                     -> popMode ;
Name            :   NameStartChar NameChar* ;
S               :   [ \t\r\n]               -> skip ;
OPEN_ANNO       :   '['                     -> pushMode(INSIDE_ANNOTATION_OPENER) ;
CLOSE_RANGE_MARK:   '}'                     -> popMode ;

// ------------------ Everything INSIDE of a ANNOTATION OPENER -----------
// NOTE: We can have anonymous annotations!
mode INSIDE_ANNOTATION_OPENER;

Annotation_Name  :   NameStartChar NameChar* ;
ANNO_S           :   [ \t\r\n]               -> skip ;
OPEN_ANNO_IN_A   :   '['                     -> pushMode(INSIDE_ANNOTATION_OPENER) ;
CLOSE_ANNO_OP    :   '}'                     -> popMode, pushMode(INSIDE_ANNO_TEXT) ;
CLOSE_ANNO_MARK  :   ']'                     -> popMode ;

// ------------------ Inside TEXT --------------------------------------
mode INSIDE_ANNO_TEXT;
ANNO_TEXT        :   ~[{\\[]+ ;        // match any 16 bit char other than { (start close tag) and [ (start open tag)
CLOSE_ANNO       :   '{'                          -> popMode, pushMode(INSIDE_ANNOTATION_CLOSE) ;


// ----------------- Everything INSIDE of a ANNOTATION CLOSEr -------------
mode INSIDE_ANNOTATION_CLOSE;
Annotation_c_Name :   NameStartChar NameChar* ;
CLOSE_ANNO_MARKER :   ']'                     -> popMode ;

// ----------------- Everything INSIDE of a RANGE CLOSEr -------------
mode INSIDE_RANGE_CLOSE;
Range_c_Name       :   NameStartChar NameChar* ;
CLOSE_RANGE_MARKER :   ']'                     -> popMode ;


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