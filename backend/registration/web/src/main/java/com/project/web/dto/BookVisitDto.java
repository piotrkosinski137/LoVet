package com.project.web.dto;

import java.time.LocalDateTime;
import java.util.UUID;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

public class BookVisitDto {

  @NotNull
  @NotEmpty
  private UUID visitId;
  @NotNull
  @NotEmpty
  private String doctorId;
  @NotNull
  @NotEmpty
  private UUID petId;
  @NotNull
  @NotEmpty
  private LocalDateTime visitDate;

  public UUID getVisitId() {
    return visitId;
  }

  public void setVisitId(UUID visitId) {
    this.visitId = visitId;
  }

  public String getDoctorId() {
    return doctorId;
  }

  public void setDoctorId(String doctorId) {
    this.doctorId = doctorId;
  }

  public UUID getPetId() {
    return petId;
  }

  public void setPetId(UUID petId) {
    this.petId = petId;
  }

  public LocalDateTime getVisitDate() {
    return visitDate;
  }

  public void setVisitDate(LocalDateTime visitDate) {
    this.visitDate = visitDate;
  }
}
