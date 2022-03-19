package samples;

import io.quarkus.runtime.Quarkus;
import io.quarkus.runtime.annotations.QuarkusMain;

// https://quarkus.io/guides/lifecycle
// https://quarkus.io/guides/getting-started-testing

@QuarkusMain
public class Start {
    public static void main(String... args) {
        System.out.println("Start Quarkus");
        Quarkus.run(args);
        System.out.println("Finished Quarkus");
    }
}

