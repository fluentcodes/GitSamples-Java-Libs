# GitSamples Topic Branch: Quarkus Empty

Target of this topic branch is to provide a minimal quarkus maven environment creating a fat jar. 

It just contains a [Start](main/samples/Start.java) and a
[StartTest](test/samples/StartTest.java) class. 

In [Start.java](main/samples/Start.java) contains just a quarkus main class.

    @QuarkusMain
    public class Start {
      public static void main(String[] args) {
        Quarkus.run(args);
      }
    }

A bit tricky to tell **quarkus-maven-plugin** in the [pom](pom.xml) to create a fat jar.

Setting proposed [application.properties](resources-main/application.properties) doesn't work. But it was 
my fault setting it in the [test application.properties](resources-test/application.properties)

I've found a was to set a property in the [pom](pom.xml) which I would prefer anyway: 

     <quarkus.package.type>uber-jar</quarkus.package.type>

When calling

    java -jar target/java-quarkus-empty-0.0.1-runner.jar

It works as expected.

    Start Quarkus
    __  ____  __  _____   ___  __ ____  ______ 
    --/ __ \/ / / / _ | / _ \/ //_/ / / / __/
    -/ /_/ / /_/ / __ |/ , _/ ,< / /_/ /\ \   
    --\___\_\____/_/ |_/_/|_/_/|_|\____/___/   
    2022-03-20 07:55:16,088 INFO  [io.quarkus] (main) java-quarkus-empty 0.0.1 on JVM (powered by Quarkus 2.7.5.Final) started in 0.180s.
    2022-03-20 07:55:16,099 INFO  [io.quarkus] (main) Profile prod activated.
    2022-03-20 07:55:16,099 INFO  [io.quarkus] (main) Installed features: [cdi]


## Build
Build with 

     mvn clean install 

create a java-quarkus-empty-0.0.1.jar file in target. 
It's size is around 2,33 MB.
 
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

shows the following: 
    
    +- io.quarkus:quarkus-arc:jar:2.7.5.Final:compile
    |  +- io.quarkus.arc:arc:jar:2.7.5.Final:compile
    |  |  +- jakarta.enterprise:jakarta.enterprise.cdi-api:jar:2.0.2:compile
    |  |  |  +- jakarta.el:jakarta.el-api:jar:3.0.3:compile
    |  |  |  \- jakarta.interceptor:jakarta.interceptor-api:jar:1.2.5:compile
    |  |  +- jakarta.annotation:jakarta.annotation-api:jar:1.3.5:compile
    |  |  +- jakarta.transaction:jakarta.transaction-api:jar:1.3.3:compile
    |  |  \- org.jboss.logging:jboss-logging:jar:3.4.3.Final:compile
    |  +- io.quarkus:quarkus-core:jar:2.7.5.Final:compile
    |  |  +- jakarta.inject:jakarta.inject-api:jar:1.0:compile
    |  |  +- io.quarkus:quarkus-ide-launcher:jar:2.7.5.Final:compile
    |  |  +- io.quarkus:quarkus-development-mode-spi:jar:2.7.5.Final:compile
    |  |  +- io.smallrye.config:smallrye-config:jar:2.9.1:compile
    |  |  |  \- io.smallrye.config:smallrye-config-core:jar:2.9.1:compile
    |  |  |     +- org.eclipse.microprofile.config:microprofile-config-api:jar:2.0.1:compile
    |  |  |     +- io.smallrye.common:smallrye-common-annotation:jar:1.10.0:compile
    |  |  |     +- io.smallrye.common:smallrye-common-expression:jar:1.10.0:compile
    |  |  |     |  \- io.smallrye.common:smallrye-common-function:jar:1.10.0:compile
    |  |  |     +- io.smallrye.common:smallrye-common-constraint:jar:1.10.0:compile
    |  |  |     +- io.smallrye.common:smallrye-common-classloader:jar:1.10.0:compile
    |  |  |     \- io.smallrye.config:smallrye-config-common:jar:2.9.1:compile
    |  |  +- org.jboss.logmanager:jboss-logmanager-embedded:jar:1.0.9:compile
    |  |  +- org.jboss.logging:jboss-logging-annotations:jar:2.2.1.Final:compile
    |  |  +- org.jboss.threads:jboss-threads:jar:3.4.2.Final:compile
    |  |  +- org.slf4j:slf4j-api:jar:1.7.33:compile
    |  |  +- org.jboss.slf4j:slf4j-jboss-logmanager:jar:1.1.0.Final:compile
    |  |  +- org.graalvm.sdk:graal-sdk:jar:21.3.1:compile
    |  |  +- org.wildfly.common:wildfly-common:jar:1.5.4.Final-format-001:compile
    |  |  +- io.quarkus:quarkus-bootstrap-runner:jar:2.7.5.Final:compile
    |  |  \- io.quarkus:quarkus-fs-util:jar:0.0.9:compile
    |  \- org.eclipse.microprofile.context-propagation:microprofile-context-propagation-api:jar:1.2:compile

## Related GitSample Topic Branches
* [java-micronaut-empty](../../tree/java-micronaut-empty)
* [java-springboot-empty-direct](../../tree/java-springboot-empty-direct)
* [java-springboot-empty-parent](../../tree/java-springboot-empty-parent)

### Links
* https://quarkus.io/guides/lifecycle
* https://quarkus.io/guides/maven-tooling
* https://quarkus.io/guides/getting-started
* https://opensource.com/article/21/4/quarkus-tutorial: duplicate to previous?
* https://quarkus.io/guides/cdi-reference
* https://marcelkliemannel.com/articles/2021/overview-of-bean-scopes-in-quarkus/
* https://www.baeldung.com/java-quarkus-testing
* https://access.redhat.com/documentation/it-it/red_hat_build_of_quarkus/1.3/html/configuring_your_quarkus_applications/proc-injecting-configuration-value-in-your-quarkus-application_quarkus-configuration-guide
* https://access.redhat.com/documentation/it-it/red_hat_build_of_quarkus/1.3/html/configuring_your_quarkus_applications/proc-accessing-configuration-from-code_quarkus-configuration-guide
* https://access.redhat.com/documentation/en-us/red_hat_build_of_quarkus/1.3/html/getting_started_with_quarkus/proc-quarkus-packaging_quarkus-getting-started
* https://mkyong.com/maven/how-to-create-a-manifest-file-with-maven/
* https://stackoverflow.com/questions/63915143/java-lang-classnotfoundexception-io-quarkus-runtime-quarkus
* https://stackoverflow.com/questions/68432656/quarkus-dependencies-not-included-in-uber-jar-jvm-mode
