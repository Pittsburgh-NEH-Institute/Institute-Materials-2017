package data_model;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * Created by Ronald Haentjens Dekker on 25/01/17.
 *
 * A limen is a container for text nodes. A Document contains a Limen and each Annotation contains a Limen
 *
 */
public class Limen {

    private final List<TextNode> textNodeList;

    public Limen() {
        this.textNodeList = new ArrayList<>();
    }

    public void addTextNode(TextNode textNode) {
        this.textNodeList.add(textNode);
    }

    public Iterator<TextNode> getTextNodeIterator() {
        return this.textNodeList.iterator();
    }

}
