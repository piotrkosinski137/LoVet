package com.project.domain.petowner.gateway.overview;

import java.util.Optional;

public interface PetOwnerOverviewGateway {

  Optional<PetOwnerOverview> findBy(String petOwnerId);
}
