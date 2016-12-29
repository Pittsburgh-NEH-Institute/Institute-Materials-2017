// Generated from /Users/ronalddekker/Workspace/Institute-Materials-2017/alexandria/lmnl-grammar/src/LMNLGrammar.g4 by ANTLR 4.6
import org.antlr.v4.runtime.Lexer;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.TokenStream;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.misc.*;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class LMNLGrammar extends Lexer {
	static { RuntimeMetaData.checkVersion("4.6", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		OPEN_RANGE=1, TEXT=2, CLOSE_RANGE=3, CLOSE_RANGE_ANO=4, Name=5, S=6, OPEN_ANNO=7, 
		CLOSE_RANGE_MARK=8, Annotation_Name=9, ANNO_S=10, OPEN_ANNO_IN_A=11, CLOSE_ANNO_OP=12, 
		CLOSE_ANNO_MARK=13, ANNO_TEXT=14, CLOSE_ANNO=15, Annotation_c_Name=16, 
		CLOSE_ANNO_MARKER=17, Range_c_Name=18, CLOSE_RANGE_MARKER=19;
	public static final int INSIDE_RANGE_OPENER = 1;
	public static final int INSIDE_ANNOTATION_OPENER = 2;
	public static final int INSIDE_ANNO_TEXT = 3;
	public static final int INSIDE_ANNOTATION_CLOSE = 4;
	public static final int INSIDE_RANGE_CLOSE = 5;
	public static String[] modeNames = {
		"DEFAULT_MODE", "INSIDE_RANGE_OPENER", "INSIDE_ANNOTATION_OPENER", "INSIDE_ANNO_TEXT", 
		"INSIDE_ANNOTATION_CLOSE", "INSIDE_RANGE_CLOSE"
	};

	public static final String[] ruleNames = {
		"OPEN_RANGE", "TEXT", "CLOSE_RANGE", "CLOSE_RANGE_ANO", "Name", "S", "OPEN_ANNO", 
		"CLOSE_RANGE_MARK", "Annotation_Name", "ANNO_S", "OPEN_ANNO_IN_A", "CLOSE_ANNO_OP", 
		"CLOSE_ANNO_MARK", "ANNO_TEXT", "CLOSE_ANNO", "Annotation_c_Name", "CLOSE_ANNO_MARKER", 
		"Range_c_Name", "CLOSE_RANGE_MARKER", "DIGIT", "NameChar", "NameStartChar"
	};

	private static final String[] _LITERAL_NAMES = {
	};
	private static final String[] _SYMBOLIC_NAMES = {
		null, "OPEN_RANGE", "TEXT", "CLOSE_RANGE", "CLOSE_RANGE_ANO", "Name", 
		"S", "OPEN_ANNO", "CLOSE_RANGE_MARK", "Annotation_Name", "ANNO_S", "OPEN_ANNO_IN_A", 
		"CLOSE_ANNO_OP", "CLOSE_ANNO_MARK", "ANNO_TEXT", "CLOSE_ANNO", "Annotation_c_Name", 
		"CLOSE_ANNO_MARKER", "Range_c_Name", "CLOSE_RANGE_MARKER"
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


	public LMNLGrammar(CharStream input) {
		super(input);
		_interp = new LexerATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@Override
	public String getGrammarFileName() { return "LMNLGrammar.g4"; }

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
		"\t\27\3\2\3\2\3\2\3\2\3\3\6\3:\n\3\r\3\16\3;\3\4\3\4\3\4\3\4\3\5\3\5\3"+
		"\5\3\5\3\6\3\6\7\6H\n\6\f\6\16\6K\13\6\3\7\3\7\3\7\3\7\3\b\3\b\3\b\3\b"+
		"\3\t\3\t\3\t\3\t\3\n\3\n\7\n[\n\n\f\n\16\n^\13\n\3\13\3\13\3\13\3\13\3"+
		"\f\3\f\3\f\3\f\3\r\3\r\3\r\3\r\3\r\3\16\3\16\3\16\3\16\3\17\6\17r\n\17"+
		"\r\17\16\17s\3\20\3\20\3\20\3\20\3\20\3\21\3\21\7\21}\n\21\f\21\16\21"+
		"\u0080\13\21\3\22\3\22\3\22\3\22\3\23\3\23\7\23\u0088\n\23\f\23\16\23"+
		"\u008b\13\23\3\24\3\24\3\24\3\24\3\25\3\25\3\26\3\26\3\26\3\26\5\26\u0097"+
		"\n\26\3\27\5\27\u009a\n\27\2\2\30\b\3\n\4\f\5\16\6\20\7\22\b\24\t\26\n"+
		"\30\13\32\f\34\r\36\16 \17\"\20$\21&\22(\23*\24,\25.\2\60\2\62\2\b\2\3"+
		"\4\5\6\7\b\4\2]^}}\5\2\13\f\17\17\"\"\3\2\62;\4\2/\60aa\5\2\u00b9\u00b9"+
		"\u0302\u0371\u2041\u2042\n\2<<C\\c|\u2072\u2191\u2c02\u2ff1\u3003\ud801"+
		"\uf902\ufdd1\ufdf2\uffff\u009b\2\b\3\2\2\2\2\n\3\2\2\2\2\f\3\2\2\2\3\16"+
		"\3\2\2\2\3\20\3\2\2\2\3\22\3\2\2\2\3\24\3\2\2\2\3\26\3\2\2\2\4\30\3\2"+
		"\2\2\4\32\3\2\2\2\4\34\3\2\2\2\4\36\3\2\2\2\4 \3\2\2\2\5\"\3\2\2\2\5$"+
		"\3\2\2\2\6&\3\2\2\2\6(\3\2\2\2\7*\3\2\2\2\7,\3\2\2\2\b\64\3\2\2\2\n9\3"+
		"\2\2\2\f=\3\2\2\2\16A\3\2\2\2\20E\3\2\2\2\22L\3\2\2\2\24P\3\2\2\2\26T"+
		"\3\2\2\2\30X\3\2\2\2\32_\3\2\2\2\34c\3\2\2\2\36g\3\2\2\2 l\3\2\2\2\"q"+
		"\3\2\2\2$u\3\2\2\2&z\3\2\2\2(\u0081\3\2\2\2*\u0085\3\2\2\2,\u008c\3\2"+
		"\2\2.\u0090\3\2\2\2\60\u0096\3\2\2\2\62\u0099\3\2\2\2\64\65\7]\2\2\65"+
		"\66\3\2\2\2\66\67\b\2\2\2\67\t\3\2\2\28:\n\2\2\298\3\2\2\2:;\3\2\2\2;"+
		"9\3\2\2\2;<\3\2\2\2<\13\3\2\2\2=>\7}\2\2>?\3\2\2\2?@\b\4\3\2@\r\3\2\2"+
		"\2AB\7_\2\2BC\3\2\2\2CD\b\5\4\2D\17\3\2\2\2EI\5\62\27\2FH\5\60\26\2GF"+
		"\3\2\2\2HK\3\2\2\2IG\3\2\2\2IJ\3\2\2\2J\21\3\2\2\2KI\3\2\2\2LM\t\3\2\2"+
		"MN\3\2\2\2NO\b\7\5\2O\23\3\2\2\2PQ\7]\2\2QR\3\2\2\2RS\b\b\6\2S\25\3\2"+
		"\2\2TU\7\177\2\2UV\3\2\2\2VW\b\t\4\2W\27\3\2\2\2X\\\5\62\27\2Y[\5\60\26"+
		"\2ZY\3\2\2\2[^\3\2\2\2\\Z\3\2\2\2\\]\3\2\2\2]\31\3\2\2\2^\\\3\2\2\2_`"+
		"\t\3\2\2`a\3\2\2\2ab\b\13\5\2b\33\3\2\2\2cd\7]\2\2de\3\2\2\2ef\b\f\6\2"+
		"f\35\3\2\2\2gh\7\177\2\2hi\3\2\2\2ij\b\r\4\2jk\b\r\7\2k\37\3\2\2\2lm\7"+
		"_\2\2mn\3\2\2\2no\b\16\4\2o!\3\2\2\2pr\n\2\2\2qp\3\2\2\2rs\3\2\2\2sq\3"+
		"\2\2\2st\3\2\2\2t#\3\2\2\2uv\7}\2\2vw\3\2\2\2wx\b\20\4\2xy\b\20\b\2y%"+
		"\3\2\2\2z~\5\62\27\2{}\5\60\26\2|{\3\2\2\2}\u0080\3\2\2\2~|\3\2\2\2~\177"+
		"\3\2\2\2\177\'\3\2\2\2\u0080~\3\2\2\2\u0081\u0082\7_\2\2\u0082\u0083\3"+
		"\2\2\2\u0083\u0084\b\22\4\2\u0084)\3\2\2\2\u0085\u0089\5\62\27\2\u0086"+
		"\u0088\5\60\26\2\u0087\u0086\3\2\2\2\u0088\u008b\3\2\2\2\u0089\u0087\3"+
		"\2\2\2\u0089\u008a\3\2\2\2\u008a+\3\2\2\2\u008b\u0089\3\2\2\2\u008c\u008d"+
		"\7_\2\2\u008d\u008e\3\2\2\2\u008e\u008f\b\24\4\2\u008f-\3\2\2\2\u0090"+
		"\u0091\t\4\2\2\u0091/\3\2\2\2\u0092\u0097\5\62\27\2\u0093\u0097\t\5\2"+
		"\2\u0094\u0097\5.\25\2\u0095\u0097\t\6\2\2\u0096\u0092\3\2\2\2\u0096\u0093"+
		"\3\2\2\2\u0096\u0094\3\2\2\2\u0096\u0095\3\2\2\2\u0097\61\3\2\2\2\u0098"+
		"\u009a\t\7\2\2\u0099\u0098\3\2\2\2\u009a\63\3\2\2\2\20\2\3\4\5\6\7;I\\"+
		"s~\u0089\u0096\u0099\t\7\3\2\7\7\2\6\2\2\b\2\2\7\4\2\7\5\2\7\6\2";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}