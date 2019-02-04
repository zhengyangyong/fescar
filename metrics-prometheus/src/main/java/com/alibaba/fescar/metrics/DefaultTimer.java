package com.alibaba.fescar.metrics;

import java.util.Arrays;
import java.util.concurrent.TimeUnit;

public class DefaultTimer implements Timer {
  private final Id id;

  private volatile TimerValue value;

  private final Clock clock;

  public DefaultTimer(Id id) {
    this(id, SystemClock.INSTANCE);
  }

  public DefaultTimer(Id id, Clock clock) {
    this.id = id;
    this.value = new TimerValue();
    this.clock = clock;
  }

  @Override
  public Id getId() {
    return id;
  }

  @Override
  public void record(long value, TimeUnit unit) {
    this.value = this.value.record(value, unit);
  }

  @Override
  public long count() {
    return this.value.getCount();
  }

  @Override
  public long total() {
    return this.value.getTotal();
  }

  @Override
  public long max() {
    return this.value.getMax();
  }

  @Override
  public Iterable<Measurement> measure() {
    long timestamp = clock.getTimestamp();
    TimerValue value = this.value;
    this.value = new TimerValue();
    return Arrays.asList(
        new Measurement(id.addTag(IdConstants.STATISTIC_KEY, IdConstants.STATISTIC_VALUE_COUNT), timestamp,
            value.getCount()),
        new Measurement(id.addTag(IdConstants.STATISTIC_KEY, IdConstants.STATISTIC_VALUE_TOTAL), timestamp,
            value.getTotal()),
        new Measurement(id.addTag(IdConstants.STATISTIC_KEY, IdConstants.STATISTIC_VALUE_MAX), timestamp,
            value.getMax()));
  }
}
