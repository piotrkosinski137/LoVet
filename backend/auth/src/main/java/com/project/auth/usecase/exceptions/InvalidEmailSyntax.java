package com.project.auth.usecase.exceptions;

public class InvalidEmailSyntax extends RuntimeException {

  public InvalidEmailSyntax(String email) {
    super(String.format("Email %s is invalid", email));
  }
}
