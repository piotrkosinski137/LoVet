package com.project.auth.controller;

import java.io.Serializable;

public class JwtAuthenticationResponse implements Serializable {

  private static final long serialVersionUID = 1250166508152483573L;

  private final String token;

  JwtAuthenticationResponse(String token) {
    this.token = token;
  }

  public String getToken() {
    return token;
  }
}
