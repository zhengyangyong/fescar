package com.alibaba.fescar.metrics;

import java.util.concurrent.TimeUnit;

public interface Timer extends Meter {
  void record(long value, TimeUnit unit);

  long count();

  long total();

  long max();
}
