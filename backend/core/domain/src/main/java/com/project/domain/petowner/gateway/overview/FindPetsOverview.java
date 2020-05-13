package com.project.domain.petowner.gateway.overview;

import com.project.domain.petowner.PetOwnerId;
import java.util.Collection;
import java.util.UUID;

public interface FindPetsOverview {

  Collection<PetOverview> findAllFrom(PetOwnerId petOwnerId);

  PetOverview findBy(UUID petId);
}
