package lmnl_importer;

import data_model.Document;
import data_model.TextNode;
import data_model.TextRange;
import org.junit.Test;

import java.util.Iterator;

import static org.junit.Assert.assertTrue;

/**
 * Created by Ronald Haentjens Dekker on 29/12/16.
 */
public class LMNLImporterTest {

    @Test
    public void testTextRangeAnnotation() {
        String input = "[l [n}144{n]}He manages to keep the upper hand{l]";
        LMNLImporter importer = new LMNLImporter();
        Document actual = importer.importLMNL(input);


        // Expectations:
        // We expect a Document
        // - with one text node
        // - with one range on it
        // - with one annotation on it.
        Document expected = new Document();
        TextNode t1 = new TextNode("He manages to keep the upper hand");
        t1.addTextRange(new TextRange("l"));
        expected.addTextNode(t1);

        assertTrue(compareDocuments(expected, actual));
    }

    // I could use a matcher framework here
    private boolean compareDocuments(Document expected, Document actual) {
        Iterator<TextNode> i1 = expected.getTextNodeIterator();
        Iterator<TextNode> i2 = actual.getTextNodeIterator();
        boolean result = true;
        while (i1.hasNext() && result) {
            TextNode t1 = i1.next();
            TextNode t2 = i2.next();
            result = compareTextNodes(t1, t2);
        }
        return true;
    }

    private boolean compareTextNodes(TextNode t1, TextNode t2) {
        return t1.getContent().equals(t2.getContent());
    }
}
