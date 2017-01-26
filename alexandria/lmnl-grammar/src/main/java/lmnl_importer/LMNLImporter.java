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
        //TODO: build the data model using classes from the data_model package
        return null;
    }

}
