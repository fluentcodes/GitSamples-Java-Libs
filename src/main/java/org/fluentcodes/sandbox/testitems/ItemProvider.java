package org.fluentcodes.sandbox.testitems;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.datatype.jdk8.Jdk8Module;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class ItemProvider {
    private ItemProvider() {
    }

    public static ObjectMapper MAPPER = createObjectMapper();

    public static ObjectMapper createObjectMapper() {
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.setSerializationInclusion(JsonInclude.Include.NON_NULL);
        objectMapper.configure(SerializationFeature.ORDER_MAP_ENTRIES_BY_KEYS, true);
        objectMapper.registerModule(new Jdk8Module());
        objectMapper.registerModule(new JavaTimeModule());
        objectMapper.configure(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS, false);
        return objectMapper;
    }

    public static Address createAddress1() {
        return new Address()
            .setCity("city")
            .setState("state")
            .setLine("line")
            .setZip(1);
    }

    public static Address createAddress2() {
        return new Address()
            .setCity("Munich")
            .setState("Bavaria")
            .setLine("Marienplatz 1")
            .setZip(8000);
    }

    public static List<Address> createAddressList() {
        return Arrays.asList(createAddress1(), createAddress2());
    }

    public static Map<String, Address> createAddressMap() {
        Map<String, Address> addressMap = new TreeMap<>();
        addressMap.put("key1", createAddress1());
        addressMap.put("key2", createAddress2());
        return addressMap;
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
