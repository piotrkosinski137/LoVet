package com.project.domain.petowner.gateway;

import com.project.domain.petowner.PetSnapshot;
import java.util.Collection;
import java.util.UUID;

public interface PetGateway {

  UUID save(PetSnapshot snapshot);

  Collection<PetSnapshot> findAllFrom(UUID value);
}
