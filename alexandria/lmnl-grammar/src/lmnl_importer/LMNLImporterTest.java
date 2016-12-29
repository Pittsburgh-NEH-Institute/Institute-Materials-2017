package lmnl_importer;

import org.junit.Test;

/**
 * Created by ronalddekker on 29/12/16.
 */
public class LMNLImporterTest {

    @Test
    public void testTextRangeAnnotation() {
        String input = "[l [n}144{n]}He manages to keep the upper hand{l]";
        LMNLImporter importer = new LMNLImporter();
        importer.importLMNL(input);
    }
}
