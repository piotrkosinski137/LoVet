package com.project.usecase.event.petowner.overview;

import com.project.domain.petowner.PetOwnerId;
import com.project.domain.petowner.gateway.overview.FindPetsOverview;
import com.project.domain.petowner.gateway.overview.PetOverview;
import com.project.domain.petowner.gateway.overview.PetOverviewGateway;
import com.project.usecase.event.petowner.exception.PetNotFound;
import java.util.Collection;
import java.util.UUID;
import org.springframework.stereotype.Service;

@Service
public class FindPetOverviewUsecase implements FindPetsOverview {

  private final PetOverviewGateway gateway;

  public FindPetOverviewUsecase(PetOverviewGateway gateway) {
    this.gateway = gateway;
  }

  @Override
  public Collection<PetOverview> findAllFrom(PetOwnerId petOwnerId) {
    return gateway.findAllFrom(petOwnerId.value());
  }

  @Override
  public PetOverview findBy(UUID petId) {
    return gateway.findBy(petId)
        .orElseThrow(() -> new PetNotFound(petId));
  }
}
