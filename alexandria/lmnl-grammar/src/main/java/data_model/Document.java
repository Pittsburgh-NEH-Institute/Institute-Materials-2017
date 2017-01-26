package data_model;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * Created by Ronald Haentjens Dekker on 29/12/16.
 *
 * A document contains a Limen.
 *
 */
public class Document {
    private final Limen value;

    public Document() {
        this.value = new Limen();
    }

    public Limen value() {
        return value;
    }
}
