package fluentcodes.sandbox;

import oasis.names.tc.ebxml_regrep.xsd.rim._3.NotifyActionType;
import org.junit.Test;

import static junit.framework.TestCase.assertEquals;

public class EbxmlTest {
    @Test
    public void testNotifyActionType() {
        NotifyActionType actionType = new NotifyActionType();
        actionType.setEndPoint("anEndpoint");
        assertEquals("anEndpoint", actionType.getEndPoint());
    }
}
