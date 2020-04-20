package com.project.auth.controller;

import java.io.Serializable;

public class JwtAuthenticationRequest implements Serializable {

  private static final long serialVersionUID = -8445943548965154778L;

  private String email;
  private String password;

  private JwtAuthenticationRequest() {
  }

  public JwtAuthenticationRequest(String email, String password) {
    this.email = email;
    this.password = password;
  }

  String getEmail() {
    return this.email;
  }

  String getPassword() {
    return this.password;
  }

  void setEmail(String email) {
    this.email = email;
  }

  void setPassword(String password) {
    this.password = password;
  }
}
