package com.project.usecase.event.petowner;

import com.project.domain.petowner.PetOwner;
import com.project.domain.petowner.gateway.PetOwnerGateway;
import com.project.domain.petowner.usecase.SavePetOwner;
import org.springframework.stereotype.Service;

@Service
public class SavePetOwnerUsecase implements SavePetOwner {

  private final PetOwnerGateway gateway;

  public SavePetOwnerUsecase(PetOwnerGateway gateway) {
    this.gateway = gateway;
  }

  @Override
  public void save(PetOwner petOwner) {
    gateway.save(petOwner.toSnapshot());
  }
}
