package com.project.domain.petowner.gateway.overview;

import java.util.UUID;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class PetOverview {
  @Id
  private UUID id;
  private String petOwnerId;
  private String name;
  private String type;
  private String photoUrl;

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
