package com.project.gateway.petowner;

import com.project.domain.petowner.PetSnapshot;
import com.project.domain.petowner.gateway.PetGateway;
import java.util.Collection;
import java.util.UUID;
import org.springframework.stereotype.Service;

@Service
public class DbPetGateway implements PetGateway {

  private final PetSnapshotRepository petSnapshotRepository;

  public DbPetGateway(PetSnapshotRepository petSnapshotRepository) {
    this.petSnapshotRepository = petSnapshotRepository;
  }

  @Override
  public UUID save(PetSnapshot snapshot) {
    return petSnapshotRepository.save(snapshot).getId();
  }

  @Override
  public Collection<PetSnapshot> findAllFrom(String petOwnerId) {
    return petSnapshotRepository.findByPetOwnerId(petOwnerId);
  }
}
