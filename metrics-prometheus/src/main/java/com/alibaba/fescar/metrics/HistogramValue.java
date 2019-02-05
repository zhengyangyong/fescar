package com.alibaba.fescar.metrics;

public class HistogramValue {
  private final long count;

  private final long total;

  public long getCount() {
    return count;
  }

  public long getTotal() {
    return total;
  }

  public HistogramValue() {
    this(0, 0);
  }

  public HistogramValue(long count, long total) {
    this.count = count;
    this.total = total;
  }

  public HistogramValue increment() {
    return this.increment(1);
  }

  public HistogramValue increment(long value) {
    return new HistogramValue(count + 1, total + value);
  }
}
