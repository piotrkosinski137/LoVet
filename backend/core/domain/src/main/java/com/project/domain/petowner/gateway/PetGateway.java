package com.project.domain.petowner.gateway;

import com.project.domain.petowner.PetSnapshot;
import java.util.UUID;

public interface PetGateway {

  UUID save(PetSnapshot snapshot);

  void remove(UUID petId);
}
