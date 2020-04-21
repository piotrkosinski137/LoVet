package com.project.domain.petowner.usecase;

import com.project.domain.petowner.Pet;
import com.project.domain.petowner.PetOwnerId;
import java.util.Collection;

public interface LoadPets {

  Collection<Pet> findAllFrom(PetOwnerId petOwnerId);
}
