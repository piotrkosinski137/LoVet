package com.project.usecase.event.petowner.exception;

import static com.project.errors.ErrorCode.E_PET_OWNER_01;

import com.project.errors.LoVetException;

public class PetOwnerNotFound extends LoVetException {

  public PetOwnerNotFound(String petOwnerId) {
    super(E_PET_OWNER_01, String.format("Pet Owner with id %s doesn't exist", petOwnerId));
  }
}
