package com.project.auth.controller;

import java.io.Serializable;

public class JwtAuthenticationRequest implements Serializable {

  private static final long serialVersionUID = -8445943548965154778L;

  private String username;
  private String password;

  private JwtAuthenticationRequest() {
  }

  public JwtAuthenticationRequest(String username, String password) {
    this.username = username;
    this.password = password;
  }

  String getUsername() {
    return this.username;
  }

  String getPassword() {
    return this.password;
  }

  void setUsername(String username) {
    this.username = username;
  }

  void setPassword(String password) {
    this.password = password;
  }
}
