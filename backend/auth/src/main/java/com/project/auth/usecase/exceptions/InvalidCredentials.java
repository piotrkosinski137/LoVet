package com.project.auth.usecase.exceptions;

import static com.project.commons.errors.ErrorCode.E_AUTH_01;

import com.project.commons.errors.LoVetException;

public class InvalidCredentials extends LoVetException {

  public InvalidCredentials() {
    super(E_AUTH_01);
  }
}
