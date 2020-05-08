package com.project.domain.petowner;

import java.util.Objects;

public class PetOwnerId {

  private String value;

  private PetOwnerId(String value) {
    this.value = value;
  }

  public static PetOwnerId create(String value) {
    return new PetOwnerId(value);
  }

  public String value() {
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
