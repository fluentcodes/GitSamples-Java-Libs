package fluentcodes.sandbox;

import org.fluentcodes.ihe.gematik.fdv.model.Author;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class TesttreiberTest {
    @Test
    public void testAuthor() {
        Author author = new Author();
        author.setFamilyName("surname");
        assertEquals("surname", author.getFamilyName());
    }
}
