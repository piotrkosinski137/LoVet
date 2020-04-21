package com.project.domain.petowner.usecase;

import com.project.domain.petowner.Pet;
import com.project.domain.petowner.PetId;
import com.project.domain.petowner.PetOwnerId;

public interface AssignPetToOwner {

  void assign(PetId petId, PetOwnerId petOwnerId);
}
