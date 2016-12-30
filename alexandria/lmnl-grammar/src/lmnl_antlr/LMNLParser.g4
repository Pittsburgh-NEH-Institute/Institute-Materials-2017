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

range : range_opener  TEXT CLOSE_RANGE Range_c_Name CLOSE_RANGE_MARKER ;

range_opener : OPEN_RANGE Name annotation? CLOSE_RANGE_MARK ;

annotation : OPEN_ANNO Annotation_Name CLOSE_ANNO_OP ANNO_TEXT CLOSE_ANNO Annotation_c_Name CLOSE_ANNO_MARKER ;