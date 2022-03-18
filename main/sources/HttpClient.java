package sources;

import feign.RequestLine;

public interface HttpClient {
  @RequestLine("GET /")
  String get();
}
