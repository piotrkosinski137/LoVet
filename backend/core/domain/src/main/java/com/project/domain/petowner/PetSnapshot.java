package com.project.domain.petowner;

import java.time.LocalDate;
import java.util.UUID;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import org.hibernate.annotations.Type;

@Entity
@Table(name = "PET")
public class PetSnapshot {

  @Id
  @Type(type="org.hibernate.type.UUIDCharType")
  private UUID id;
  private String name;
  private String type;
  private String photoUrl;
  private LocalDate dateOfBirth;

  private PetSnapshot() {
  }

  public PetSnapshot(UUID id, String name, String type, String photoUrl, LocalDate dateOfBirth) {
    this(name, type, photoUrl, dateOfBirth);
    this.id = id;
  }

  public PetSnapshot(String name, String type, String photoUrl, LocalDate dateOfBirth) {
    this.name = name;
    this.type = type;
    this.photoUrl = photoUrl;
    this.dateOfBirth = dateOfBirth;
  }

  public UUID getId() {
    return id;
  }

  public String getName() {
    return name;
  }

  public String getType() {
    return type;
  }

  public String getPhotoUrl() {
    return photoUrl;
  }

  public LocalDate getDateOfBirth() {
    return dateOfBirth;
  }
}
