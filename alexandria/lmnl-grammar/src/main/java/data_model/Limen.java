package data_model;

import java.util.*;

/**
 * Created by Ronald Haentjens Dekker on 25/01/17.
 *
 * A limen is a container for text nodes. A Document contains a Limen and each Annotation contains a Limen
 * And ranges.
 * For ease of use there is a convenience method here that maps TextNodes to text ranges;
 *
 */
public class Limen {

    private final List<TextNode> textNodeList;
    private final List<TextRange> textRangeList;
    private final Map<TextNode, List<TextRange>> textNodeToTextRange;

    public Limen() {
        this.textNodeList = new ArrayList<>();
        this.textRangeList = new ArrayList<>();
        this.textNodeToTextRange = new HashMap<>();
    }

    public void addTextNode(TextNode textNode) {
        this.textNodeList.add(textNode);
    }

    public void addTextRange(TextRange textRange) {
        this.textRangeList.add(textRange);
    }

    public Iterator<TextNode> getTextNodeIterator() {
        return this.textNodeList.iterator();
    }

    public void associateTextWithRange(TextNode node, TextRange textRange) {
        textNodeToTextRange.computeIfAbsent(node, f -> new ArrayList<>()).add(textRange);
    }

    public List<TextRange> getTextRanges(TextNode node) {
        return textNodeToTextRange.get(node);
    }
}
