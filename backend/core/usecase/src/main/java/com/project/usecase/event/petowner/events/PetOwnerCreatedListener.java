package com.project.usecase.event.petowner.events;

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


  private void handlePetOwnerCreated(PetOwnerCreated petOwnerCreated) {

  }
}
