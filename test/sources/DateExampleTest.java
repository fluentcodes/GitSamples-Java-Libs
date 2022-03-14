package sources;

import static org.junit.Assert.assertEquals;

import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.File;
import java.io.IOException;
import sources.testitems.DateExample;
import org.junit.Test;

public class DateExampleTest {
  @Test
  public void testReadValue() throws IOException {
    ObjectMapper mapper = new ObjectMapper();
    DateExample address = mapper.readValue(new File("resources-test/time.json"), DateExample.class);
    assertEquals("{" +
        "\"asIso8601\":1335205543511," +
        "\"asLong\":1335205543511" +
        "}", mapper.writeValueAsString(address));
  }

}
