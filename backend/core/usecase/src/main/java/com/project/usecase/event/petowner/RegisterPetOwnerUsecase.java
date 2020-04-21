package com.project.usecase.event.petowner;

import com.project.domain.petowner.PetOwner;
import com.project.domain.petowner.gateway.PetOwnerGateway;
import com.project.domain.petowner.usecase.RegisterPetOwner;
import org.springframework.stereotype.Service;

@Service
public class RegisterPetOwnerUsecase implements RegisterPetOwner {

  private final PetOwnerGateway gateway;

  public RegisterPetOwnerUsecase(PetOwnerGateway gateway) {
    this.gateway = gateway;
  }

  @Override
  public void register(PetOwner petOwner) {
    gateway.register(petOwner.toSnapshot());
  }
}
