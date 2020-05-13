package com.project.domain.doctor;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;
import java.util.stream.Collectors;

public class Doctor {

  private final DoctorId id;
  private String name;
  private String surname;
  private String phoneNumber;
  private Speciality speciality;
  private Set<VisitId> visits = new HashSet<>();

  public Doctor(DoctorId id, String name, String surname, String phoneNumber,
      Speciality speciality, Set<VisitId> visits) {
    this.id = id;
    this.name = name;
    this.surname = surname;
    this.phoneNumber = phoneNumber;
    this.speciality = speciality;
    this.visits = visits;
  }

  public static Doctor fromSnapshot(DoctorSnapshot snapshot) {
    return new Doctor(DoctorId.create(snapshot.getId()), snapshot.getName(), snapshot.getSurname(),
        snapshot.getPhoneNumber(), snapshot.getSpeciality(), snapshot.getVisits().stream()
        .map(VisitId::create).collect(Collectors.toSet()));
  }

  public DoctorSnapshot toSnapshot() {
    return new DoctorSnapshot(id.value(), name, surname, phoneNumber, speciality, visits.stream()
    .map(VisitId::value).collect(Collectors.toSet()));
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Doctor doctor = (Doctor) o;
    return id.equals(doctor.id);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id);
  }
}
