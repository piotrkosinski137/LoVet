package com.project.domain.petowner.gateway.overview;

import java.util.Collection;
import java.util.Optional;
import java.util.UUID;

public interface PetOverviewGateway {

  Collection<PetOverview> findAllFrom(String value);

  Optional<PetOverview> findBy(UUID petId);
}
