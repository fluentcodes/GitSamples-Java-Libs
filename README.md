# Topic Branch: JSON Jackson
Jackson is with spring the standard for serialization/deserialization with JSON and typed objects.

It's a fast and highly configurable library with other serialization formats like 
[xml](../..//tree/java-libs-xml-jackson) or
[yaml](../../tree/java-libs-yaml-jackson)


## Helper
* [MAPPER](test/sources/testitems/ItemProvider.java): A default ObjectMapper configuration

## Tests
* [AddressListTest](test/sources/AddressListTest.java): A List of Addresses
* [AddressMapTest](test/sources/AddressMapTest.java): A Map of Adresses
* [DateExampleTest](test/sources/DateExampleTest.java): Tests for Date
* [ListTest](test/sources/ListTest.java): Tests for Lists
* [LocalDateTimeExampleTest](test/sources/LocalDateTimeExampleTest.java): Tests for LocalDateTime
* [MapTest](test/sources/MapTest.java): Test for Maps
* [ReadValueTest](test/sources/ReadValueTest.java): Test with read from file

## Related Topic Branches
* [java-libs-json-gson](../../tree/java-libs-json-gson)
* [java-libs-xml-jackson](../../tree/java-libs-xml-jackson)
* [java-libs-yaml-jackson](../../tree/java-libs-yaml-jackson)

## Links
* https://stackoverflow.com/questions/27952472/serialize-deserialize-java-8-java-time-with-jackson-json-mapper
