package com.project.auth.usecase.exceptions;

import static com.project.errors.ErrorCode.E_AUTH_01;

import com.project.errors.LoVetException;

public class InvalidCredentials extends LoVetException {

  public InvalidCredentials() {
    super(E_AUTH_01);
  }
}
