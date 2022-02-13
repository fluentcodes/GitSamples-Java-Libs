package fluentcodes.sandbox;

import ihe.iti.xds_b._2007.ProvideAndRegisterDocumentSetRequestType;
import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.assertEquals;

public class IheTest {
    @Test
    public void testProvideAndRegisterDocumentSetRequestType() {
        ProvideAndRegisterDocumentSetRequestType request = new ProvideAndRegisterDocumentSetRequestType();
        assertEquals(new ArrayList<>(), request.getDocument());
    }
}
