package sources;

import static org.junit.Assert.assertEquals;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.databind.exc.InvalidDefinitionException;
import com.fasterxml.jackson.databind.exc.MismatchedInputException;
import com.fasterxml.jackson.datatype.jdk8.Jdk8Module;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import java.io.IOException;
import sources.testitems.LocalDateTimeExample;
import org.junit.Test;

// https://stackoverflow.com/questions/27952472/serialize-deserialize-java-8-java-time-with-jackson-json-mapper
public class LocalDateTimeExampleTest {

  @Test(expected = InvalidDefinitionException.class)
  public void simple_InvalidDefinition() throws IOException {
    ObjectMapper mapper = new ObjectMapper();
    LocalDateTimeExample date = mapper.readValue("{\n" +
            "  \"asIso8601\": \"2012-04-23T18:25:43.511Z\",\n" +
            "  \"asLong\": 1335205543511\n" +
            "}",
        LocalDateTimeExample.class);
  }

  @Test(expected = InvalidDefinitionException.class)
  public void withJdk8_InvalidDefinition() throws IOException {
    ObjectMapper mapper = new ObjectMapper();
    mapper.registerModule(new Jdk8Module());
    LocalDateTimeExample date = mapper.readValue("{\n" +
        "  \"asIso8601\": \"2012-04-23T18:25:43.511Z\",\n" +
        "  \"asLong\": 1335205543511\n" +
        "}", LocalDateTimeExample.class);
  }

  @Test(expected = MismatchedInputException.class)
  public void withJdk8AndJavaTimeModule_MismatchedInput() throws IOException {
    ObjectMapper mapper = new ObjectMapper();
    mapper.registerModule(new Jdk8Module());
    mapper.registerModule(new JavaTimeModule());
    LocalDateTimeExample date = mapper.readValue("{\n" +
        "  \"asIso8601\": \"2012-04-23T18:25:43.511Z\",\n" +
        "  \"asLong\": 1335205543511\n" +
        "}", LocalDateTimeExample.class);
  }

  @Test
  public void withNoLong() throws IOException {
    ObjectMapper mapper = new ObjectMapper();
    mapper.registerModule(new Jdk8Module());
    mapper.registerModule(new JavaTimeModule());
    LocalDateTimeExample date = mapper.readValue("{\n" +
        "  \"asIso8601\": \"2012-04-23T18:25:43.511Z\",\n" +
        "  \"asLong\": \"2012-04-23T18:25:43.511Z\"\n" +
        "}", LocalDateTimeExample.class);
    assertEquals("{\"asIso8601\":[2012,4,23,18,25,43,511000000],\"asLong\":[2012,4,23,18,25,43,511000000]}",
        mapper.writeValueAsString(date));
  }

  @Test
  public void withNoLong_WriteTimeStampDeactivated() throws IOException {
    ObjectMapper mapper = new ObjectMapper();
    mapper.registerModule(new Jdk8Module());
    mapper.registerModule(new JavaTimeModule());
    mapper.configure(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS, false);
    LocalDateTimeExample date = mapper.readValue("{\n" +
        "  \"asIso8601\": \"2012-04-23T18:25:43.511Z\",\n" +
        "  \"asLong\": \"2012-04-23T18:25:43.511Z\"\n" +
        "}", LocalDateTimeExample.class);
    assertEquals("{\"asIso8601\":\"2012-04-23T18:25:43.511\",\"asLong\":\"2012-04-23T18:25:43.511\"}",
        mapper.writeValueAsString(date));
  }

}
