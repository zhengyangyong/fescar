package com.alibaba.fescar.metrics;

public interface Meter {
  Id getId();
  Iterable<Measurement> measure();
}
