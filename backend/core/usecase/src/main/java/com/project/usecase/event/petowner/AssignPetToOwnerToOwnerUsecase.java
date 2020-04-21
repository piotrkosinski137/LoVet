package com.project.usecase.event.petowner;

import com.project.domain.petowner.PetId;
import com.project.domain.petowner.PetOwner;
import com.project.domain.petowner.PetOwnerId;
import com.project.domain.petowner.gateway.PetOwnerGateway;
import com.project.domain.petowner.usecase.AssignPetToOwner;
import com.project.usecase.event.petowner.exception.PetOwnerNotFound;
import java.util.Optional;
import org.springframework.stereotype.Service;

@Service
public class AssignPetToOwnerToOwnerUsecase implements AssignPetToOwner {

  private final PetOwnerGateway petOwnerGateway;

  public AssignPetToOwnerToOwnerUsecase(PetOwnerGateway petOwnerGateway) {
    this.petOwnerGateway = petOwnerGateway;
  }

  @Override
  public void assign(PetId petId, PetOwnerId petOwnerId) {
    Optional<PetOwner> petOwner = petOwnerGateway.findBy(petOwnerId).map(PetOwner::fromSnapshot);
    if (petOwner.isPresent()) {
      petOwner.get().addPet(petId);
      petOwnerGateway.save(petOwner.get().toSnapshot());
    } else {
      throw new PetOwnerNotFound();
    }
  }
}
