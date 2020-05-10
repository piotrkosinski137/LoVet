package com.project.domain.petowner.usecase;

import com.project.domain.petowner.PetOwner;
import com.project.domain.petowner.PetOwnerId;
import com.project.domain.petowner.gateway.overview.PetOwnerOverview;

public interface LoadPetOwner {

  PetOwner findBy(PetOwnerId id);
}
