package org.fluentcodes.java.libs.xml.jaxb.tomap;

import org.junit.Test;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import java.io.File;

/**
 * https://howtodoinjava.com/jaxb/jaxb-example-marshalling-and-unmarshalling-hashmap-in-java/
 */
public class EmployeeMapTest {

    public static final String EMPLOYEES_XML = "src/test/resources/employees.xml";

    @Test
    public void toXML() throws JAXBException {
        EmployeeMap map = new EmployeeMap();
        map
                .add( new Employee()
                        .setFirstName("Lokesh").setLastName("Gupta").setIncome(100.0))
                .add( new Employee()
                        .setFirstName("John").setLastName("Mclane").setIncome(200.0));

        JAXBContext jaxbContext = JAXBContext.newInstance(EmployeeMap.class);
        Marshaller jaxbMarshaller = jaxbContext.createMarshaller();

        jaxbMarshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);

        jaxbMarshaller.marshal(map, System.out);
        jaxbMarshaller.marshal(map, new File(EMPLOYEES_XML));
    }

    @Test
    public void fromXML() throws JAXBException {
        JAXBContext jaxbContext = JAXBContext.newInstance(EmployeeMap.class);
        Unmarshaller unmarshaller = jaxbContext.createUnmarshaller();
        EmployeeMap empMap = (EmployeeMap) unmarshaller.unmarshal( new File(EMPLOYEES_XML) );

        for(Integer empId : empMap.getEmployeeMap().keySet())
        {
            System.out.println(empMap.getEmployeeMap().get(empId).getFirstName() + " " + empMap.getEmployeeMap().get(empId).getLastName());
        }
    }

}
