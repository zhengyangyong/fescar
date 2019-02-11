package com.alibaba.fescar.metrics;

import java.util.concurrent.TimeUnit;

public class TimerValue {
  private final long count;

  private final long total;

  private final long max;

  public long getCount() {
    return count;
  }

  public long getTotal() {
    return total;
  }

  public long getMax() {
    return max;
  }

  public TimerValue() {
    this(0, 0, 0);
  }

  public TimerValue(long count, long total, long max) {
    this.count = count;
    this.total = total;
    this.max = max;
  }

  public TimerValue record(long value, TimeUnit unit) {
    long changeValue = unit == TimeUnit.MILLISECONDS ? value : TimeUnit.MILLISECONDS.convert(value, unit);
    return new TimerValue(count + 1, total + changeValue,
        changeValue > max ? changeValue : max);
  }
}
