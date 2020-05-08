package com.project.domain.petowner;

import java.util.HashSet;
import java.util.Set;

public class PetOwner {

  private PetOwnerId id;
  private final String name;
  private final String surname;
  private final String phoneNumber;
  private Set<PetId> pets = new HashSet<>();


  public PetOwner(PetOwnerId id, String name, String surname, String phoneNumber) {
    this.id = id;
    this.name = name;
    this.surname = surname;
    this.phoneNumber = phoneNumber;
  }

  public PetOwnerSnapshot toSnapshot() {
    return null;
  }

  public static PetOwner fromSnapshot(PetOwnerSnapshot snapshot) {
    return null;
  }

  public void addPet(PetId petId) {
  }
}
