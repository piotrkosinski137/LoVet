package com.project.domain;

import org.hibernate.annotations.Type;
import java.time.LocalDateTime;
import java.util.UUID;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "VISIT")
public class VisitSnapshot {

  @Id
  @Type(type="org.hibernate.type.UUIDCharType")
  private UUID id;
  private String doctorId;
  private UUID petId;
  private LocalDateTime visitDate;
  private String description;
  private boolean isBooked;

  private VisitSnapshot() {
  }

  public VisitSnapshot(UUID id, String doctorId, UUID petId, LocalDateTime visitDate,
      String description, boolean isBooked) {
    this.id = id;
    this.doctorId = doctorId;
    this.petId = petId;
    this.visitDate = visitDate;
    this.description = description;
    this.isBooked = isBooked;
  }

  public UUID getId() {
    return id;
  }

  public String getDoctorId() {
    return doctorId;
  }

  public UUID getPetId() {
    return petId;
  }

  public LocalDateTime getVisitDate() {
    return visitDate;
  }

  public String getDescription() {
    return description;
  }

  public boolean isBooked() {
    return isBooked;
  }
}
