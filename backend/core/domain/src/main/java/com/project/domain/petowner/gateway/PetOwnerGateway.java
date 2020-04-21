package com.project.domain.petowner.gateway;

import com.project.domain.petowner.PetOwnerId;
import com.project.domain.petowner.PetOwnerSnapshot;
import java.util.Optional;

public interface PetOwnerGateway {

  void register(PetOwnerSnapshot snapshot);

  Optional<PetOwnerSnapshot> findBy(PetOwnerId petOwnerId);

  void save(PetOwnerSnapshot snapshot);
}
