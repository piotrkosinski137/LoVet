package com.project.domain.petowner.usecase;

import com.project.domain.petowner.PetId;
import com.project.domain.petowner.PetOwnerId;

public interface RemovePet {

  void remove(PetId petId, PetOwnerId petOwnerId);
}
