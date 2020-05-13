package com.project.domain.doctor;

import java.util.Objects;

public class DoctorId {

  private String value;

  private DoctorId(String value) {
    this.value = value;
  }

  public static DoctorId create(String value) {
    return new DoctorId(value);
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
    DoctorId that = (DoctorId) o;
    return value.equals(that.value);
  }

  @Override
  public int hashCode() {
    return Objects.hash(value);
  }
}
