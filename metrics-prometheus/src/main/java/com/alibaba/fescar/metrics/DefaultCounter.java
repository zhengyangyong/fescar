package com.alibaba.fescar.metrics;

import java.util.Collections;
import java.util.concurrent.atomic.AtomicLong;

public class DefaultCounter implements Counter {
  private final Id id;

  private final AtomicLong counter;

  private final Clock clock;

  public DefaultCounter(Id id) {
    this(id, SystemClock.INSTANCE);
  }

  public DefaultCounter(Id id, Clock clock) {
    this.id = id;
    this.counter = new AtomicLong(0);
    this.clock = clock;
  }

  @Override
  public Id getId() {
    return id;
  }

  @Override
  public void increment(long value) {
    this.counter.addAndGet(value);
  }

  @Override
  public Iterable<Measurement> measure() {
    return Collections.singletonList(new Measurement(id, clock.getTimestamp(), counter.get()));
  }
}
