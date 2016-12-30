package data_model;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Ronald Haentjens Dekker on 29/12/16.
 */
public class TextRange {
    private String tag;
    private List<Annotation> annotations;

    public TextRange(String tag) {
        this.tag = tag;
        this.annotations = new ArrayList<>();
    }
}
