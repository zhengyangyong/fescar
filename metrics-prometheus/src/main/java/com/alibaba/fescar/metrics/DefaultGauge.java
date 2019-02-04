package com.alibaba.fescar.metrics;

import java.util.Collections;

public class DefaultGauge implements Gauge {
  private final Id id;

  private volatile double value;

  private final Clock clock;

  public DefaultGauge(Id id) {
    this(id, SystemClock.INSTANCE);
  }

  public DefaultGauge(Id id, Clock clock) {
    this.id = id;
    this.value = 0;
    this.clock = clock;
  }

  @Override
  public Id getId() {
    return id;
  }

  @Override
  public void set(double value) {
    this.value = value;
  }

  @Override
  public Iterable<Measurement> measure() {
    return Collections.singletonList(new Measurement(id, clock.getTimestamp(), value));
  }
}
