package com.project.domain.auth;

import org.hibernate.annotations.Type;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;
import java.util.Objects;
import java.util.UUID;

@Embeddable
public class EntityId implements Serializable {

  private static final long serialVersionUID = 4385521661952913183L;

  @Column(name = "ID")
  @Type(type="org.hibernate.type.UUIDCharType")
  private UUID value;

  private EntityId() {
  }

  private EntityId(UUID id) {
    this.value = id;
  }

  public static EntityId create() {
    return new EntityId(UUID.randomUUID());
  }

  public static EntityId create(UUID id) {
    return new EntityId(id);
  }

  public UUID getValue() {
    return value;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    EntityId entityId = (EntityId) o;
    return value.equals(entityId.value);
  }

  @Override
  public int hashCode() {
    return Objects.hash(value);
  }
}
