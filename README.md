# Topic Branch: Java Libs Feing

Feign is declarative HTTP client developed by Netflix.
It aims at simplifying HTTP API clients,
the developer needs only to declare and annotate an interface while the actual 
implementation is provisioned at runtime.

[Main.java](main/sources/Main.java) contains a main method:


    public static void main(String... args) {
      if (args.length == 0) {
        args = new String[]{"https://www.spiegel.de"};
      }
      System.out.println("Get " + args[0]);
      HttpClient client = Feign.builder()
        .client(new OkHttpClient())
        .logger(new Slf4jLogger(String.class))
        .logLevel(Logger.Level.FULL)
        .target(HttpClient.class, args[0]);
      String response = client.get();
      System.out.println(response);
}

When calling

    java -jar target/java-libs-feign-0.0.1.jar https://www.heise.de

will has the output the content of the heise start page.


## Build
Build with

     mvn clean install 

create a java-empty-pom-0.0.1.jar file in target. 
It's size is around 2,8 KB.

## Run
Run it with maven:

     mvn compile exec:java -Dexec.mainClass="sources.Main" -Dexec.args="https://www.spiegel.de" 

## Dependency Tree

Running
  
    mvn dependency:tree

results in 

    +- io.github.openfeign:feign-okhttp:jar:11.8:compile
    |  +- io.github.openfeign:feign-core:jar:11.8:compile
    |  \- com.squareup.okhttp3:okhttp:jar:4.9.2:compile
    |     +- com.squareup.okio:okio:jar:2.8.0:compile
    |     |  \- org.jetbrains.kotlin:kotlin-stdlib-common:jar:1.4.0:compile
    |     \- org.jetbrains.kotlin:kotlin-stdlib:jar:1.4.10:compile
    |        \- org.jetbrains:annotations:jar:13.0:compile
    +- io.github.openfeign:feign-gson:jar:11.8:compile
    |  \- com.google.code.gson:gson:jar:2.8.9:compile
    \- io.github.openfeign:feign-slf4j:jar:11.8:compile
       \- org.slf4j:slf4j-api:jar:1.7.32:compile

## Related Topic Branches
* [java-empty-pom](../../tree/java-empty-pom)

### Links
* https://www.baeldung.com/intro-to-feign
* https://github.com/OpenFeign/feign