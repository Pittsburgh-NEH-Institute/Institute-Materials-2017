package lmnl_importer;

import lmnl_antlr.LMNLGrammar;
import lmnl_antlr.LMNLParser;
import org.antlr.v4.runtime.ANTLRInputStream;
import org.antlr.v4.runtime.CommonTokenStream;

/**
 * Created by Ronald Haentjens Dekker on 29/12/16.
 */
public class LMNLImporter {

    public void importLMNL(String input) {
        //TODO: Rename LMNLGrammar to LMNLLexer
        LMNLGrammar lexer = new LMNLGrammar(new ANTLRInputStream(input));
        CommonTokenStream tokens = new CommonTokenStream(lexer);
        LMNLParser parser = new LMNLParser(tokens);
        parser.setBuildParseTree(true);
        // the method is called like the first rule in the parser grammar, in this case: document
        LMNLParser.DocumentContext document = parser.document();
        LMNLImporterVisitor v = new LMNLImporterVisitor();
        document.accept(v);
    }

}
