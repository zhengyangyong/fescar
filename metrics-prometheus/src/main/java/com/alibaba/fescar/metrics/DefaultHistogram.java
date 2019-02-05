package com.alibaba.fescar.metrics;

import java.util.Arrays;

public class DefaultHistogram implements Histogram {
  private final Id id;

  private final Id measurementCountId;

  private final Id measurementTotalId;

  private volatile HistogramValue value;

  private final Clock clock;

  public DefaultHistogram(Id id) {
    this(id, SystemClock.INSTANCE);
  }

  public DefaultHistogram(Id id, Clock clock) {
    this.id = id;
    this.measurementCountId = new Id(id.getName()).addTag(id.getTags())
        .addTag(IdConstants.STATISTIC_KEY, IdConstants.STATISTIC_VALUE_COUNT);
    this.measurementTotalId = new Id(id.getName()).addTag(id.getTags())
        .addTag(IdConstants.STATISTIC_KEY, IdConstants.STATISTIC_VALUE_TOTAL);
    this.value = new HistogramValue();
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
    HistogramValue value = this.value;
    this.value = new HistogramValue();
    return Arrays.asList(new Measurement(measurementCountId, timestamp, value.getCount()),
        new Measurement(measurementTotalId, timestamp, value.getTotal()));
  }
}
