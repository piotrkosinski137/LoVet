package com.project.domain.petowner.gateway.overview;

import com.project.domain.petowner.PetId;
import com.project.domain.petowner.PetOwnerId;
import java.util.Collection;
import java.util.Optional;

public interface LoadPetsOverview {

  Collection<PetOverview> findAllFrom(PetOwnerId petOwnerId);

  PetOverview findBy(PetId petId);
}
