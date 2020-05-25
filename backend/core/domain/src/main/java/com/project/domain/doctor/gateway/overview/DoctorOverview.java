package com.project.domain.doctor.gateway.overview;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class DoctorOverview {

  @Id
  private String id;
  private String name;
  private String surname;

  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getSurname() {
    return surname;
  }

  public void setSurname(String surname) {
    this.surname = surname;
  }
}
