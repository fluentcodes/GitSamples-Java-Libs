package org.fluentcodes.sandbox.testitems;

import java.time.LocalDateTime;

public class LocalDateTimeExample {
  private LocalDateTime asIso8601;
  private LocalDateTime asLong;

  public LocalDateTime getAsIso8601() {
    return asIso8601;
  }

  public void setAsIso8601(LocalDateTime iso8601) {
    this.asIso8601 = iso8601;
  }

  public LocalDateTime getAsLong() {
    return asLong;
  }

  public void setAsLong(LocalDateTime asLong) {
    this.asLong = asLong;
  }
}
