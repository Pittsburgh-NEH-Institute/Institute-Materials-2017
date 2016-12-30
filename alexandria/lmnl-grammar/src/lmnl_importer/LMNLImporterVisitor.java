package lmnl_importer;

import data_model.Document;
import data_model.TextNode;
import data_model.TextRange;
import lmnl_antlr.LMNLParser;
import lmnl_antlr.LMNLParserBaseVisitor;

import java.util.Stack;

/**
 * Created by ronalddekker on 29/12/16.
 */
public class LMNLImporterVisitor extends LMNLParserBaseVisitor {
    // NOTE: It will turn out that this can not be a stack..
    // because multiple ranges can overlap; however annotations can not overlap; annotations can however have
    // annotations on them.
    private Stack<Object> things;

    public LMNLImporterVisitor() {
        this.things = new Stack<>();
    }

    @Override
    public Object visitDocument(LMNLParser.DocumentContext ctx) {
        this.things.add(new Document());


        boolean hasRange = ctx.range() != null;
        boolean hasText = ctx.TEXT() != null;

        System.out.println("The document has a range: "+hasRange);
        System.out.println("The document has text: "+hasText );

        return super.visitDocument(ctx);
    }

    @Override
    public Object visitRange_opener(LMNLParser.Range_openerContext ctx) {
        System.out.println("Range opener: "+ctx.Name_Open_Range().getText());
        this.things.add(new TextRange(ctx.Name_Open_Range().getText()));
        return super.visitRange_opener(ctx);
    }

    @Override
    public Object visitRange_content(LMNLParser.Range_contentContext ctx) {
        System.out.println("Range content: "+ctx.TEXT().getText());
        // we add the content to the document
        // the document should be the first thing on the things stack/list
        Document doc =  (Document) this.things.get(0);
        //TODO: we should add the open text ranges to the text node.
        doc.addTextNode(new TextNode(ctx.TEXT().getText()));
        return super.visitRange_content(ctx);
    }

    public Document getResult() {
        Document doc =  (Document) this.things.get(0);
        return doc;
    }
}
