package com.project.commons.errors;

public class LoVetException extends RuntimeException {

  private final ErrorCode errorCode;

  public LoVetException(ErrorCode errorCode, String details) {
    super(details);
    this.errorCode = errorCode;
  }

  public LoVetException(ErrorCode errorCode) {
    super(errorCode.getDetails());
    this.errorCode = errorCode;
  }

  public ErrorCode getErrorCode() {
    return errorCode;
  }
}
