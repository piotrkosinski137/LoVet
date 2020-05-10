package com.project.domain.petowner.gateway.overview;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class PetOwnerOverview {

  @Id
  private String id;
  private String name;
  private String surname;
  private String phoneNumber;
}
