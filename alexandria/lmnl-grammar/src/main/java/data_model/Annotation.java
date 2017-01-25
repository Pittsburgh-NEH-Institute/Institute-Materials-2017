package data_model;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Ronald Haentjens Dekker on 29/12/16.
 */
// Annotations can be on ranges or annotations
public class Annotation {
    private final String tag;
    private final Limen limen;

    public Annotation(String tag) {
        this.tag = tag;
        this.limen = new Limen();
    }
}
