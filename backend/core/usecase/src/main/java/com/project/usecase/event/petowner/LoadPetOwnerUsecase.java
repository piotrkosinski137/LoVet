package com.project.usecase.event.petowner;

import com.project.domain.petowner.PetOwner;
import com.project.domain.petowner.PetOwnerId;
import com.project.domain.petowner.gateway.PetOwnerGateway;
import com.project.domain.petowner.usecase.LoadPetOwner;
import com.project.usecase.event.petowner.exception.PetOwnerNotFound;
import org.springframework.stereotype.Service;

@Service
public class LoadPetOwnerUsecase implements LoadPetOwner {

  private final PetOwnerGateway petOwnerGateway;

  public LoadPetOwnerUsecase(PetOwnerGateway petOwnerGateway) {
    this.petOwnerGateway = petOwnerGateway;
  }

  @Override
  public PetOwner findBy(PetOwnerId id) {
    return petOwnerGateway.findBy(id).map(PetOwner::fromSnapshot)
        .orElseThrow(() -> new PetOwnerNotFound(id.value()));
  }
}
