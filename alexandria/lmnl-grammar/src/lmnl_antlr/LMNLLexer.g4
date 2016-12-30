/*
 * Grammar for the LMNL overlapping markup language format
 * @author: Ronald Haentjens Dekker
 *
 * NOTE: Implementation of Name, DIGIT and NameChar are taken from ANTL XML grammar
 */

lexer grammar LMNLLexer;

// In the default mode we are outside a Range
// [ moves into range
BEGIN_OPEN_RANGE        :   '['                     -> pushMode(INSIDE_RANGE_OPENER) ;
BEGIN_CLOSE_RANGE       :   '{'                     -> pushMode(INSIDE_RANGE_CLOSER) ;
TEXT                    :   ~[{\\[]+ ;        // match any 16 bit char other than { (start close tag) and [ (start open tag)

// ----------------- Everything INSIDE of a RANGE OPENER ---------------------
mode INSIDE_RANGE_OPENER;

END_ANONYMOUS_RANGE     :   ']'                     -> popMode ;
END_OPEN_RANGE          :   '}'                     -> popMode ;
BEGIN_OPEN_ANNO         :   '['                     -> pushMode(INSIDE_ANNOTATION_OPENER) ;
Name_Open_Range         :   NameStartChar NameChar* ;
RANGE_S                 :   [ \t\r\n]               -> skip ;

// ----------------- Everything INSIDE of a RANGE CLOSER -------------
mode INSIDE_RANGE_CLOSER;

END_CLOSE_RANGE         :   ']'                     -> popMode ;
Name_Close_Range        :   NameStartChar NameChar* ;

// ------------------ Everything INSIDE of a ANNOTATION OPENER -----------
// NOTE: Annotation openers are close to range openers, but not the same!
// NOTE: We can have anonymous annotations!
mode INSIDE_ANNOTATION_OPENER;

END_ANONYMOUS_ANNO      :   ']'                     -> popMode ;
END_OPEN_ANNO           :   '}'                     -> popMode, pushMode(INSIDE_ANNOTATION_TEXT) ;
OPEN_ANNO_IN_ANNO       :   '['                     -> pushMode(INSIDE_ANNOTATION_OPENER) ;
Name_Open_Annotation    :   NameStartChar NameChar* ;
ANNO_S                  :   [ \t\r\n]               -> skip ;

// ----------------- Everything INSIDE of a ANNOTATION CLOSER -------------
// NOTE: Annotation closers are exact copy of range closers
mode INSIDE_ANNOTATION_CLOSER;

END_CLOSE_ANNO          :   ']'                     -> popMode ;
Name_Close_Annotation   :   NameStartChar NameChar* ;

// ------------------ Inside ANNOTATION TEXT --------------------------------------
// NOTE:c Annotation text is simi
mode INSIDE_ANNOTATION_TEXT;
BEGIN_CLOSE_ANNO       :   '{'                          -> popMode, pushMode(INSIDE_ANNOTATION_CLOSER) ;
ANNO_TEXT              :   ~[{\\[]+ ;        // match any 16 bit char other than { (start close tag) and [ (start open tag)



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

