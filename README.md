# Topic Branch Java Libs Jackson
The jackson library give some simple mapping ignoring jaxb annotations.
* BooksTest.compareBookDifferent

But there are also Jackson annotation "JSONProperty" which could be used. There is no way to map an object value to an XML attribute.

The main benefit is that xmlJackson allows the mapping of simple List and maps.

But here it fails to serialize sub maps or lists especially with list creating really false xml.

Tests to document this are on
* ListTest.xmlListWithSubList_unexpectedSize
* MapTest.toXMLMapWithSubList_throwsException

## Links
* https://www.baeldung.com/jackson-xml-serialization-and-deserialization