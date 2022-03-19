package samples;

import static org.junit.jupiter.api.Assertions.assertNotNull;

import io.micronaut.context.ApplicationContext;
import io.micronaut.test.extensions.junit5.annotation.MicronautTest;
import jakarta.inject.Inject;
import org.junit.jupiter.api.Test;

// https://micronaut-projects.github.io/micronaut-test/latest/guide/
@MicronautTest
public class StartTest {

  @Inject
  ApplicationContext context;

  @Test
  public void testStart() {
    assertNotNull(context);
  }
}
