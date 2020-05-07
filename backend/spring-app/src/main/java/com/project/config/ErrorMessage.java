package com.project.config;

public class ErrorMessage {
  private String errorCode;

  public ErrorMessage() {
  }

  public ErrorMessage(String errorCode) {
    this.errorCode = errorCode;
  }

  public String getErrorCode() {
    return errorCode;
  }

  public void setErrorCode(String errorCode) {
    this.errorCode = errorCode;
  }
}
