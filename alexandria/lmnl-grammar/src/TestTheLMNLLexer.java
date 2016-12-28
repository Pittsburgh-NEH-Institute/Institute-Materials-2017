import org.antlr.v4.runtime.ANTLRInputStream;
import org.antlr.v4.runtime.CharStream;

/**
 * Created by Ronald Haentjens Dekker on 28/12/16.
 */
public class TestTheLMNLLexer {

    public void test_lexer() {

        String input = "[excerpt\n" +
                "  [source [date}1915{][title}The Housekeeper{]]\n" +
                "  [author\n" +
                "    [name}Robert Frost{]\n" +
                "    [dates}1874-1963{]] }\n" +
                "[s}[l [n}144{n]}He manages to keep the upper hand{l]\n" +
                "[l [n}145{n]}On his own farm.{s] [s}He's boss.{s] [s}But as to hens:{l]\n" +
                "[l [n}146{n]}We fence our flowers in and the hens range.{l]{s]\n" +
                "{excerpt]";
        LMNLGrammar grammar = new LMNLGrammar(new ANTLRInputStream(input));
    }

    public static void main(String args[]) {
        TestTheLMNLLexer test = new TestTheLMNLLexer();
        test.test_lexer();
    }


}
