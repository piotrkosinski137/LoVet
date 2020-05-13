package com.project.auth.usecase.exceptions;

import static com.project.commons.errors.ErrorCode.E_AUTH_03;

import com.project.commons.errors.LoVetException;

public class PetOwnerAlreadyExist extends LoVetException {

  public PetOwnerAlreadyExist(String email) {
    super(E_AUTH_03, String.format("Account with email %s already exist. Please pick other one", email));
  }
}
