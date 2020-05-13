package com.project.commons.errors;

public enum SuccessCode {
  S_AUTH_01("Register success");

  private String details;

  SuccessCode(String details) {
    this.details = details;
  }

  public String getDetails() {
    return details;
  }
}
