package com.project.usecase.event.petowner.exception;

import static com.project.commons.errors.ErrorCode.E_PET_01;

import com.project.commons.errors.LoVetException;
import java.util.UUID;

public class PetNotFound extends LoVetException {

  public PetNotFound(UUID petId) {
    super(E_PET_01, String.format("Pet with id %s doesn't exist", petId.toString()));
  }
}
