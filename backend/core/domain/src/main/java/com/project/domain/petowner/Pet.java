package com.project.domain.petowner;

import java.time.LocalDate;
import java.util.Objects;
import java.util.UUID;

public class Pet {

  private PetId id;
  private String name;
  private LocalDate dateOfBirth;
  private PetType type;
  private String photoUrl;

  public Pet(String name, PetType type, String photoUrl, LocalDate dateOfBirth) {
    this.id = PetId.create();
    this.name = name;
    this.type = type;
    this.photoUrl = photoUrl;
    this.dateOfBirth = dateOfBirth;
  }

  public Pet(PetId id, String name, PetType type, String photoUrl, LocalDate dateOfBirth) {
    this.id = id;
    this.name = name;
    this.type = type;
    this.photoUrl = photoUrl;
    this.dateOfBirth = dateOfBirth;
  }

  public static Pet fromSnapshot(PetSnapshot snapshot) {
    return new Pet(PetId.create(snapshot.getId()),
        snapshot.getName(), PetType.valueOf(snapshot.getType()), snapshot.getPhotoUrl(),
        snapshot.getDateOfBirth());
  }

  public PetSnapshot toSnapshot() {
    if (id == null) {
      return new PetSnapshot(UUID.randomUUID(), name, type.name(), photoUrl, dateOfBirth);
    } else {
      return new PetSnapshot(id.value(), name, type.name(), photoUrl, dateOfBirth);
    }
  }

  public PetId getId() {
    return id;
  }

  public String getName() {
    return name;
  }

  public PetType getType() {
    return type;
  }

  public String getPhotoUrl() {
    return photoUrl;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Pet pet = (Pet) o;
    return id.equals(pet.id);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id);
  }
}
