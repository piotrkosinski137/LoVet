package com.project.domain.petowner.usecase;

import com.project.domain.petowner.PetOwner;
import com.project.domain.petowner.PetOwnerId;

public interface LoadPetOwner {

  PetOwner findBy(PetOwnerId id);

}
