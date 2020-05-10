package com.project.usecase.event.petowner.events;

import com.project.domain.petowner.PetId;
import com.project.domain.petowner.PetOwner;
import com.project.domain.petowner.PetOwnerId;
import com.project.domain.petowner.usecase.LoadPetOwner;
import com.project.domain.petowner.usecase.SavePetOwner;
import com.project.event.PetCreated;
import javax.transaction.Transactional;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Service;

@Service
public class PetCreatedListener {

  private final LoadPetOwner loadPetOwner;
  private final SavePetOwner savePetOwner;

  public PetCreatedListener(LoadPetOwner loadPetOwner, SavePetOwner savePetOwner) {
    this.loadPetOwner = loadPetOwner;
    this.savePetOwner = savePetOwner;
  }

  @EventListener
  @Transactional
  public void addPet(PetCreated petCreated) {
    PetOwner petOwner = loadPetOwner.findBy(PetOwnerId.create(petCreated.getPetOwnerId()));
    petOwner.addPet(PetId.create(petCreated.getPetId()));
    savePetOwner.save(petOwner);
  }
}
