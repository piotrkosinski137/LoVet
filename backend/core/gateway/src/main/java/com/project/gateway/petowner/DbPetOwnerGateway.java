package com.project.gateway.petowner;

import com.project.domain.petowner.PetOwnerSnapshot;
import com.project.domain.petowner.gateway.PetOwnerGateway;
import org.springframework.stereotype.Service;

@Service
public class DbPetOwnerGateway implements PetOwnerGateway {

  private final PetOwnerSnapshotRepository repository;

  public DbPetOwnerGateway(PetOwnerSnapshotRepository repository) {
    this.repository = repository;
  }

  @Override
  public void register(PetOwnerSnapshot snapshot) {
    repository.save(snapshot);
  }
}
