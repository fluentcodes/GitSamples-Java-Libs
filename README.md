# Topic Branch: Empty pom
Just an empty branch to start a new topic branch. 

It has a special directory 
structure to avoid long tree names within the sandbox which will be defined 
with the [pom.xml](pom.xml). 

    <sourceDirectory>main</sourceDirectory>
    <resources>
        <resource>
            <directory>resources-main</directory>
        </resource>
    </resources>
    <testSourceDirectory>test</testSourceDirectory>
    <testResources>
        <testResource>
            <directory>resources-test</directory>
        </testResource>
    </testResources>

[Main.java](main/sources/Main.java) contains a main method:

    public class Main {
        public static void main(String... args) {
            Arrays.stream(args).forEach(arg->System.out.println(arg));
        }
    }

When calling

    java -jar target/java-empty-pom-0.0.1.jar a b c

will has the following output and stops afterward

    a
    b
    c


## Build
Build with

     mvn clean install 

create a java-empty-pom-0.0.1.jar file in target. 
It's size is around 2,6 KB.

The manifest information is in the [pom.xml](pom.xml):

    <plugin>
        <artifactId>maven-jar-plugin</artifactId>
        <configuration>
            <archive>
                <manifest>
                    <mainClass>sources.Main</mainClass>
                </manifest>
            </archive>
        </configuration>
    </plugin>

## Run
Run it with maven:

     mvn compile exec:java -Dexec.mainClass="sources.Main" -Dexec.args="a b c" 

## Dependency Tree

Running
  
    mvn dependency:tree
is empty.

## Related Topic Branches
* [java-springboot-empty-direct](../../tree/-empty-direct)
* [java-springboot-empty-parent](../../tree/-empty-parent)

### Links
* http://blog.blackslash.de/archives/26-Maven-JAR-ausfuehrbar-machen%3B-Hauptklasse-dem-Manifest-hinzufuegen.html
* https://www.baeldung.com/maven-java-main-method
* https://maven.apache.org/plugins/maven-resources-plugin/examples/resource-directory.html