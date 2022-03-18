package sources;

import feign.Feign;
import feign.Logger;
import feign.okhttp.OkHttpClient;
import feign.slf4j.Slf4jLogger;

public class Main {
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
    System.exit(0);
  }

}
