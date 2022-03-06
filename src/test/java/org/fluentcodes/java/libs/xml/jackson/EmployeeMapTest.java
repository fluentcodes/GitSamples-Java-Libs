package org.fluentcodes.java.libs.xml.jaxb;

import com.fasterxml.jackson.core.JsonProcessingException;
import org.fluentcodes.java.testitems.EmployeeMap;
import org.junit.Test;

import static org.fluentcodes.java.libs.xml.jaxb.BooksTest.XML_MAPPER;
import static org.fluentcodes.java.testitems.ItemProvider.createEmployeeMap;
import static org.junit.Assert.assertEquals;

/**
 * https://howtodoinjava.com/jaxb/jaxb-example-marshalling-and-unmarshalling-hashmap-in-java/
 */
public class EmployeeMapTest {

    @Test
    public void toXML() throws JsonProcessingException {
        EmployeeMap map = createEmployeeMap();
        String xml = XML_MAPPER
                .writerWithDefaultPrettyPrinter()
                .writeValueAsString(map);
        assertEquals("<EmployeeMap>\n" +
                "  <employeeMap>\n" +
                "    <0>\n" +
                "      <id>0</id>\n" +
                "      <firstName>Lokesh</firstName>\n" +
                "      <lastName>Gupta</lastName>\n" +
                "      <income>100.0</income>\n" +
                "    </0>\n" +
                "    <1>\n" +
                "      <id>1</id>\n" +
                "      <firstName>John</firstName>\n" +
                "      <lastName>Mclane</lastName>\n" +
                "      <income>200.0</income>\n" +
                "    </1>\n" +
                "  </employeeMap>\n" +
                "</EmployeeMap>\n", xml);
        EmployeeMap fromXML = XML_MAPPER.readValue(xml, EmployeeMap.class);
        assertEquals("John", fromXML.getEmployeeMap().get(1).getFirstName());
    }


}
