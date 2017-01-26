package data_model;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Ronald Haentjens Dekker on 29/12/16.
 */
public class TextRange {
    private final Limen owner;
    private final String tag;
    private final List<Annotation> annotations;
    private final List<TextNode> textNodes;

    public TextRange(Limen owner, String tag) {
        this.owner = owner;
        this.tag = tag;
        this.annotations = new ArrayList<>();
        this.textNodes = new ArrayList<>();
    }

    public void addTextNode(TextNode node) {
        this.textNodes.add(node);
        this.owner.associateTextWithRange(node, this);
    }
}
