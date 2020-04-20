package com.project.domain.petowner.gateway;

import com.project.domain.petowner.PetOwnerSnapshot;

public interface PetOwnerGateway {

  void register(PetOwnerSnapshot snapshot);
}
