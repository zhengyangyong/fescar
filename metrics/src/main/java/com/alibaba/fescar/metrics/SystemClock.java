package com.alibaba.fescar.metrics;

public class SystemClock implements Clock {
  public static final Clock INSTANCE = new SystemClock();

  @Override
  public long getTimestamp() {
    return System.currentTimeMillis();
  }
}
