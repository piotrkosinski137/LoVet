package com.project.usecase.event.petowner.events;

import com.project.domain.petowner.PetOwner;
import com.project.domain.petowner.PetOwnerId;
import com.project.domain.petowner.usecase.RegisterPetOwner;
import com.project.event.PetOwnerCreated;
import javax.transaction.Transactional;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

@Component
public class PetOwnerCreatedListener {

  private final RegisterPetOwner registerPetOwner;

  public PetOwnerCreatedListener(RegisterPetOwner registerPetOwner) {
    this.registerPetOwner = registerPetOwner;
  }

  @EventListener
  @Transactional
  public void handlePetOwnerCreated(PetOwnerCreated event) {
      registerPetOwner.register(new PetOwner(PetOwnerId.create(event.getId()),event.getName(),
          event.getSurname(), event.getPhoneNumber()));
  }
}
