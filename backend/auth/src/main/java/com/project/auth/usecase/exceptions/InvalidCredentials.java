package com.project.auth.usecase.exceptions;

public class InvalidCredentials extends RuntimeException {

  public InvalidCredentials() {
    super("Wrong email or password!");
  }
}
