package com.alibaba.fescar.metrics;

public interface Counter extends Meter {
  default void increment() {
    increment(1);
  }

  void increment(long value);

  long count();

  long total();
}
