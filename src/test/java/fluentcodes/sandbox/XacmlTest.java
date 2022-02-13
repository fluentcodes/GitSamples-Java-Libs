package fluentcodes.sandbox;

import oasis.names.tc.xacml._2_0.policy.schema.os.SubjectsType;
import oasis.names.tc.xacml._2_0.policy.schema.os.TargetType;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class XacmlTest {
    @Test
    public void testTargetType() {
        TargetType type = new TargetType();
        type.setSubjects(new SubjectsType());
        assertEquals(0, type.getSubjects().getSubject().size());
    }
}
