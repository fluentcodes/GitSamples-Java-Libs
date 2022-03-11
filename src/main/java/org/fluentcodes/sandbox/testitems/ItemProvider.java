package org.fluentcodes.sandbox.testitems;

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
        return new Bookstore()
                .setBookList(createBookList())
                .setName("Fraport Bookstore")
                .setLocation("Frankfurt Airport");
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

    public static Map<String, String> createMapSimple() {
        HashMap<String, String> map = new HashMap<>();
        map.put("key1", "value1");
        map.put("key2", "value2");
        return map;
    }

    public static List<String> createListSimple() {
        List< String> list = new ArrayList<>();
        list.add("value1");
        list.add("value2");
        return list;
    }

    public static List<Object> createListWithSubMap() {
        List<Object> list = new ArrayList<>();
        list.add(createMapSimple());
        list.add("value3");
        return list;
    }

    public static List<Object> createListWithSubList() {
        List<Object> list = new ArrayList<>();
        list.add(createListSimple());
        list.add("value3");
        return list;
    }

    public static Map<String, Object> createMapWithSubMap() {
        HashMap<String, Object> map = new HashMap<>();
        map.put("key3", "value3");
        map.put("map1", createMapSimple());
        return map;
    }

    public static Map<String, Object> createMapWithSubList() {
        HashMap<String, Object> map = new HashMap<>();
        map.put("key3", "value3");
        map.put("list", createListSimple());
        return map;
    }
}
