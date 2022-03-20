package samples;

import static org.junit.jupiter.api.Assertions.assertEquals;

import io.quarkus.test.junit.QuarkusTest;
import org.eclipse.microprofile.config.ConfigProvider;
import org.eclipse.microprofile.config.inject.ConfigProperty;
import org.junit.jupiter.api.Test;

// https://quarkus.io/guides/cdi-reference
// https://marcelkliemannel.com/articles/2021/overview-of-bean-scopes-in-quarkus/
// https://www.baeldung.com/java-quarkus-testing
// https://access.redhat.com/documentation/it-it/red_hat_build_of_quarkus/1.3/html/configuring_your_quarkus_applications/proc-injecting-configuration-value-in-your-quarkus-application_quarkus-configuration-guide
//https://access.redhat.com/documentation/it-it/red_hat_build_of_quarkus/1.3/html/configuring_your_quarkus_applications/proc-accessing-configuration-from-code_quarkus-configuration-guide

@QuarkusTest
public class StartTest {

  @ConfigProperty(name = "greeting.message")
  String message;

  @Test
  public void testMessage() {
    assertEquals("hello", message);
  }

  @Test
  public void testMessageConfigProvider() {
    assertEquals("hello", ConfigProvider.getConfig().getConfigValue("greeting.message").getValue());
  }

  @Test
  public void testUberJar() {
    assertEquals("true", ConfigProvider.getConfig().getConfigValue("quarkus.package.uber-jar").getValue());
  }
}
