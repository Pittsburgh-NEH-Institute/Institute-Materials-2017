// Generated from /Users/ronalddekker/Workspace/Institute-Materials-2017/alexandria/lmnl-grammar/src/main/java/lmnl_antlr/LMNLLexer.g4 by ANTLR 4.6
package lmnl_antlr;
import org.antlr.v4.runtime.Lexer;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.TokenStream;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.misc.*;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class LMNLLexer extends Lexer {
	static { RuntimeMetaData.checkVersion("4.6", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		BEGIN_OPEN_RANGE=1, BEGIN_CLOSE_RANGE=2, TEXT=3, END_ANONYMOUS_RANGE=4, 
		END_OPEN_RANGE=5, BEGIN_OPEN_ANNO=6, Name_Open_Range=7, RANGE_S=8, END_CLOSE_RANGE=9, 
		Name_Close_Range=10, END_ANONYMOUS_ANNO=11, END_OPEN_ANNO=12, OPEN_ANNO_IN_ANNO=13, 
		Name_Open_Annotation=14, ANNO_S=15, END_CLOSE_ANNO=16, Name_Close_Annotation=17, 
		BEGIN_CLOSE_ANNO=18, ANNO_TEXT=19;
	public static final int INSIDE_RANGE_OPENER = 1;
	public static final int INSIDE_RANGE_CLOSER = 2;
	public static final int INSIDE_ANNOTATION_OPENER = 3;
	public static final int INSIDE_ANNOTATION_CLOSER = 4;
	public static final int INSIDE_ANNOTATION_TEXT = 5;
	public static String[] modeNames = {
		"DEFAULT_MODE", "INSIDE_RANGE_OPENER", "INSIDE_RANGE_CLOSER", "INSIDE_ANNOTATION_OPENER", 
		"INSIDE_ANNOTATION_CLOSER", "INSIDE_ANNOTATION_TEXT"
	};

	public static final String[] ruleNames = {
		"BEGIN_OPEN_RANGE", "BEGIN_CLOSE_RANGE", "TEXT", "END_ANONYMOUS_RANGE", 
		"END_OPEN_RANGE", "BEGIN_OPEN_ANNO", "Name_Open_Range", "RANGE_S", "END_CLOSE_RANGE", 
		"Name_Close_Range", "END_ANONYMOUS_ANNO", "END_OPEN_ANNO", "OPEN_ANNO_IN_ANNO", 
		"Name_Open_Annotation", "ANNO_S", "END_CLOSE_ANNO", "Name_Close_Annotation", 
		"BEGIN_CLOSE_ANNO", "ANNO_TEXT", "DIGIT", "NameChar", "NameStartChar"
	};

	private static final String[] _LITERAL_NAMES = {
	};
	private static final String[] _SYMBOLIC_NAMES = {
		null, "BEGIN_OPEN_RANGE", "BEGIN_CLOSE_RANGE", "TEXT", "END_ANONYMOUS_RANGE", 
		"END_OPEN_RANGE", "BEGIN_OPEN_ANNO", "Name_Open_Range", "RANGE_S", "END_CLOSE_RANGE", 
		"Name_Close_Range", "END_ANONYMOUS_ANNO", "END_OPEN_ANNO", "OPEN_ANNO_IN_ANNO", 
		"Name_Open_Annotation", "ANNO_S", "END_CLOSE_ANNO", "Name_Close_Annotation", 
		"BEGIN_CLOSE_ANNO", "ANNO_TEXT"
	};
	public static final Vocabulary VOCABULARY = new VocabularyImpl(_LITERAL_NAMES, _SYMBOLIC_NAMES);

	/**
	 * @deprecated Use {@link #VOCABULARY} instead.
	 */
	@Deprecated
	public static final String[] tokenNames;
	static {
		tokenNames = new String[_SYMBOLIC_NAMES.length];
		for (int i = 0; i < tokenNames.length; i++) {
			tokenNames[i] = VOCABULARY.getLiteralName(i);
			if (tokenNames[i] == null) {
				tokenNames[i] = VOCABULARY.getSymbolicName(i);
			}

			if (tokenNames[i] == null) {
				tokenNames[i] = "<INVALID>";
			}
		}
	}

	@Override
	@Deprecated
	public String[] getTokenNames() {
		return tokenNames;
	}

	@Override

	public Vocabulary getVocabulary() {
		return VOCABULARY;
	}


	public LMNLLexer(CharStream input) {
		super(input);
		_interp = new LexerATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@Override
	public String getGrammarFileName() { return "LMNLLexer.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public String[] getModeNames() { return modeNames; }

	@Override
	public ATN getATN() { return _ATN; }

	public static final String _serializedATN =
		"\3\u0430\ud6d1\u8206\uad2d\u4417\uaef1\u8d80\uaadd\2\25\u009b\b\1\b\1"+
		"\b\1\b\1\b\1\b\1\4\2\t\2\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t"+
		"\b\4\t\t\t\4\n\t\n\4\13\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20"+
		"\t\20\4\21\t\21\4\22\t\22\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27"+
		"\t\27\3\2\3\2\3\2\3\2\3\3\3\3\3\3\3\3\3\4\6\4>\n\4\r\4\16\4?\3\5\3\5\3"+
		"\5\3\5\3\6\3\6\3\6\3\6\3\7\3\7\3\7\3\7\3\b\3\b\7\bP\n\b\f\b\16\bS\13\b"+
		"\3\t\3\t\3\t\3\t\3\n\3\n\3\n\3\n\3\13\3\13\7\13_\n\13\f\13\16\13b\13\13"+
		"\3\f\3\f\3\f\3\f\3\r\3\r\3\r\3\r\3\r\3\16\3\16\3\16\3\16\3\17\3\17\7\17"+
		"s\n\17\f\17\16\17v\13\17\3\20\3\20\3\20\3\20\3\21\3\21\3\21\3\21\3\22"+
		"\3\22\7\22\u0082\n\22\f\22\16\22\u0085\13\22\3\23\3\23\3\23\3\23\3\23"+
		"\3\24\6\24\u008d\n\24\r\24\16\24\u008e\3\25\3\25\3\26\3\26\3\26\3\26\5"+
		"\26\u0097\n\26\3\27\5\27\u009a\n\27\2\2\30\b\3\n\4\f\5\16\6\20\7\22\b"+
		"\24\t\26\n\30\13\32\f\34\r\36\16 \17\"\20$\21&\22(\23*\24,\25.\2\60\2"+
		"\62\2\b\2\3\4\5\6\7\b\4\2]^}}\5\2\13\f\17\17\"\"\3\2\62;\4\2/\60aa\5\2"+
		"\u00b9\u00b9\u0302\u0371\u2041\u2042\n\2<<C\\c|\u2072\u2191\u2c02\u2ff1"+
		"\u3003\ud801\uf902\ufdd1\ufdf2\uffff\u009b\2\b\3\2\2\2\2\n\3\2\2\2\2\f"+
		"\3\2\2\2\3\16\3\2\2\2\3\20\3\2\2\2\3\22\3\2\2\2\3\24\3\2\2\2\3\26\3\2"+
		"\2\2\4\30\3\2\2\2\4\32\3\2\2\2\5\34\3\2\2\2\5\36\3\2\2\2\5 \3\2\2\2\5"+
		"\"\3\2\2\2\5$\3\2\2\2\6&\3\2\2\2\6(\3\2\2\2\7*\3\2\2\2\7,\3\2\2\2\b\64"+
		"\3\2\2\2\n8\3\2\2\2\f=\3\2\2\2\16A\3\2\2\2\20E\3\2\2\2\22I\3\2\2\2\24"+
		"M\3\2\2\2\26T\3\2\2\2\30X\3\2\2\2\32\\\3\2\2\2\34c\3\2\2\2\36g\3\2\2\2"+
		" l\3\2\2\2\"p\3\2\2\2$w\3\2\2\2&{\3\2\2\2(\177\3\2\2\2*\u0086\3\2\2\2"+
		",\u008c\3\2\2\2.\u0090\3\2\2\2\60\u0096\3\2\2\2\62\u0099\3\2\2\2\64\65"+
		"\7]\2\2\65\66\3\2\2\2\66\67\b\2\2\2\67\t\3\2\2\289\7}\2\29:\3\2\2\2:;"+
		"\b\3\3\2;\13\3\2\2\2<>\n\2\2\2=<\3\2\2\2>?\3\2\2\2?=\3\2\2\2?@\3\2\2\2"+
		"@\r\3\2\2\2AB\7_\2\2BC\3\2\2\2CD\b\5\4\2D\17\3\2\2\2EF\7\177\2\2FG\3\2"+
		"\2\2GH\b\6\4\2H\21\3\2\2\2IJ\7]\2\2JK\3\2\2\2KL\b\7\5\2L\23\3\2\2\2MQ"+
		"\5\62\27\2NP\5\60\26\2ON\3\2\2\2PS\3\2\2\2QO\3\2\2\2QR\3\2\2\2R\25\3\2"+
		"\2\2SQ\3\2\2\2TU\t\3\2\2UV\3\2\2\2VW\b\t\6\2W\27\3\2\2\2XY\7_\2\2YZ\3"+
		"\2\2\2Z[\b\n\4\2[\31\3\2\2\2\\`\5\62\27\2]_\5\60\26\2^]\3\2\2\2_b\3\2"+
		"\2\2`^\3\2\2\2`a\3\2\2\2a\33\3\2\2\2b`\3\2\2\2cd\7_\2\2de\3\2\2\2ef\b"+
		"\f\4\2f\35\3\2\2\2gh\7\177\2\2hi\3\2\2\2ij\b\r\4\2jk\b\r\7\2k\37\3\2\2"+
		"\2lm\7]\2\2mn\3\2\2\2no\b\16\5\2o!\3\2\2\2pt\5\62\27\2qs\5\60\26\2rq\3"+
		"\2\2\2sv\3\2\2\2tr\3\2\2\2tu\3\2\2\2u#\3\2\2\2vt\3\2\2\2wx\t\3\2\2xy\3"+
		"\2\2\2yz\b\20\6\2z%\3\2\2\2{|\7_\2\2|}\3\2\2\2}~\b\21\4\2~\'\3\2\2\2\177"+
		"\u0083\5\62\27\2\u0080\u0082\5\60\26\2\u0081\u0080\3\2\2\2\u0082\u0085"+
		"\3\2\2\2\u0083\u0081\3\2\2\2\u0083\u0084\3\2\2\2\u0084)\3\2\2\2\u0085"+
		"\u0083\3\2\2\2\u0086\u0087\7}\2\2\u0087\u0088\3\2\2\2\u0088\u0089\b\23"+
		"\4\2\u0089\u008a\b\23\b\2\u008a+\3\2\2\2\u008b\u008d\n\2\2\2\u008c\u008b"+
		"\3\2\2\2\u008d\u008e\3\2\2\2\u008e\u008c\3\2\2\2\u008e\u008f\3\2\2\2\u008f"+
		"-\3\2\2\2\u0090\u0091\t\4\2\2\u0091/\3\2\2\2\u0092\u0097\5\62\27\2\u0093"+
		"\u0097\t\5\2\2\u0094\u0097\5.\25\2\u0095\u0097\t\6\2\2\u0096\u0092\3\2"+
		"\2\2\u0096\u0093\3\2\2\2\u0096\u0094\3\2\2\2\u0096\u0095\3\2\2\2\u0097"+
		"\61\3\2\2\2\u0098\u009a\t\7\2\2\u0099\u0098\3\2\2\2\u009a\63\3\2\2\2\20"+
		"\2\3\4\5\6\7?Q`t\u0083\u008e\u0096\u0099\t\7\3\2\7\4\2\6\2\2\7\5\2\b\2"+
		"\2\7\7\2\7\6\2";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}