package com.project.domain.petowner;

import java.util.Objects;
import java.util.UUID;

public class PetOwnerId {

  private UUID value;

  private PetOwnerId() {
    this.value = UUID.randomUUID();
  }

  private PetOwnerId(UUID id) {
    this.value = id;
  }

  public static PetOwnerId create() {
    return new PetOwnerId();
  }

  public static PetOwnerId create(UUID id) {
    return new PetOwnerId(id);
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
    PetOwnerId that = (PetOwnerId) o;
    return value.equals(that.value);
  }

  @Override
  public int hashCode() {
    return Objects.hash(value);
  }
}
