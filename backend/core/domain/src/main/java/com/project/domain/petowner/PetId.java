package com.project.domain.petowner;

import java.util.Objects;
import java.util.UUID;

public class PetId {

  private UUID value;

  private PetId() {
    this.value = UUID.randomUUID();
  }

  private PetId(UUID id) {
    this.value = id;
  }

  public static PetId create() {
    return new PetId();
  }

  public static PetId create(UUID id) {
    return new PetId(id);
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
    PetId that = (PetId) o;
    return value.equals(that.value);
  }

  @Override
  public int hashCode() {
    return Objects.hash(value);
  }
}
