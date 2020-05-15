package com.project.domain;

import java.time.LocalDateTime;

public class Visit {

  private VisitId id;
  private DoctorId doctorId;
  private PetId petId;
  private LocalDateTime visitDate;
  private String description;
  private boolean isBooked;

  public Visit(LocalDateTime visitDate) {
    this.id = VisitId.create();
    this.visitDate = visitDate;
  }

  public Visit(VisitId id, DoctorId doctorId, PetId petId, LocalDateTime visitDate) {
    this.id = id;
    this.doctorId = doctorId;
    this.petId = petId;
    this.visitDate = visitDate;
  }

  public Visit(VisitId id, DoctorId doctorId, PetId petId, LocalDateTime visitDate,
      String description, boolean isBooked) {
    this.id = id;
    this.doctorId = doctorId;
    this.petId = petId;
    this.visitDate = visitDate;
    this.description = description;
    this.isBooked = isBooked;
  }

  public void assignDoctor(DoctorId doctorId) {
    this.doctorId = doctorId;
  }

  public VisitId getId() {
    return id;
  }

  public DoctorId getDoctorId() {
    return doctorId;
  }

  public PetId getPetId() {
    return petId;
  }

  public LocalDateTime getVisitDate() {
    return visitDate;
  }

  public String getDescription() {
    return description;
  }

  public static Visit fromSnapshot(VisitSnapshot snapshot) {
    return new Visit(VisitId.create(snapshot.getId()), DoctorId.create(snapshot.getDoctorId()),
        PetId.create(snapshot.getPetId()), snapshot.getVisitDate(), snapshot.getDescription(),
        snapshot.isBooked());
  }

  public VisitSnapshot toSnapshot() {
    return new VisitSnapshot(id.value(), doctorId.value(), petId.value(), visitDate, description,
        isBooked);
  }

  public void book(DoctorId doctorId, PetId petId, LocalDateTime visitDate) {
    this.doctorId = doctorId;
    this.petId = petId;
    this.visitDate = visitDate;
    isBooked = true;
  }
}
