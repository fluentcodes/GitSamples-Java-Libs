# GitSample Topic Branch: Micronaut Empty

This branch just contains a [Start](main/samples/Start.java) and a
[StartTest](test/samples/StartTest.java) class.

In [Start.java](main/samples/Start.java) contains just a micronaut main class.

    public class Start {
      public static void main(String[] args) {
        Micronaut.run(Start.class);
      }
    }

When calling

    java -jar target/java-micronaut-empty-0.0.1.jar

the micronaut application is started and stopped.

     __  __ _                                  _   
    |  \/  (_) ___ _ __ ___  _ __   __ _ _   _| |_
    | |\/| | |/ __| '__/ _ \| '_ \ / _` | | | | __|
    | |  | | | (__| | | (_) | | | | (_| | |_| | |_
    |_|  |_|_|\___|_|  \___/|_| |_|\__,_|\__,_|\__|
    Micronaut (v3.3.4)


## Build
Build with 

     mvn clean install 

create a java-micronaut-empty-0.0.1.jar file in target. 
It's size is around 3,48 MB.
 
## Run
Run it with

    mvn exec:exec

## Dependency Tree

Running 
    mvn dependency:tree

has the following result:

    +- io.micronaut:micronaut-context:jar:3.3.4:compile
    |  +- org.slf4j:slf4j-api:jar:1.7.29:compile
    |  +- io.micronaut:micronaut-aop:jar:3.3.4:compile
    |  \- javax.validation:validation-api:jar:2.0.1.Final:compile
    +- io.micronaut:micronaut-inject:jar:3.3.4:compile
    |  +- javax.annotation:javax.annotation-api:jar:1.3.2:compile
    |  +- jakarta.inject:jakarta.inject-api:jar:2.0.1:compile
    |  +- jakarta.annotation:jakarta.annotation-api:jar:2.0.0:compile
    |  +- io.micronaut:micronaut-core:jar:3.3.4:compile
    |  \- org.yaml:snakeyaml:jar:1.30:compile
    +- io.micronaut:micronaut-inject-java:jar:3.3.4:compile

## Related GitSample Topic Branches
* [java-micronaut-empty](../../tree/java-micronaut-empty)
* [java-springboot-empty-direct](../../tree/java-springboot-empty-direct)
* [java-springboot-empty-parent](../../tree/java-springboot-empty-parent)

### Links
* https://quarkus.io/guides/lifecycle
* https://quarkus.io/guides/getting-started
* https://opensource.com/article/21/4/quarkus-tutorial: duplicate to previous?