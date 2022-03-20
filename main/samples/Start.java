package samples;

import io.quarkus.runtime.Quarkus;
import io.quarkus.runtime.annotations.QuarkusMain;
import org.eclipse.microprofile.config.ConfigProvider;

// https://quarkus.io/guides/lifecycle
// https://quarkus.io/guides/getting-started-testing

@QuarkusMain
public class Start {
    public static void main(String... args) {
        System.out.println("Start Quarkus");
        Quarkus.run(args);
        ConfigProvider.getConfig()
            .getPropertyNames()
            .forEach(x->System.out.println(x + "=" + ConfigProvider.getConfig().getConfigValue(x).getValue()));
        System.out.println("Finished Quarkus");
    }
}

