package data_model;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Ronald Haentjens Dekker on 29/12/16.
 *
 * A text node has textual content associated with it (as a UNICODE string).
 * A text node can also have multiple ranges on it...
 */
public class TextNode {
    private String content;
    private List<TextRange> textRangeList;

    public TextNode(String content) {
        this.content = content;
        this.textRangeList = new ArrayList<>();
    }

    public void addTextRange(TextRange r) {
        this.textRangeList.add(r);
    }


    public String getContent() {
        return content;
    }
}


