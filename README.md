# GitSample Topic Branch: Quarkus Empty

This branch just contains a [Start](main/samples/Start.java) and a
[StartTest](test/samples/StartTest.java) class.

In [Start.java](main/samples/Start.java) contains just a quarkus main class.

    @QuarkusMain
    public class Start {
      public static void main(String[] args) {
        Quarkus.run(args);
      }
    }

When calling

    java -jar target/java-quarkus-empty-0.0.1.jar

the quarkus throws exception. So some work as to be done...

    Start Quarkus
    Exception in thread "main" java.lang.NoClassDefFoundError: io/quarkus/runtime/Quarkus
    at samples.Start.main(Start.java:13)
    Caused by: java.lang.ClassNotFoundException: io.quarkus.runtime.Quarkus

## Build
Build with 

     mvn clean install 

create a java-quarkus-empty-0.0.1.jar file in target. 
It's size is around 2,79 MB.
 
## Run
Run it with

    mvn quarkus:dev

    Start Quarkus
    __  ____  __  _____   ___  __ ____  ______ 
    --/ __ \/ / / / _ | / _ \/ //_/ / / / __/
    -/ /_/ / /_/ / __ |/ , _/ ,< / /_/ /\ \   
    --\___\_\____/_/ |_/_/|_/_/|_|\____/___/   
    2022-03-19 13:46:30,567 INFO  [io.quarkus] (Quarkus Main Thread) java-quarkus-empty 0.0.1 on JVM (powered by Quarkus 2.7.5.Final) started in 0.738s. Listening on: http://localhost:8080

    2022-03-19 13:46:30,569 INFO  [io.quarkus] (Quarkus Main Thread) Profile dev activated. Live Coding activated.
    2022-03-19 13:46:30,569 INFO  [io.quarkus] (Quarkus Main Thread) Installed features: [cdi, smallrye-context-propagation, vertx]

    --
    Tests paused
    Press [r] to resume testing, [o] Toggle test output, [:] for the terminal, [h] for more options>


## Dependency Tree

Running 
    mvn dependency:tree

has to be minified for this use empty case....

## Related GitSample Topic Branches
* [java-micronaut-empty](../../tree/java-micronaut-empty)
* [java-springboot-empty-direct](../../tree/java-springboot-empty-direct)
* [java-springboot-empty-parent](../../tree/java-springboot-empty-parent)

### Links
* https://quarkus.io/guides/lifecycle
* https://quarkus.io/guides/getting-started
* https://opensource.com/article/21/4/quarkus-tutorial: duplicate to previous?
* https://quarkus.io/guides/cdi-reference
* https://marcelkliemannel.com/articles/2021/overview-of-bean-scopes-in-quarkus/
* https://www.baeldung.com/java-quarkus-testing
* https://access.redhat.com/documentation/it-it/red_hat_build_of_quarkus/1.3/html/configuring_your_quarkus_applications/proc-injecting-configuration-value-in-your-quarkus-application_quarkus-configuration-guide
* https://access.redhat.com/documentation/it-it/red_hat_build_of_quarkus/1.3/html/configuring_your_quarkus_applications/proc-accessing-configuration-from-code_quarkus-configuration-guide
* https://access.redhat.com/documentation/en-us/red_hat_build_of_quarkus/1.3/html/getting_started_with_quarkus/proc-quarkus-packaging_quarkus-getting-started
* https://mkyong.com/maven/how-to-create-a-manifest-file-with-maven/
