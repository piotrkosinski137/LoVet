package com.project.usecase.event.petowner;

import com.project.domain.petowner.Pet;
import com.project.domain.petowner.PetOwnerId;
import com.project.domain.petowner.PetSnapshot;
import com.project.domain.petowner.gateway.PetGateway;
import com.project.domain.petowner.usecase.LoadPets;
import java.util.Collection;
import java.util.stream.Collectors;
import org.springframework.stereotype.Service;

@Service
public class LoadPetsUsecase implements LoadPets {

  private final PetGateway petGateway;

  public LoadPetsUsecase(PetGateway petGateway) {
    this.petGateway = petGateway;
  }

  @Override
  public Collection<Pet> findAllFrom(PetOwnerId petOwnerId) {
    return petGateway.findAllFrom(petOwnerId.value()).stream()
        .map(Pet::fromSnapshot)
        .collect(Collectors.toList());
  }
}
