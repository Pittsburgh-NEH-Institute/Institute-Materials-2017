package data_model;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * Created by Ronald Haentjens Dekker on 29/12/16.
 *
 * A document has zero or more text nodes.
 *
 */
public class Document {
    private List<TextNode> textNodeList;

    public Document() {
        this.textNodeList = new ArrayList<>();
    }

    public void addTextNode(TextNode textNode) {
        this.textNodeList.add(textNode);
    }

    public Iterator<TextNode> getTextNodeIterator() {
        return this.textNodeList.iterator();
    }
}
