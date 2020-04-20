package com.project.domain.petowner;

import java.util.UUID;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class PetOwnerSnapshot {

  @Id
  private UUID id;
}
