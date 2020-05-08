package com.project.event;

import java.util.UUID;
import org.springframework.context.ApplicationEvent;

public class PetCreated extends ApplicationEvent {

  private final UUID petId;
  private final String petOwnerId;

  public PetCreated(Object source, UUID petId, String petOwnerId) {
    super(source);
    this.petId = petId;
    this.petOwnerId = petOwnerId;
  }

  public UUID getPetId() {
    return petId;
  }

  public String getPetOwnerId() {
    return petOwnerId;
  }
}
