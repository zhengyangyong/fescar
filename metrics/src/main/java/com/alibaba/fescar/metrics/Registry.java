package com.alibaba.fescar.metrics;

public interface Registry {
  Counter getCounter(Id id);

  Gauge getGauge(Id id);

  Timer getTimer(Id id);

  Histogram getHistogram(Id id);

  Iterable<Measurement> measure();
}
