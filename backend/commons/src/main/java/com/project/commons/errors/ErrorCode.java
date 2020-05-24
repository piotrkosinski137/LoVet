package com.project.commons.errors;

public enum ErrorCode {
  E_DEFAULT("Something went wrong"),

  E_GENERAL_01("Invalid image type"),
  E_GENERAL_02("To big image size"),
  E_GENERAL_03("Error during image save, try again later"),
  E_GENERAL_04("Image not found"),

  E_AUTH_01("Invalid Username or Password"),
  E_AUTH_02("Invalid Email syntax"),
  E_AUTH_03("Account with given email already exist"),
  E_AUTH_04("You are not authorized to proceed this operation"),

  E_PET_OWNER_01("Pet owner doesn't exist"),

  E_PET_01("Pet doesn't exist"),

  E_DOCTOR_01("Doctor doesn't exist"),
  E_DOCTOR_02("Can't remove working hour because is already booked"),

  E_VISIT_01("Visit doesn't exist");

  private String details;

  ErrorCode(String details) {
    this.details = details;
  }

  public String getDetails() {
    return details;
  }
}
