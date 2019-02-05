package com.alibaba.fescar.metrics;

import java.util.Map.Entry;
import java.util.SortedMap;
import java.util.TreeMap;
import java.util.UUID;

public class Id {
  private final UUID id;

  private final String name;

  private final SortedMap<String, String> tags;

  public UUID getId() {
    return id;
  }

  public String getName() {
    return name;
  }

  public Iterable<Entry<String, String>> getTags() {
    return tags.entrySet();
  }

  public int getTagCount() {
    return tags.size();
  }

  public Id(String name) {
    this.id = UUID.randomUUID();
    this.name = name;
    this.tags = new TreeMap<>();
  }

  public Id addTag(String name, String value) {
    this.tags.put(name, value);
    return this;
  }

  public Id addTag(Iterable<Entry<String, String>> tags) {
    if (tags != null) {
      for (Entry<String, String> tag : tags) {
        this.tags.put(tag.getKey(), tag.getValue());
      }
    }
    return this;
  }
}
