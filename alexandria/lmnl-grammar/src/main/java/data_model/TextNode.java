package data_model;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Ronald Haentjens Dekker on 29/12/16.
 *
 * A text node has textual content associated with it (as a UNICODE string).
 * A text node can also have multiple ranges on it... (see the Limen)
 */
public class TextNode {
    private String content;

    public TextNode(String content) {
        this.content = content;
    }

    public String getContent() {
        return content;
    }
}


