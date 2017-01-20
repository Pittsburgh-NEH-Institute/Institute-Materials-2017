package lmnl_importer;

import data_model.Document;
import lmnl_antlr.LMNLLexer;
import org.antlr.v4.runtime.ANTLRInputStream;

/**
 * Created by Ronald Haentjens Dekker on 29/12/16.
 */
public class LMNLImporter {

    public Document importLMNL(String input) {
        LMNLLexer lexer = new LMNLLexer(new ANTLRInputStream(input));
        return null;
        //        CommonTokenStream tokens = new CommonTokenStream(lexer);
//        LMNLParser parser = new LMNLParser(tokens);
//        parser.setBuildParseTree(true);
//        // the method is called like the first rule in the parser grammar, in this case: document
//        LMNLParser.DocumentContext document = parser.document();
//        LMNLImporterVisitor v = new LMNLImporterVisitor();
//        document.accept(v);
//        Document text = v.getResult();
//        return text;
    }

}
