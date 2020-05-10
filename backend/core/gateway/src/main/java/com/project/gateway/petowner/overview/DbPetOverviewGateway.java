package com.project.gateway.petowner.overview;

import com.project.domain.petowner.gateway.overview.PetOverview;
import com.project.domain.petowner.gateway.overview.PetOverviewGateway;
import com.project.gateway.petowner.overview.PetOverviewRepository;
import java.util.Collection;
import java.util.Optional;
import java.util.UUID;
import org.springframework.stereotype.Service;

@Service
public class DbPetOverviewGateway implements PetOverviewGateway {

  private final PetOverviewRepository repository;

  public DbPetOverviewGateway(PetOverviewRepository repository) {
    this.repository = repository;
  }

  @Override
  public Collection<PetOverview> findAllFrom(String petOwnerId) {
    return repository.findByPetOwnerId(petOwnerId);
  }

  @Override
  public Optional<PetOverview> findBy(UUID petId) {
    return repository.findById(petId);
  }

}
