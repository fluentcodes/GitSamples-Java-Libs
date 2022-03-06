package org.fluentcodes.java.libs.xml.jaxb;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import org.fluentcodes.java.libs.xml.jaxb.testitems.Book;
import org.fluentcodes.java.libs.xml.jaxb.testitems.Bookstore;
import org.junit.Test;

import javax.xml.bind.JAXBException;
import java.io.FileNotFoundException;
import java.util.List;

import static org.fluentcodes.java.libs.xml.jaxb.testitems.ItemProvider.createBook1;
import static org.fluentcodes.java.libs.xml.jaxb.testitems.ItemProvider.createBookList;
import static org.fluentcodes.java.libs.xml.jaxb.testitems.ItemProvider.createBookstore;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

public class BooksTest {
    private static final String BOOKSTORE_XML = "src/test/resources/bookstore-jaxb.xml";
    private static final XmlMapper xmlMapper = new XmlMapper();
    @Test
    public void testBookStore() throws JAXBException, FileNotFoundException, JsonProcessingException {
        Bookstore bookstore = createBookstore();

        String xml = xmlMapper.writeValueAsString(bookstore);
        assertEquals("", xml);
    }

    @Test
    public void testBookList() throws JAXBException, FileNotFoundException, JsonProcessingException {
        List<Book> bookList = createBookList();

        String xmlList = xmlMapper.writeValueAsString(bookList);
        assertEquals("", xmlList);
    }

    @Test
    public void testBook() throws JAXBException, FileNotFoundException, JsonProcessingException {
        Book book = createBook1();
        assertEquals("<Book><name>The Game</name><author>Neil Strauss</author><publisher>Harpercollins</publisher><isbn>978-0060554736</isbn></Book>",
                xmlMapper.writeValueAsString(book));
    }
}
