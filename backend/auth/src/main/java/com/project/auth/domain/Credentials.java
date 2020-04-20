package com.project.auth.domain;

import javax.persistence.Embeddable;
import java.util.Objects;

@Embeddable
class Credentials {

  private String email;
  private String password;

  private Credentials() {
  }

  private Credentials(String email, String password) {
    this.email = email;
    this.password = password;
  }

  public static Credentials create(String email, String password) {
    return new Credentials(email, password);
  }

  public String getEmail() {
    return email;
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
    return email.equals(that.email) &&
      password.equals(that.password);
  }

  @Override
  public int hashCode() {
    return Objects.hash(email, password);
  }
}
