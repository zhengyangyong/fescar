package com.alibaba.fescar.metrics;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map.Entry;

import io.prometheus.client.Collector;
import io.prometheus.client.Collector.MetricFamilySamples.Sample;
import io.prometheus.client.exporter.HTTPServer;

public class PrometheusPublisher extends Collector implements Collector.Describable {
  private final HTTPServer server;

  private final Registry registry;

  public PrometheusPublisher() throws IOException {
    this.server = new HTTPServer(9696, true);
    this.registry = new DefaultRegistry();
  }

  @Override
  public List<MetricFamilySamples> collect() {
    List<MetricFamilySamples> familySamples = new ArrayList<>();
    Iterable<Measurement> measurements = registry.measure();

    List<Sample> samples = new ArrayList<>();
    measurements.forEach(measurement -> samples.add(convertMeasurementToSample(measurement)));

    if (samples.size() != 0) {
      familySamples.add(new MetricFamilySamples("Fescar Metrics", Type.UNTYPED, "Fescar Metrics", samples));
    }

    return familySamples;
  }

  private Sample convertMeasurementToSample(Measurement measurement) {
    String prometheusName = measurement.getId().getName().replace(".", "_");
    List<String> labelNames = new ArrayList<>();
    List<String> labelValues = new ArrayList<>();
    for (Entry<String, String> tag : measurement.getId().getTags()) {
      labelNames.add(tag.getKey());
      labelValues.add(tag.getValue());
    }
    return new Sample(prometheusName, labelNames, labelValues, measurement.getValue(), measurement.getTimestamp());
  }

  @Override
  public List<MetricFamilySamples> describe() {
    return collect();
  }
}
