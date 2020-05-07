package com.project.auth.usecase.exceptions;

import static com.project.errors.ErrorCode.E_AUTH_02;
import com.project.errors.LoVetException;

public class InvalidEmailSyntax extends LoVetException {

  public InvalidEmailSyntax(String email) {
    super(E_AUTH_02, String.format("Email %s is invalid", email));
  }
}
