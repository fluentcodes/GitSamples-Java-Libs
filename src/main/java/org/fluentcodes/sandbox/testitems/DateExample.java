package org.fluentcodes.sandbox.testitems;

import java.util.Date;

public class DateExample {
  private Date asIso8601;
  private Date asLong;

  public Date getAsIso8601() {
    return asIso8601;
  }

  public void setAsIso8601(Date iso8601) {
    this.asIso8601 = iso8601;
  }

  public Date getAsLong() {
    return asLong;
  }

  public void setAsLong(Date asLong) {
    this.asLong = asLong;
  }
}
