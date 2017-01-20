package lmnl_antlr;

import org.antlr.v4.runtime.ANTLRInputStream;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.Token;
import org.junit.Test;

import java.util.List;

/**
 * Created by Ronald Haentjens Dekker on 28/12/16.
 */
public class TestTheLMNLLexer {

    @Test
    public void testLexerTextWithOneRange() {
        String input = "[l}He manages to keep the upper hand{l]";
        setupLexer(input);
    }

    @Test
    public void testLexerComplexExample() {
        String input = "[excerpt\n" +
                "  [source [date}1915{][title}The Housekeeper{]]\n" +
                "  [author\n" +
                "    [name}Robert Frost{]\n" +
                "    [dates}1874-1963{]] }\n" +
                "[s}[l [n}144{n]}He manages to keep the upper hand{l]\n" +
                "[l [n}145{n]}On his own farm.{s] [s}He's boss.{s] [s}But as to hens:{l]\n" +
                "[l [n}146{n]}We fence our flowers in and the hens range.{l]{s]\n" +
                "{excerpt]";
        setupLexer(input);
    }

    private void setupLexer(String input) {
        LMNLLexer lexer = new LMNLLexer(new ANTLRInputStream(input));

        // This gets all the tokens at once, it does not stop for errors
        // List<? extends Token> allTokens = grammar.getAllTokens();
        // System.out.println(allTokens);

        Token token;
        do {
            token = lexer.nextToken();
            if (token.getType()!=Token.EOF) {
                System.out.println(token + ": " + lexer.getRuleNames()[token.getType() - 1] + ": " + lexer.getModeNames()[lexer._mode]);
            }
        } while (token.getType() != Token.EOF);
    }
}
