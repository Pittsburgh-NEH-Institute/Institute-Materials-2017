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
		OPEN_RANGE=1, CLOSE_RANGE=2, Name=3, S=4, OPEN_ANNO=5, Annotation_Name=6;
	public static final int INSIDE_RANGE = 1;
	public static final int INSIDE_ANNOTATION = 2;
	public static String[] modeNames = {
		"DEFAULT_MODE", "INSIDE_RANGE", "INSIDE_ANNOTATION"
	};

	public static final String[] ruleNames = {
		"OPEN_RANGE", "CLOSE_RANGE", "Name", "S", "OPEN_ANNO", "Annotation_Name", 
		"DIGIT", "NameChar", "NameStartChar"
	};

	private static final String[] _LITERAL_NAMES = {
		null, null, "']'"
	};
	private static final String[] _SYMBOLIC_NAMES = {
		null, "OPEN_RANGE", "CLOSE_RANGE", "Name", "S", "OPEN_ANNO", "Annotation_Name"
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
		"\3\u0430\ud6d1\u8206\uad2d\u4417\uaef1\u8d80\uaadd\2\b@\b\1\b\1\b\1\4"+
		"\2\t\2\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n"+
		"\3\2\3\2\3\2\3\2\3\3\3\3\3\3\3\3\3\4\3\4\7\4\"\n\4\f\4\16\4%\13\4\3\5"+
		"\3\5\3\5\3\5\3\6\3\6\3\6\3\6\3\7\3\7\7\7\61\n\7\f\7\16\7\64\13\7\3\b\3"+
		"\b\3\t\3\t\3\t\3\t\5\t<\n\t\3\n\5\n?\n\n\2\2\13\5\3\7\4\t\5\13\6\r\7\17"+
		"\b\21\2\23\2\25\2\5\2\3\4\7\5\2\13\f\17\17\"\"\3\2\62;\4\2/\60aa\5\2\u00b9"+
		"\u00b9\u0302\u0371\u2041\u2042\n\2<<C\\c|\u2072\u2191\u2c02\u2ff1\u3003"+
		"\ud801\uf902\ufdd1\ufdf2\uffff?\2\5\3\2\2\2\3\7\3\2\2\2\3\t\3\2\2\2\3"+
		"\13\3\2\2\2\3\r\3\2\2\2\4\17\3\2\2\2\5\27\3\2\2\2\7\33\3\2\2\2\t\37\3"+
		"\2\2\2\13&\3\2\2\2\r*\3\2\2\2\17.\3\2\2\2\21\65\3\2\2\2\23;\3\2\2\2\25"+
		">\3\2\2\2\27\30\7]\2\2\30\31\3\2\2\2\31\32\b\2\2\2\32\6\3\2\2\2\33\34"+
		"\7_\2\2\34\35\3\2\2\2\35\36\b\3\3\2\36\b\3\2\2\2\37#\5\25\n\2 \"\5\23"+
		"\t\2! \3\2\2\2\"%\3\2\2\2#!\3\2\2\2#$\3\2\2\2$\n\3\2\2\2%#\3\2\2\2&\'"+
		"\t\2\2\2\'(\3\2\2\2()\b\5\4\2)\f\3\2\2\2*+\7]\2\2+,\3\2\2\2,-\b\6\5\2"+
		"-\16\3\2\2\2.\62\5\25\n\2/\61\5\23\t\2\60/\3\2\2\2\61\64\3\2\2\2\62\60"+
		"\3\2\2\2\62\63\3\2\2\2\63\20\3\2\2\2\64\62\3\2\2\2\65\66\t\3\2\2\66\22"+
		"\3\2\2\2\67<\5\25\n\28<\t\4\2\29<\5\21\b\2:<\t\5\2\2;\67\3\2\2\2;8\3\2"+
		"\2\2;9\3\2\2\2;:\3\2\2\2<\24\3\2\2\2=?\t\6\2\2>=\3\2\2\2?\26\3\2\2\2\t"+
		"\2\3\4#\62;>\6\7\3\2\6\2\2\b\2\2\7\4\2";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}