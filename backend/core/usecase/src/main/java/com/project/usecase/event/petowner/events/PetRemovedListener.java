package com.project.usecase.event.petowner.events;

import com.project.domain.petowner.PetId;
import com.project.domain.petowner.PetOwner;
import com.project.domain.petowner.PetOwnerId;
import com.project.domain.petowner.usecase.FindPetOwner;
import com.project.event.PetRemoved;
import javax.transaction.Transactional;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Service;

@Service
public class PetRemovedListener {

  private final FindPetOwner findPetOwner;

  public PetRemovedListener(FindPetOwner findPetOwner) {
    this.findPetOwner = findPetOwner;
  }

  @EventListener
  @Transactional
  public void removePet(PetRemoved event) {
    PetOwner petOwner = findPetOwner.findBy(PetOwnerId.create(event.getPetOwnerId()));
    petOwner.removePet(PetId.create(event.getPetId()));
  }
}
