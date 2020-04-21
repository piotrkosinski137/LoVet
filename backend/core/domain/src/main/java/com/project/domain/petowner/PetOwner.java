package com.project.domain.petowner;

import java.util.Set;

public class PetOwner {

  private PetOwnerId id;
  private Set<PetId> pets;

  public PetOwnerSnapshot toSnapshot() {
    return null;
  }

  public static PetOwner fromSnapshot(PetOwnerSnapshot snapshot) {
    return null;
  }

  public void addPet(PetId petId) {
  }
}
