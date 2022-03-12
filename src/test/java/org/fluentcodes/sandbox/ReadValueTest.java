package org.fluentcodes.sandbox;

import static org.junit.Assert.assertEquals;

import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.File;
import java.io.IOException;
import org.fluentcodes.sandbox.testitems.Address;
import org.junit.Test;

/**
 *
 */
public class ReadValueTest {
  @Test
  public void testReadValue() throws IOException {
    ObjectMapper mapper = new ObjectMapper();
    Address address = mapper.readValue(new File("src/test/resources/address.json"), Address.class);
    assertEquals("{\"line\":\"line\",\"city\":\"city\",\"state\":\"state\",\"zip\":1}",
        mapper.writeValueAsString(address));
  }
}
