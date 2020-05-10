package com.project.domain.petowner.gateway.overview;

import com.project.domain.petowner.PetOwnerId;

public interface LoadPetOwnerOverview {

  PetOwnerOverview findBy(PetOwnerId id);
}
