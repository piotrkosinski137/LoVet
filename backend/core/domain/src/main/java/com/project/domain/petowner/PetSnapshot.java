package com.project.domain.petowner;

import java.util.UUID;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class PetSnapshot {

  @Id
  private UUID id;
  private String petOwnerId;
  private String name;
  private String type;
  private String photoUrl;

  private PetSnapshot() {
  }

  public PetSnapshot(UUID id, String petOwnerId, String name, String type, String photoUrl) {
    this.id = id;
    this.petOwnerId = petOwnerId;
    this.name = name;
    this.type = type;
    this.photoUrl = photoUrl;
  }

  public UUID getId() {
    return id;
  }

  public String getPetOwnerId() {
    return petOwnerId;
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
}
