package data_model;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by ronalddekker on 29/12/16.
 */
// Annotations can be on ranges or annotations
public class Annotation {
    private final String tag;
    private final List<TextNode> textNodeList;

    public Annotation(String tag) {
        this.tag = tag;
        this.textNodeList = new ArrayList<>();
    }
}
