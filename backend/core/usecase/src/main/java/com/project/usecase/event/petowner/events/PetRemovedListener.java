package com.project.usecase.event.petowner.events;

import com.project.domain.petowner.PetId;
import com.project.domain.petowner.PetOwner;
import com.project.domain.petowner.PetOwnerId;
import com.project.domain.petowner.gateway.overview.LoadPetOwnerOverview;
import com.project.domain.petowner.usecase.LoadPetOwner;
import com.project.event.PetRemoved;
import javax.transaction.Transactional;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Service;

@Service
public class PetRemovedListener {

  private final LoadPetOwner loadPetOwner;

  public PetRemovedListener(LoadPetOwner loadPetOwner) {
    this.loadPetOwner = loadPetOwner;
  }

  @EventListener
  @Transactional
  public void removePet(PetRemoved event) {
    PetOwner petOwner = loadPetOwner.findBy(PetOwnerId.create(event.getPetOwnerId()));
    petOwner.removePet(PetId.create(event.getPetId()));
  }
}
