/* LMNL Parser grammar
 * @author: Ronald Haentjens Dekker
 *
 *
 */

parser grammar LMNLParser;

options { tokenVocab=LMNLGrammar; }

document    :   range | TEXT ;

range :  OPEN_RANGE Name CLOSE_RANGE_MARK TEXT CLOSE_RANGE Range_c_Name CLOSE_RANGE_MARKER ;

