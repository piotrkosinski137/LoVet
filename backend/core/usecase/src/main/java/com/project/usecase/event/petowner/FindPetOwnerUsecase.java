package com.project.usecase.event.petowner;

import com.project.domain.petowner.PetOwner;
import com.project.domain.petowner.PetOwnerId;
import com.project.domain.petowner.gateway.PetOwnerGateway;
import com.project.domain.petowner.usecase.FindPetOwner;
import com.project.usecase.event.petowner.exception.PetOwnerNotFound;
import org.springframework.stereotype.Service;

@Service
public class FindPetOwnerUsecase implements FindPetOwner {

  private final PetOwnerGateway gateway;

  public FindPetOwnerUsecase(PetOwnerGateway gateway) {
    this.gateway = gateway;
  }

  @Override
  public PetOwner findBy(PetOwnerId id) {
    return gateway.findBy(id).orElseThrow(() -> new PetOwnerNotFound(id.value()));
  }
}
