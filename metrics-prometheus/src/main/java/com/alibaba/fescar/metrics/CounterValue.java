package com.alibaba.fescar.metrics;

public class CounterValue {
  private final long count;

  private final long total;

  public long getCount() {
    return count;
  }

  public long getTotal() {
    return total;
  }

  public CounterValue() {
    this(0, 0);
  }

  public CounterValue(long count, long total) {
    this.count = count;
    this.total = total;
  }

  public CounterValue increment() {
    return this.increment(1);
  }

  public CounterValue increment(long value) {
    return new CounterValue(count + 1, total + value);
  }
}
