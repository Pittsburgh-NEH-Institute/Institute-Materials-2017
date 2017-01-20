/* LMNL Parser grammar
 * @author: Ronald Haentjens Dekker
 *
 *
 */
// Question: Because of the overlapping annotations it is not possible to construct a parse tree?
// It seems it is.
parser grammar LMNLParser;

options { tokenVocab=LMNLLexer; }

document    :   range | TEXT ;

range : range_opener  range_content   range_closer ;

range_opener : BEGIN_OPEN_RANGE Name_Open_Range annotation? END_OPEN_RANGE;

range_content : TEXT;

range_closer : BEGIN_CLOSE_RANGE Name_Close_Range END_CLOSE_RANGE ;

annotation :  annotation_opener ANNO_TEXT annotation_closer ;

annotation_opener : BEGIN_OPEN_ANNO Name_Open_Annotation END_OPEN_ANNO ;

annotation_closer : BEGIN_CLOSE_ANNO Name_Close_Annotation END_CLOSE_ANNO ;