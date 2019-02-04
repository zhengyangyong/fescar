package com.alibaba.fescar.metrics;

import java.util.Arrays;

public class DefaultCounter implements Counter {
  private final Id id;

  private volatile CounterValue value;

  private final Clock clock;

  public DefaultCounter(Id id) {
    this(id, SystemClock.INSTANCE);
  }

  public DefaultCounter(Id id, Clock clock) {
    this.id = id;
    this.value = new CounterValue();
    this.clock = clock;
  }

  @Override
  public Id getId() {
    return id;
  }

  @Override
  public void increment(long value) {
    this.value = this.value.increment(value);
  }

  @Override
  public long count() {
    return value.getCount();
  }

  @Override
  public long total() {
    return value.getTotal();
  }

  @Override
  public Iterable<Measurement> measure() {
    long timestamp = clock.getTimestamp();
    CounterValue value = this.value;
    this.value = new CounterValue();
    return Arrays.asList(
        new Measurement(id.addTag(IdConstants.STATISTIC_KEY, IdConstants.STATISTIC_VALUE_COUNT), timestamp,
            value.getCount()),
        new Measurement(id.addTag(IdConstants.STATISTIC_KEY, IdConstants.STATISTIC_VALUE_TOTAL), timestamp,
            value.getTotal()));
  }
}
