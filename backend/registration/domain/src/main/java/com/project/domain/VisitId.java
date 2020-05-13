package com.project.domain;

import java.util.Objects;
import java.util.UUID;

public class VisitId {

  private UUID value;

  private VisitId() {
    this.value = UUID.randomUUID();
  }

  private VisitId(UUID id) {
    this.value = id;
  }

  public static VisitId create() {
    return new VisitId();
  }

  public static VisitId create(UUID id) {
    return new VisitId(id);
  }

  public UUID value() {
    return value;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    VisitId that = (VisitId) o;
    return value.equals(that.value);
  }

  @Override
  public int hashCode() {
    return Objects.hash(value);
  }
}
