# Topic Branch - Java Libs XML Jackson
The jackson library give some simple xml mapping ignoring [jaxb annotations](https://github.com/fluentcodes/sandbox/tree/java-libs-xml-jaxb).

* [BooksTest.compareBookDifferent](https://github.com/fluentcodes/sandbox/blob/java-libs-xml-jackson/src/test/java/org/fluentcodes/java/libs/xml/jackson/BooksTest.java#L104)

But there are also Jackson annotation "JSONProperty" which could be used. There is apparently no way to map an object value to an XML attribute.

The main benefit is that xmlJackson allows the mapping of simple List and maps.

But here it fails to serialize sub maps or lists especially with list creating really false xml.

Tests to document this are on
* [ListTest.xmlListWithSubList_unexpectedSize](https://github.com/fluentcodes/sandbox/blob/java-libs-xml-jackson/src/test/java/org/fluentcodes/java/libs/xml/jackson/ListTest.java#L59)
* [MapTest.toXMLMapWithSubList_throwsException](https://github.com/fluentcodes/sandbox/blob/java-libs-xml-jackson/src/test/java/org/fluentcodes/java/libs/xml/jackson/MapTest.java#L58)

## Related Topic Branches
* [java-libs-xml-jaxb](https://github.com/fluentcodes/sandbox/tree/java-libs-xml-jaxb)
* [java-libs-json-jackson](https://github.com/fluentcodes/sandbox/tree/java-libs-json-jackson)

## Links
* https://www.baeldung.com/jackson-xml-serialization-and-deserialization