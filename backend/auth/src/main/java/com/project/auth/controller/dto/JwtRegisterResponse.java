package com.project.auth.controller.dto;

public class JwtRegisterResponse {
  private String successCode;

  public JwtRegisterResponse() {
  }

  public JwtRegisterResponse(String successCode) {
    this.successCode = successCode;
  }

  public String getSuccessCode() {
    return successCode;
  }

  public void setSuccessCode(String successCode) {
    this.successCode = successCode;
  }
}
