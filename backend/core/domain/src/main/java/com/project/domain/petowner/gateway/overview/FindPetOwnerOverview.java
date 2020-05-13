package com.project.domain.petowner.gateway.overview;

import com.project.domain.petowner.PetOwnerId;

public interface FindPetOwnerOverview {

  PetOwnerOverview findBy(PetOwnerId id);
}
