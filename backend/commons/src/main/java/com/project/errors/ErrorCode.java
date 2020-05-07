package com.project.errors;

public enum ErrorCode {
  E_DEFAULT("Something went wrong"),

  E_AUTH_01("Invalid Username or Password"),
  E_AUTH_02("Invalid Email syntax"),
  E_AUTH_03("Account with given email already exist"),


  E_PET_OWNER_01("Pet owner doesn't exist");

  private String details;

  ErrorCode(String details) {
    this.details = details;
  }

  public String getDetails() {
    return details;
  }
}
