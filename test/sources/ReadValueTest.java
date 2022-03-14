package sources;

import static org.junit.Assert.assertEquals;

import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.File;
import java.io.IOException;
import sources.testitems.Address;
import org.junit.Test;

/**
 *
 */
public class ReadValueTest {
  @Test
  public void testReadValue() throws IOException {
    ObjectMapper mapper = new ObjectMapper();
    Address address = mapper.readValue(new File("resources-test/address.json"), Address.class);
    assertEquals("{\"line\":\"line\",\"city\":\"city\",\"state\":\"state\",\"zip\":1}",
        mapper.writeValueAsString(address));
  }
}
