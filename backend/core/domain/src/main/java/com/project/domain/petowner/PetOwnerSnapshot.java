package com.project.domain.petowner;

import java.util.HashSet;
import java.util.Set;
import java.util.UUID;
import javax.persistence.CollectionTable;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Table;

@Entity
@Table(name="PET_OWNER")
public class PetOwnerSnapshot {

  @Id
  private String id;
  private String name;
  private String surname;
  private String phoneNumber;
  @ElementCollection
  @CollectionTable(
      name="PET_OWNER_PET_ID",
      joinColumns=@JoinColumn(name="PET_OWNER_ID")
  )
  @Column(name="PET_ID")
  private Set<UUID> pets = new HashSet<>();

  private PetOwnerSnapshot() {
  }

  public PetOwnerSnapshot(String id, String name, String surname, String phoneNumber, Set<UUID> pets) {
    this.id = id;
    this.name = name;
    this.surname = surname;
    this.phoneNumber = phoneNumber;
    this.pets = pets;
  }

  public String getId() {
    return id;
  }

  public String getName() {
    return name;
  }

  public String getSurname() {
    return surname;
  }

  public String getPhoneNumber() {
    return phoneNumber;
  }

  public Set<UUID> getPets() {
    return pets;
  }
}
