package com.project.domain.petowner;

import java.util.UUID;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class PetSnapshot {

  @Id
  private UUID id;
  private UUID petOwnerId;


  public UUID getId() {
    return id;
  }

  public UUID getPetOwnerId() {
    return petOwnerId;
  }
}
