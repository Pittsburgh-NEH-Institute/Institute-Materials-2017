package lmnl_importer;

import lmnl_antlr.LMNLParser;
import lmnl_antlr.LMNLParserBaseVisitor;

/**
 * Created by ronalddekker on 29/12/16.
 */
public class LMNLImporterVisitor extends LMNLParserBaseVisitor {

    @Override
    public Object visitDocument(LMNLParser.DocumentContext ctx) {
        boolean hasRange = ctx.range() != null;
        boolean hasText = ctx.TEXT() != null;

        System.out.println("The document has a range: "+hasRange);
        System.out.println("The document has text: "+hasText );

        return super.visitDocument(ctx);
    }
}
