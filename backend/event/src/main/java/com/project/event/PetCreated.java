package com.project.event;

import java.util.UUID;
import org.springframework.context.ApplicationEvent;

public class PetCreated extends ApplicationEvent {

  private final UUID petId;
  private final UUID petOwnerId;

  public PetCreated(Object source, UUID petId, UUID petOwnerId) {
    super(source);
    this.petId = petId;
    this.petOwnerId = petOwnerId;
  }

  public UUID getPetId() {
    return petId;
  }

  public UUID getPetOwnerId() {
    return petOwnerId;
  }
}
