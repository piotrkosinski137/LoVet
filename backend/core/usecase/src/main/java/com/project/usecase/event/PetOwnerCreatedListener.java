package com.project.usecase.event;

import com.project.event.PetOwnerCreated;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

@Component
public class PetOwnerCreatedListener {

//  private final RegisterPetOwner registerPetOwner;
//
//  public PetOwnerCreatedListener(RegisterPetOwner registerPetOwner) {
//    this.registerPetOwner = registerPetOwner;
//  }

  @EventListener
  private void handlePetOwnerCreated(PetOwnerCreated petOwnerCreated) {

  }
}
