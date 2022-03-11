package org.fluentcodes.sandbox;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Test;

import java.io.File;
import java.io.IOException;
import java.util.Date;

import static org.junit.Assert.assertEquals;

public class DateTest {
    @Test
    public void testReadValue() throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        TestDate address = mapper.readValue(new File("src/test/resources/time.json"), TestDate.class);
        assertEquals("{" +
                "\"asIso8601\":1335205543511," +
                "\"asLong\":1335205543511" +
                "}", mapper.writeValueAsString(address));
    }

    public static class TestDate {
        private Date asIso8601;
        private Date asLong;

        public Date getAsIso8601() {
            return asIso8601;
        }

        public void setAsIso8601(Date iso8601) {
            this.asIso8601 = iso8601;
        }

        public Date getAsLong() {
            return asLong;
        }

        public void setAsLong(Date asLong) {
            this.asLong = asLong;
        }
    }
}
