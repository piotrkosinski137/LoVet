package com.project.domain.doctor;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;
import java.util.UUID;
import javax.persistence.CollectionTable;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Table;
import org.hibernate.annotations.Type;

@Entity
@Table(name = "DOCTOR")
public class DoctorSnapshot {

  @Id
  private String id;
  private String name;
  private String surname;
  private String phoneNumber;
  @Enumerated(EnumType.STRING)
  private Speciality speciality;
  @ElementCollection
  @CollectionTable(
      name="DOCTOR_VISIT",
      joinColumns=@JoinColumn(name="DOCTOR_ID")
  )
  @Column(name="VISIT_ID")
  @Type(type="org.hibernate.type.UUIDCharType")
  private Set<UUID> visits = new HashSet<>();

  private DoctorSnapshot() {
  }

  public DoctorSnapshot(String id, String name, String surname, String phoneNumber,
      Speciality speciality,Set<UUID> visits) {
    this.id = id;
    this.name = name;
    this.surname = surname;
    this.phoneNumber = phoneNumber;
    this.visits = visits;
    this.speciality = speciality;
  }

  public String getId() {
    return id;
  }

  public String getName() {
    return name;
  }

  public String getSurname() {
    return surname;
  }

  public String getPhoneNumber() {
    return phoneNumber;
  }

  public Speciality getSpeciality() {
    return speciality;
  }

  public Set<UUID> getVisits() {
    return Collections.unmodifiableSet(visits);
  }
}
