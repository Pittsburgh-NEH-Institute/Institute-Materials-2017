package data_model;

/**
 * Created by ronalddekker on 29/12/16.
 *
 * A text node has textual content associated with it (as a UNICODE string).
 * A text node can also have multiple ranges on it...
 */
public class TextNode {
    private String content;

    public TextNode(String content) {
        this.content = content;
    }

    //TODO; this can have ranges associated to it

}


