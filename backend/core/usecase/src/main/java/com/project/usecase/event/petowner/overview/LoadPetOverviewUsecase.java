package com.project.usecase.event.petowner.overview;

import com.project.domain.petowner.PetId;
import com.project.domain.petowner.PetOwnerId;
import com.project.domain.petowner.gateway.overview.LoadPetsOverview;
import com.project.domain.petowner.gateway.overview.PetOverview;
import com.project.domain.petowner.gateway.overview.PetOverviewGateway;
import com.project.usecase.event.petowner.exception.PetNotFound;
import java.util.Collection;
import org.springframework.stereotype.Service;

@Service
public class LoadPetOverviewUsecase implements LoadPetsOverview {

  private final PetOverviewGateway gateway;

  public LoadPetOverviewUsecase(PetOverviewGateway gateway) {
    this.gateway = gateway;
  }

  @Override
  public Collection<PetOverview> findAllFrom(PetOwnerId petOwnerId) {
    return gateway.findAllFrom(petOwnerId.value());
  }

  @Override
  public PetOverview findBy(PetId petId) {
    return gateway.findBy(petId.value())
        .orElseThrow(() -> new PetNotFound(petId.value()));
  }
}
