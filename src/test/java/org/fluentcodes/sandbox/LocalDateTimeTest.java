package org.fluentcodes.sandbox;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.databind.exc.InvalidDefinitionException;
import com.fasterxml.jackson.databind.exc.MismatchedInputException;
import com.fasterxml.jackson.datatype.jdk8.Jdk8Module;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import org.junit.Test;

import java.io.File;
import java.io.IOException;
import java.time.LocalDateTime;

import static org.junit.Assert.assertEquals;
// https://stackoverflow.com/questions/27952472/serialize-deserialize-java-8-java-time-with-jackson-json-mapper
public class LocalDateTimeTest {
    @Test(expected = InvalidDefinitionException.class)
    public void simple_InvalidDefinition() throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        TestLocalDateTime date = mapper.readValue(new File("src/test/resources/time.json"), TestLocalDateTime.class);
    }

    @Test(expected = InvalidDefinitionException.class)
    public void withJdk8_InvalidDefinition() throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        mapper.registerModule(new Jdk8Module());
        TestLocalDateTime date = mapper.readValue(new File("src/test/resources/time.json"), TestLocalDateTime.class);
    }

    @Test(expected = MismatchedInputException.class)
    public void withJdk8AndJavaTimeModule_MismatchedInput() throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        mapper.registerModule(new Jdk8Module());
        mapper.registerModule(new JavaTimeModule());
        TestLocalDateTime date = mapper.readValue(new File("src/test/resources/time.json"), TestLocalDateTime.class);
    }

    @Test
    public void withNoLong() throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        mapper.registerModule(new Jdk8Module());
        mapper.registerModule(new JavaTimeModule());
        TestLocalDateTime date = mapper.readValue(new File("src/test/resources/timeWithoutLong.json"), TestLocalDateTime.class);
        assertEquals("{\"asIso8601\":[2012,4,23,18,25,43,511000000],\"asLong\":[2012,4,23,18,25,43,511000000]}", mapper.writeValueAsString(date));
    }

    @Test
    public void withNoLong_WriteTimeStampDeactivated() throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        mapper.registerModule(new Jdk8Module());
        mapper.registerModule(new JavaTimeModule());
        mapper.configure(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS, false);
        TestLocalDateTime date = mapper.readValue(new File("src/test/resources/timeWithoutLong.json"), TestLocalDateTime.class);
        assertEquals("{\"asIso8601\":\"2012-04-23T18:25:43.511\",\"asLong\":\"2012-04-23T18:25:43.511\"}", mapper.writeValueAsString(date));
    }

    public static class TestLocalDateTime {
        private LocalDateTime asIso8601;
        private LocalDateTime asLong;

        public LocalDateTime getAsIso8601() {
            return asIso8601;
        }

        public void setAsIso8601(LocalDateTime iso8601) {
            this.asIso8601 = iso8601;
        }

        public LocalDateTime getAsLong() {
            return asLong;
        }

        public void setAsLong(LocalDateTime asLong) {
            this.asLong = asLong;
        }
    }
}
