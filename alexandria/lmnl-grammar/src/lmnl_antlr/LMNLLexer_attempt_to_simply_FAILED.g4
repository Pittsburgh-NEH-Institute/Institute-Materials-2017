/*
 * Grammar for the LMNL overlapping markup language format
 * @author: Ronald Haentjens Dekker
 *
 * NOTE: In the lexicon/lexer ranges and annotation are treated the same. It is up to the parser to differentiate.
 * NOTE: Implementation of Name, DIGIT and NameChar are taken from ANTL XML grammar.
 */
lexer grammar LMNLLexer_attempt_to_simply_FAILED;

// In the default mode we are outside a Range
// We expect textual content or Ranges here
BEGIN_OPEN_RANGE        :   '['                     -> pushMode(INSIDE_RANGE_ANNOTATION_OPENER) ;
BEGIN_CLOSE_RANGE       :   '{'                     -> pushMode(INSIDE_RANGE_ANNOTATION_CLOSER) ;
TEXT                    :   ~[{\\[]+ ;        // match any 16 bit char other than { (start close tag) and [ (start open tag)

// ----------------- Everything INSIDE of a RANGE or ANNOTATION OPENER ---------------------
mode INSIDE_RANGE_ANNOTATION_OPENER;

// NOTE: We can have anonymous annotations!
END_ANONYMOUS_RANGE  :   ']'                     -> popMode ;
END_OPEN_RANGE       :   '}'                     -> popMode ;
BEGIN_OPEN_ANNO      :   '['                     -> pushMode(INSIDE_RANGE_ANNOTATION_OPENER) ;
S                    :   [ \t\r\n]               -> skip ;
Open_Name            :   NameStartChar NameChar* ;



// ----------------- Everything INSIDE of a RANGE or ANNOTATION CLOSER -------------
mode INSIDE_RANGE_ANNOTATION_CLOSER;
// TODO: close ranges can also have annotations on them!
Close_Name          :   NameStartChar NameChar* ;
END_CLOSE_RANGE     :   ']'                     -> popMode ;



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

