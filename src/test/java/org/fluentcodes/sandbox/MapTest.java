package org.fluentcodes.sandbox;

import com.fasterxml.jackson.core.JsonProcessingException;
import org.junit.Test;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.fluentcodes.sandbox.testitems.ItemProvider.MAPPER;
import static org.fluentcodes.sandbox.testitems.ItemProvider.createMapWithSubList;
import static org.fluentcodes.sandbox.testitems.ItemProvider.createMapWithSubMap;
import static org.fluentcodes.sandbox.testitems.ItemProvider.createMapSimple;
import static org.junit.Assert.assertEquals;;

/**
 */
public class MapTest {

    @Test
    public void simpleMap() throws JsonProcessingException {
        Map<String, String> map = createMapSimple();
        String json = MAPPER
                .writerWithDefaultPrettyPrinter()
                .writeValueAsString(map);
        assertEquals("{\n" +
            "  \"key1\" : \"value1\",\n" +
            "  \"key2\" : \"value2\"\n" +
            "}", json);
        HashMap<String, String> fromJSON = MAPPER.readValue(json, HashMap.class);
        assertEquals("value1", fromJSON.get("key1"));
    }

    @Test
    public void mapWithSubMap() throws JsonProcessingException {
        Map<String, Object> map = createMapWithSubMap();
        String json = MAPPER
                .writerWithDefaultPrettyPrinter()
                .writeValueAsString(map);
        assertEquals("{\n" +
            "  \"key3\" : \"value3\",\n" +
            "  \"map1\" : {\n" +
            "    \"key1\" : \"value1\",\n" +
            "    \"key2\" : \"value2\"\n" +
            "  }\n" +
            "}", json);
        HashMap<String, Object> fromJSON = MAPPER.readValue(json, HashMap.class);
        assertEquals("value1", ((Map) fromJSON.get("map1")).get("key1"));
    }

    @Test
    public void mapWithSubList() throws JsonProcessingException {
        Map<String, Object> map = createMapWithSubList();
        String json = MAPPER
                .writerWithDefaultPrettyPrinter()
                .writeValueAsString(map);
        // Unexpected serialization
        assertEquals("{\n" +
            "  \"key3\" : \"value3\",\n" +
            "  \"list\" : [ \"value1\", \"value2\" ]\n" +
            "}", json);
        HashMap<String, Object> fromJSON = MAPPER.readValue(json, HashMap.class);
        assertEquals("value1", ((List) fromJSON.get("list")).get(0));
    }
}
