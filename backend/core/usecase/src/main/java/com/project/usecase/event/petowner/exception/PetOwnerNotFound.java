package com.project.usecase.event.petowner.exception;

public class PetOwnerNotFound extends RuntimeException {

  public PetOwnerNotFound() {
    super("Pet Owner not found!");
  }
}
