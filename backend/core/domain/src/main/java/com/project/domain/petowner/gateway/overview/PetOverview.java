package com.project.domain.petowner.gateway.overview;

import java.util.Objects;
import java.util.UUID;
import javax.persistence.Entity;
import javax.persistence.Id;
import org.hibernate.annotations.Type;

@Entity
public class PetOverview {

  @Id
  @Type(type="org.hibernate.type.UUIDCharType")
  private UUID id;
  private String petOwnerId;
  private String name;
  private String type;
  private String photoUrl;

  public UUID getId() {
    return id;
  }

  public String getPetOwnerId() {
    return petOwnerId;
  }

  public String getName() {
    return name;
  }

  public String getType() {
    return type;
  }

  public String getPhotoUrl() {
    return photoUrl;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    PetOverview that = (PetOverview) o;
    return id.equals(that.id);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id);
  }
}
