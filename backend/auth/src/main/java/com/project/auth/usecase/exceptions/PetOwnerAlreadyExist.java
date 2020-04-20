package com.project.auth.usecase.exceptions;

public class PetOwnerAlreadyExist extends RuntimeException {

  public PetOwnerAlreadyExist(String email) {
    super(String.format("User with email %s already exist. Please pick other one", email));
  }
}
