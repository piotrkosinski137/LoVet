package com.project.domain.auth;

import javax.persistence.Embeddable;
import java.util.Objects;

@Embeddable
class Credentials {

  private String username;
  private String password;

  private Credentials() {
  }

  private Credentials(String username, String password) {
    this.username = username;
    this.password = password;
  }

  public static Credentials create(String username, String password) {
    return new Credentials(username, password);
  }

  public String getUsername() {
    return username;
  }

  public String getPassword() {
    return password;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Credentials that = (Credentials) o;
    return username.equals(that.username) &&
      password.equals(that.password);
  }

  @Override
  public int hashCode() {
    return Objects.hash(username, password);
  }
}
