package data_model;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * Created by Ronald Haentjens Dekker on 25/01/17.
 *
 * A limen is a container for text nodes. A Document contains a Limen and each Annotation contains a Limen
 * And ranges. NOTE: For ease of use we probably want a convenience method here that maps TextNodes to text ranges;
 *
 */
public class Limen {

    private final List<TextNode> textNodeList;
    private final List<TextRange> textRangeList;

    public Limen() {
        this.textNodeList = new ArrayList<>();
        this.textRangeList = new ArrayList<>();
    }

    public void addTextNode(TextNode textNode) {
        this.textNodeList.add(textNode);
    }

    public void addTextRange(TextRange r) {
        this.textRangeList.add(r);
    }

    public Iterator<TextNode> getTextNodeIterator() {
        return this.textNodeList.iterator();
    }

}
