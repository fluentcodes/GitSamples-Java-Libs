package org.fluentcodes.java.libs.xml.jaxb.testitems;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ItemProvider {
    private ItemProvider() {
    }
    public static Book createBook1() {
        return new Book()
                .setIsbn("978-0060554736")
                .setName("The Game")
                .setAuthor("Neil Strauss")
                .setPublisher("Harpercollins");
    }

    public static Book createBook2() {
        return new Book()
                .setIsbn("978-3832180577")
                .setName("Feuchtgebiete")
                .setAuthor("Charlotte Roche")
                .setPublisher("Dumont Buchverlag");
    }

    public static List<Book> createBookList() {
        List<Book> bookList = new ArrayList<>();
        bookList.add(createBook1());
        bookList.add(createBook2());
        return bookList;
    }

    public static Bookstore createBookstore() {
        return new Bookstore().setBookList(createBookList());
    }

    public static Employee createEmployee1() {
        return new Employee()
                .setFirstName("Lokesh")
                .setLastName("Gupta")
                .setIncome(100.0);
    }
    public static Employee createEmployee2() {
        return new Employee()
                .setFirstName("John")
                .setLastName("Mclane")
                .setIncome(200.0);
    }

    public static EmployeeMap createEmployeeMap() {
        return new EmployeeMap()
                .add(createEmployee1())
                .add(createEmployee2());
    }

    public static Map<String, String> createSimpleMap() {
        HashMap<String, String> map1 = new HashMap<>();
        map1.put("key1", "value1");
        map1.put("key2", "value2");
        return map1;
    }

    public static Map<String, Object> createMapWithSubMap() {
        HashMap<String, Object> map2 = new HashMap<>();
        map2.put("key3", "value3");
        map2.put("map1", createSimpleMap());
        return map2;
    }
}
