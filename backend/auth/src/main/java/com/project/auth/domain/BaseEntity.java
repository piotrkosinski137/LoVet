package com.project.auth.domain;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "USERS")
public class BaseEntity {

  @EmbeddedId
  private EntityId id;

  @Embedded
  private Credentials credentials;

  @Enumerated(EnumType.STRING)
  private Role role = Role.PET_OWNER;

  public BaseEntity() {
  }

  public BaseEntity(String email, String password) {
    this.credentials = Credentials.create(email, password);
    this.id = EntityId.create();
  }

  public BaseEntity(String email, String password, Role role) {
    this.credentials = Credentials.create(email, password);
    this.id = EntityId.create();
    this.role = role;
  }

  public EntityId getId() {
    return id;
  }

  public Credentials getCredentials() {
    return credentials;
  }

  public Role getRole() {
    return role;
  }

  public String getUsername() {
    return credentials.getEmail();
  }

  public String getPassword() {
    return credentials.getPassword();
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    BaseEntity that = (BaseEntity) o;
    return id.equals(that.id);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id);
  }
}
