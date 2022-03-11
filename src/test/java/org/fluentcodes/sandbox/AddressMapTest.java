package org.fluentcodes.sandbox;

import static org.fluentcodes.sandbox.testitems.ItemProvider.MAPPER;
import static org.fluentcodes.sandbox.testitems.ItemProvider.createAddressMap;
import static org.junit.Assert.assertEquals;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JavaType;
import java.util.Map;
import org.fluentcodes.sandbox.testitems.Address;
import org.junit.Test;

/**
 *
 * https://gitlab.com/fluentcodes/Xpect/-/blob/master/xpect-jackson/src/main/java/org/fluentcodes/tools/io/IOJackson.java
 */
public class AddressMapTest {
    @Test
    public void test() throws JsonProcessingException {
        Map<String, Address> map = createAddressMap();
        String json = MAPPER
                .writerWithDefaultPrettyPrinter()
                .writeValueAsString(map);
        assertEquals("{\n" +
            "  \"key1\" : {\n" +
            "    \"line\" : \"line\",\n" +
            "    \"city\" : \"city\",\n" +
            "    \"state\" : \"state\",\n" +
            "    \"zip\" : 1\n" +
            "  },\n" +
            "  \"key2\" : {\n" +
            "    \"line\" : \"Marienplatz 1\",\n" +
            "    \"city\" : \"Munich\",\n" +
            "    \"state\" : \"Bavaria\",\n" +
            "    \"zip\" : 8000\n" +
            "  }\n" +
            "}", json);
        JavaType itemType = MAPPER.getTypeFactory().constructMapType(Map.class, String.class, Address.class);
        Map<String, Address> fromJSON = MAPPER.readValue(json, itemType);
        assertEquals("Munich", fromJSON.get("key2").getCity());
    }
}
