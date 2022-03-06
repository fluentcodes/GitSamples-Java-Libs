package org.fluentcodes.java.libs.xml.jaxb;

import com.fasterxml.jackson.core.JsonProcessingException;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import static org.fluentcodes.java.libs.xml.jaxb.BooksTest.XML_MAPPER;
import static org.fluentcodes.java.testitems.ItemProvider.createListSimple;
import static org.fluentcodes.java.testitems.ItemProvider.createListWithSubList;
import static org.fluentcodes.java.testitems.ItemProvider.createListWithSubMap;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

/**
 * This does not work. Think one should not use jaxb for such type of untyped mapping and using jackson.
 * Perhaps later an example.
 * https://stackoverflow.com/questions/3941479/jaxb-how-to-marshall-map-into-keyvalue-key
 * https://stackoverflow.com/questions/3293493/dynamic-tag-names-with-jaxb/37984656#37984656
 */
public class ListTest {

    public static final String EMPLOYEES_XML = "src/test/resources/employees.xml";

    @Test
    public void xmlListSimple() throws JsonProcessingException {
        List<String> list = createListSimple();
        String xml = XML_MAPPER
                .writerWithDefaultPrettyPrinter()
                .writeValueAsString(list);
        assertEquals("<ArrayList>\n" +
                "  <item>value1</item>\n" +
                "  <item>value2</item>\n" +
                "</ArrayList>\n", xml);
        List<String> fromXML = XML_MAPPER.readValue(xml, ArrayList.class);
        assertEquals("value1", fromXML.get(0));
    }

    @Test
    public void xmlListSimpleWithSubMap() throws JsonProcessingException {
        List<Object> list = createListWithSubMap();
        String xml = XML_MAPPER
                .writerWithDefaultPrettyPrinter()
                .writeValueAsString(list);
        assertEquals("<ArrayList>\n" +
                "  <item>\n" +
                "    <key1>value1</key1>\n" +
                "    <key2>value2</key2>\n" +
                "  </item>\n" +
                "  <item>value3</item>\n" +
                "</ArrayList>\n", xml);
        List<Object> fromXML = XML_MAPPER.readValue(xml, ArrayList.class);
        assertEquals("value1", ((Map)fromXML.get(0)).get("key1"));
    }

    @Test
    public void xmlListWithSubList_unexpectedSize() throws JsonProcessingException {
        List<Object> list = createListWithSubList();
        assertEquals(2, list.size());
        String xml = XML_MAPPER
                .writerWithDefaultPrettyPrinter()
                .writeValueAsString(list);
        // UNEXPECTED
        assertEquals("<ArrayList>\n" +
                "  <item>value1</item>\n" +
                "  <item>value2</item>\n" +
                "  <item>value3</item>\n" +
                "</ArrayList>\n", xml);
        // EXPECTED
        assertNotEquals("<ArrayList>\n" +
                "  <item>" +
                "    <ArrayList>" +
                "       <item>value1</item>\n" +
                "       <item>value2</item>\n" +
                "    </ArrayList>" +
                "  </item>" +
                "  <item>value3</item>\n" +
                "</ArrayList>\n", xml);
        List<Object> fromXML = XML_MAPPER.readValue(xml, ArrayList.class);
        assertEquals(2, fromXML.size());
    }
}
