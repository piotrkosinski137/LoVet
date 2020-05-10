package com.project.gateway.petowner.overview;

import com.project.domain.petowner.gateway.overview.PetOwnerOverview;
import com.project.domain.petowner.gateway.overview.PetOwnerOverviewGateway;
import java.util.Optional;
import org.springframework.stereotype.Service;

@Service
public class DbPetOwnerOverviewGateway implements PetOwnerOverviewGateway {

  private final PetOwnerOverviewRepository repository;

  public DbPetOwnerOverviewGateway(PetOwnerOverviewRepository repository) {
    this.repository = repository;
  }

  @Override
  public Optional<PetOwnerOverview> findBy(String petOwnerId) {
    return repository.findById(petOwnerId);
  }
}
