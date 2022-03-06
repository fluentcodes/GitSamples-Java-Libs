package org.fluentcodes.java.testitems;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.ArrayList;
import java.util.List;

//This statement means that class "Bookstore.java" is the root-element of our example
@XmlRootElement(namespace = "com.vogella.xml.jaxb.gradle.model")
public class Bookstore {

    // XmLElementWrapper generates a wrapper element around XML representation
    @XmlElementWrapper(name = "bookList")
    // XmlElement sets the name of the entities
    @XmlElement(name = "book")
    private List<Book> bookList = new ArrayList<>();  // if not set problem with deserializing
    private String name;
    private String location;

    public Bookstore setBookList(List<Book> bookList) {
        this.bookList = bookList;
        return this;
    }

    public List<Book> getBooksList() {
        return bookList;
    }

    public String getName() {
        return name;
    }

    public Bookstore setName(String name) {
        this.name = name;
        return this;
    }

    public String getLocation() {
        return location;
    }

    public Bookstore setLocation(String location) {
        this.location = location;
        return this;
    }

}
