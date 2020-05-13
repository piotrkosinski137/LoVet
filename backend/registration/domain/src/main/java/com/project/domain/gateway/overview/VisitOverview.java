package com.project.domain.gateway.overview;

import java.time.LocalDateTime;
import java.util.Objects;
import java.util.UUID;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
public class VisitOverview {

  @Id
  private UUID id;
  private UUID petId;
  private LocalDateTime visitDate;
  private boolean isBooked;
  private String doctorId;
  private String doctorName;
  private String doctorSurname;
  private String petName;

  private VisitOverview() {
  }

  public UUID getId() {
    return id;
  }

  public UUID getPetId() {
    return petId;
  }

  public LocalDateTime getVisitDate() {
    return visitDate;
  }

  public boolean isBooked() {
    return isBooked;
  }

  public String getDoctorId() {
    return doctorId;
  }

  public String getDoctorName() {
    return doctorName;
  }

  public String getDoctorSurname() {
    return doctorSurname;
  }

  public String getPetName() {
    return petName;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    VisitOverview that = (VisitOverview) o;
    return id.equals(that.id);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id);
  }
}
