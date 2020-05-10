package com.project.domain.petowner.usecase;

import com.project.domain.petowner.Pet;
import com.project.domain.petowner.PetOwnerId;

public interface SavePet {

  void save(Pet pet, PetOwnerId petOwnerId);
}
