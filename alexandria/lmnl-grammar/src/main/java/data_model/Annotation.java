package data_model;

/**
 * Created by ronalddekker on 29/12/16.
 */
// Annotations can be on ranges or annotations
    // open question: is abc[xyz]abc also an annotation?
public class Annotation {
    private String tag;

    public Annotation(String tag) {
        this.tag = tag;
    }
}
