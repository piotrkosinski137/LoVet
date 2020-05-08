package com.project.domain.petowner;

public class Pet {

  private PetId id;
  private PetOwnerId petOwnerId;
  private String name;
  private PetType type;
  private String photoUrl;

  public Pet(String name, PetOwnerId petOwnerId, PetType type, String photoUrl) {
    this.id = PetId.create();
    this.name = name;
    this.petOwnerId = petOwnerId;
    this.type = type;
    this.photoUrl = photoUrl;
  }

  public Pet(PetId id, PetOwnerId petOwnerId, String name, PetType type, String photoUrl) {
    this.id = id;
    this.name = name;
    this.petOwnerId = petOwnerId;
    this.type = type;
    this.photoUrl = photoUrl;
  }

  public static Pet fromSnapshot(PetSnapshot snapshot) {
    return new Pet(PetId.create(snapshot.getId()), PetOwnerId.create(snapshot.getPetOwnerId()),
        snapshot.getName(), PetType.valueOf(snapshot.getType()), snapshot.getPhotoUrl());
  }

  public PetSnapshot toSnapshot() {
    return new PetSnapshot(id.value(),petOwnerId.value(), name, type.name(), photoUrl);
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

  public String getPhotoUrl() {
    return photoUrl;
  }
}
