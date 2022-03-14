package sources;

import static sources.testitems.ItemProvider.MAPPER;
import static sources.testitems.ItemProvider.createListSimple;
import static sources.testitems.ItemProvider.createListWithSubList;
import static sources.testitems.ItemProvider.createListWithSubMap;
import static org.junit.Assert.assertEquals;

import com.fasterxml.jackson.core.JsonProcessingException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import org.junit.Test;

/**
 *
 */
public class ListTest {

  @Test
  public void listSimple() throws JsonProcessingException {
    List<String> list = createListSimple();
    String json = MAPPER
        .writerWithDefaultPrettyPrinter()
        .writeValueAsString(list);
    assertEquals("[ \"value1\", \"value2\" ]", json);
    List<String> fromJSON = MAPPER.readValue(json, ArrayList.class);
    assertEquals("value1", fromJSON.get(0));
  }

  @Test
  public void listWithSubMap() throws JsonProcessingException {
    List<Object> list = createListWithSubMap();
    String json = MAPPER
        .writerWithDefaultPrettyPrinter()
        .writeValueAsString(list);
    assertEquals("[ {\n" +
        "  \"key1\" : \"value1\",\n" +
        "  \"key2\" : \"value2\"\n" +
        "}, \"value3\" ]", json);
    List<Object> fromJSON = MAPPER.readValue(json, ArrayList.class);
    assertEquals("value1", ((Map) fromJSON.get(0)).get("key1"));
  }

  @Test
  public void listWithSubList() throws JsonProcessingException {
    List<Object> list = createListWithSubList();
    assertEquals(2, list.size());
    String json = MAPPER
        .writerWithDefaultPrettyPrinter()
        .writeValueAsString(list);
    // UNEXPECTED
    assertEquals("[ [ \"value1\", \"value2\" ], \"value3\" ]", json);
    List<Object> fromJSON = MAPPER.readValue(json, ArrayList.class);
    assertEquals(2, fromJSON.size());
  }
}
