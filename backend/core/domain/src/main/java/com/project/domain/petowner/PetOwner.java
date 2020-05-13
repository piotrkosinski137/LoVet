package com.project.domain.petowner;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;
import java.util.stream.Collectors;

public class PetOwner {

  private final PetOwnerId id;
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

  public PetOwner(PetOwnerId id, String name, String surname, String phoneNumber, Set<PetId> pets) {
    this(id, name, surname, phoneNumber);
    this.pets.addAll(pets);
  }

  public PetOwnerSnapshot toSnapshot() {
    return new PetOwnerSnapshot(id.value(), name, surname, phoneNumber,
        pets.stream().map(PetId::value).collect(Collectors.toSet()));
  }

  public static PetOwner fromSnapshot(PetOwnerSnapshot snapshot) {
    return new PetOwner(PetOwnerId.create(snapshot.getId()), snapshot.getName(),
        snapshot.getSurname(), snapshot.getPhoneNumber(),
        snapshot.getPets().stream().map(PetId::create).collect(Collectors.toSet()));
  }

  public void addPet(PetId petId) {
    pets.add(petId);
  }

  public void removePet(PetId petId) {
    pets.remove(petId);
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    PetOwner petOwner = (PetOwner) o;
    return id.equals(petOwner.id);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id);
  }
}
