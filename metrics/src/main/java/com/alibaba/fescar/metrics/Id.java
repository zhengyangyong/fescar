package com.alibaba.fescar.metrics;

import java.util.Map;
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

  public Id(String name, Map<String, String> tags) {
    this.id = UUID.randomUUID();
    this.name = name;
    this.tags = new TreeMap<>();
    if (tags != null) {
      for (Entry<String, String> tag : tags.entrySet()) {
        tags.put(tag.getKey(), tag.getValue());
      }
    }
  }

  public Id addTag(String name, String value) {
    this.tags.put(name, value);
    return this;
  }
}
