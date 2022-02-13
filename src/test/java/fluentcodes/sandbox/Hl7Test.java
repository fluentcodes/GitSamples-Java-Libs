package fluentcodes.sandbox;

import org.hl7.v3.ActClassEntry;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class Hl7Test {
    @Test
    public void testActClassEntry() {
        assertEquals(ActClassEntry.CLUSTER, ActClassEntry.fromValue("CLUSTER"));
    }
}
