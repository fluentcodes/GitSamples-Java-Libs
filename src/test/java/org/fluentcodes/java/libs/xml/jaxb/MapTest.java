package org.fluentcodes.java.libs.xml.jaxb;

import org.junit.Test;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import java.io.File;
import java.util.HashMap;
import java.util.Map;

import static org.fluentcodes.java.libs.xml.jaxb.testitems.ItemProvider.createMapWithSubMap;
import static org.fluentcodes.java.libs.xml.jaxb.testitems.ItemProvider.createSimpleMap;

/**
 * This does not work. Think one should not use jaxb for such type of untyped mapping and using jackson.
 * Perhaps later an example.
 * https://stackoverflow.com/questions/3941479/jaxb-how-to-marshall-map-into-keyvalue-key
 * https://stackoverflow.com/questions/3293493/dynamic-tag-names-with-jaxb/37984656#37984656
 */
public class MapTest {

    public static final String EMPLOYEES_XML = "src/test/resources/employees.xml";

    @Test
    public void toXMLNotWorking() throws JAXBException {
        JAXBContext jaxbContext = JAXBContext.newInstance(Map.class);
        Marshaller jaxbMarshaller = jaxbContext.createMarshaller();

        jaxbMarshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
        jaxbMarshaller.marshal(createSimpleMap(), System.out);
        jaxbMarshaller.marshal(createMapWithSubMap(), System.out);
    }
}
