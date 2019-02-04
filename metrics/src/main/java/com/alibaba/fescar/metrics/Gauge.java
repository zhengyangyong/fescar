package com.alibaba.fescar.metrics;

public interface Gauge extends Meter {
  void set(double value);
}
