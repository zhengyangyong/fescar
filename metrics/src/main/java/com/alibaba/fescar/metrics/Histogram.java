package com.alibaba.fescar.metrics;

public interface Histogram extends Meter {
  default void increment() {
    increment(1);
  }

  void increment(long value);

  long count();

  long total();
}
