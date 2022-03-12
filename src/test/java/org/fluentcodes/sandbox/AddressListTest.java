package org.fluentcodes.sandbox;

import static org.fluentcodes.sandbox.testitems.ItemProvider.MAPPER;
import static org.fluentcodes.sandbox.testitems.ItemProvider.createAddressList;
import static org.junit.Assert.assertEquals;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JavaType;
import java.util.List;
import org.fluentcodes.sandbox.testitems.Address;
import org.junit.Test;

/**
 * https://gitlab.com/fluentcodes/Xpect/-/blob/master/xpect-jackson/src/main/java/org/fluentcodes/tools/io/IOJackson.java
 */
public class AddressListTest {
  @Test
  public void test() throws JsonProcessingException {
    List<Address> map = createAddressList();
    String json = MAPPER
        .writerWithDefaultPrettyPrinter()
        .writeValueAsString(map);
    assertEquals("[ {\n" +
        "  \"line\" : \"line\",\n" +
        "  \"city\" : \"city\",\n" +
        "  \"state\" : \"state\",\n" +
        "  \"zip\" : 1\n" +
        "}, {\n" +
        "  \"line\" : \"Marienplatz 1\",\n" +
        "  \"city\" : \"Munich\",\n" +
        "  \"state\" : \"Bavaria\",\n" +
        "  \"zip\" : 8000\n" +
        "} ]", json);
    JavaType itemType = MAPPER.getTypeFactory().constructCollectionType(List.class, Address.class);
    List<Address> fromJSON = MAPPER.readValue(json, itemType);
    assertEquals("Munich", fromJSON.get(1).getCity());
  }
}
