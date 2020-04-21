package com.project.domain.petowner;

public class Pet {

  private PetId id;
  private PetOwnerId petOwnerId;
  private String name;
  private PetType type;

  public static Pet fromSnapshot(PetSnapshot petSnapshot) {
    return null;
  }

  public PetSnapshot toSnapshot() {
    return null;
  }

  public PetId getId() {
    return id;
  }

  public PetOwnerId getPetOwnerId() {
    return petOwnerId;
  }

  public String getName() {
    return name;
  }

  public PetType getType() {
    return type;
  }
}
