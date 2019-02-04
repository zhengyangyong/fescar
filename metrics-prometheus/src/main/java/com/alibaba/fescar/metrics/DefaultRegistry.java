package com.alibaba.fescar.metrics;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;

public class DefaultRegistry implements Registry {
  private static final Map<UUID, Meter> meters;

  static {
    meters = new ConcurrentHashMap<>();
  }

  @Override
  public Counter getCounter(Id id) {
    return (Counter) DefaultRegistry.meters.computeIfAbsent(id.getId(), key -> new DefaultCounter(id));
  }

  @Override
  public Gauge getGauge(Id id) {
    return (Gauge) DefaultRegistry.meters.computeIfAbsent(id.getId(), key -> new DefaultGauge(id));
  }

  @Override
  public Timer getTimer(Id id) {
    return (Timer) DefaultRegistry.meters.computeIfAbsent(id.getId(), key -> new DefaultTimer(id));
  }

  @Override
  public Iterable<Measurement> measure() {
    List<Measurement> measurements = new ArrayList<>();
    if (meters.size() == 0) {
      return measurements;
    }
    meters.values().iterator().forEachRemaining(meter -> meter.measure().forEach(measurements::add));
    return measurements;
  }
}
