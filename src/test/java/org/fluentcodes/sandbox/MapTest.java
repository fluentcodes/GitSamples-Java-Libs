package org.fluentcodes.sandbox;

import com.fasterxml.jackson.core.JsonProcessingException;
import org.junit.Test;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.fluentcodes.sandbox.BooksTest.XML_MAPPER;
import static org.fluentcodes.sandbox.testitems.ItemProvider.createMapWithSubList;
import static org.fluentcodes.sandbox.testitems.ItemProvider.createMapWithSubMap;
import static org.fluentcodes.sandbox.testitems.ItemProvider.createMapSimple;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

/**
 * This does not work. Think one should not use jaxb for such type of untyped mapping and using jackson.
 * Perhaps later an example.
 * https://stackoverflow.com/questions/3941479/jaxb-how-to-marshall-map-into-keyvalue-key
 * https://stackoverflow.com/questions/3293493/dynamic-tag-names-with-jaxb/37984656#37984656
 */
public class MapTest {

    public static final String EMPLOYEES_XML = "src/test/resources/employees.xml";

    @Test
    public void toXMLSimple() throws JsonProcessingException {
        Map<String, String> map = createMapSimple();
        String xml = XML_MAPPER
                .writerWithDefaultPrettyPrinter()
                .writeValueAsString(map);
        assertEquals("<HashMap>\n" +
                "  <key1>value1</key1>\n" +
                "  <key2>value2</key2>\n" +
                "</HashMap>\n", xml);
        HashMap<String, String> fromXML = XML_MAPPER.readValue(xml, HashMap.class);
        assertEquals("value1", fromXML.get("key1"));
    }

    @Test
    public void toXMLMapWithSubMap() throws JsonProcessingException {
        Map<String, Object> map = createMapWithSubMap();
        String xml = XML_MAPPER
                .writerWithDefaultPrettyPrinter()
                .writeValueAsString(map);
        assertEquals("<HashMap>\n" +
                "  <key3>value3</key3>\n" +
                "  <map1>\n" +
                "    <key1>value1</key1>\n" +
                "    <key2>value2</key2>\n" +
                "  </map1>\n" +
                "</HashMap>\n", xml);
        HashMap<String, Object> fromXML = XML_MAPPER.readValue(xml, HashMap.class);
        assertEquals("value1", ((Map) fromXML.get("map1")).get("key1"));
    }

    @Test(expected = ClassCastException.class)
    public void toXMLMapWithSubList_throwsException() throws JsonProcessingException {
        Map<String, Object> map = createMapWithSubList();
        String xml = XML_MAPPER
                .writerWithDefaultPrettyPrinter()
                .writeValueAsString(map);
        // Unexpected serialization
        assertEquals("<HashMap>\n" +
                "  <key3>value3</key3>\n" +
                "  <list>value1</list>\n" +
                "  <list>value2</list>\n" +
                "</HashMap>\n", xml);
        // Unexpected serialization
        assertNotEquals("<HashMap>\n" +
                "  <key3>value3</key3>\n" +
                "  <list>" +
                "      <ArrayList>" +
                "         <item>value1</item>\n" +
                "         <item>value2</item>" +
                "      </ArrayList>" +
                "  </list>\n" +
                "</HashMap>\n", xml);
        HashMap<String, Object> fromXML = XML_MAPPER.readValue(xml, HashMap.class);
        assertEquals("value1", ((List) fromXML.get("list")).get(0));
    }
}
