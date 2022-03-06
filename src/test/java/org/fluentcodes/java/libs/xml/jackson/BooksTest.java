package org.fluentcodes.java.libs.xml.jaxb;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import org.fluentcodes.java.testitems.Book;
import org.fluentcodes.java.testitems.Bookstore;
import org.junit.Test;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import java.io.StringWriter;
import java.util.ArrayList;
import java.util.List;

import static org.fluentcodes.java.testitems.ItemProvider.createBook1;
import static org.fluentcodes.java.testitems.ItemProvider.createBookList;
import static org.fluentcodes.java.testitems.ItemProvider.createBookstore;
import static org.junit.Assert.assertEquals;

public class BooksTest {
    static final XmlMapper XML_MAPPER = new XmlMapper();

    @Test
    public void testBookStore() throws JsonProcessingException {
        Bookstore bookstore = createBookstore();

        String xml = XML_MAPPER
                .writerWithDefaultPrettyPrinter()
                .writeValueAsString(bookstore);
        assertEquals("<Bookstore>\n" +
                "  <name>Fraport Bookstore</name>\n" +
                "  <location>Frankfurt Airport</location>\n" +
                "  <booksList>\n" +
                "    <booksList>\n" +
                "      <name>The Game</name>\n" +
                "      <author>Neil Strauss</author>\n" +
                "      <publisher>Harpercollins</publisher>\n" +
                "      <isbn>978-0060554736</isbn>\n" +
                "    </booksList>\n" +
                "    <booksList>\n" +
                "      <name>Feuchtgebiete</name>\n" +
                "      <author>Charlotte Roche</author>\n" +
                "      <publisher>Dumont Buchverlag</publisher>\n" +
                "      <isbn>978-3832180577</isbn>\n" +
                "    </booksList>\n" +
                "  </booksList>\n" +
                "</Bookstore>\n", xml);
        Bookstore bookstoreFromXML = XML_MAPPER.readValue(xml, Bookstore.class);
        assertEquals(2, bookstoreFromXML.getBooksList().size());
    }

    @Test
    public void testBookList() throws JsonProcessingException {
        List<Book> bookList = createBookList();

        String xmlList = XML_MAPPER
                .writerWithDefaultPrettyPrinter()
                .writeValueAsString(bookList);
        assertEquals("<ArrayList>\n" +
                "  <item>\n" +
                "    <name>The Game</name>\n" +
                "    <author>Neil Strauss</author>\n" +
                "    <publisher>Harpercollins</publisher>\n" +
                "    <isbn>978-0060554736</isbn>\n" +
                "  </item>\n" +
                "  <item>\n" +
                "    <name>Feuchtgebiete</name>\n" +
                "    <author>Charlotte Roche</author>\n" +
                "    <publisher>Dumont Buchverlag</publisher>\n" +
                "    <isbn>978-3832180577</isbn>\n" +
                "  </item>\n" +
                "</ArrayList>\n", xmlList);
        List<Book> booklistFromXML = XML_MAPPER.readValue(xmlList, ArrayList.class);
        assertEquals(2, booklistFromXML.size());

    }

    @Test
    public void testBook() throws JsonProcessingException {
        Book book = createBook1();
        String xml = XML_MAPPER
                .writerWithDefaultPrettyPrinter()
                .writeValueAsString(book);
        assertEquals("<Book>\n" +
                        "  <name>The Game</name>\n" +
                        "  <author>Neil Strauss</author>\n" +
                        "  <publisher>Harpercollins</publisher>\n" +
                        "  <isbn>978-0060554736</isbn>\n" +
                        "</Book>\n",
                xml
        );
        Book bookFromXML = XML_MAPPER.readValue(xml, Book.class);
        assertEquals("978-0060554736", bookFromXML.getIsbn());
    }


    /**
     * Jackson creates only a simple mapping ignoring jaxb annotations, so the resulting xml is different.
     * @throws JAXBException
     * @throws JsonProcessingException
     */
    @Test
    public void compareBookDifferent() throws JAXBException, JsonProcessingException {
        Book book = createBook1();

        JAXBContext jaxbContext = JAXBContext.newInstance(Book.class);
        Marshaller jaxbMarshaller = jaxbContext.createMarshaller();
        jaxbMarshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
        StringWriter writer = new StringWriter();
        jaxbMarshaller.marshal(book, writer);

        String xmlJackson = XML_MAPPER
                .writerWithDefaultPrettyPrinter()
                .writeValueAsString(book);
        assertEquals(writer.toString(),
                xmlJackson
        );
    }
}
