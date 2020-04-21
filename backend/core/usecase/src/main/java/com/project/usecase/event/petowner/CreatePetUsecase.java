package com.project.usecase.event.petowner;

import com.project.domain.petowner.Pet;
import com.project.domain.petowner.gateway.PetGateway;
import com.project.domain.petowner.usecase.CreatePet;
import com.project.event.PetCreated;
import java.util.UUID;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Service;

@Service
public class CreatePetUsecase implements CreatePet {

  private final PetGateway petGateway;
  private final ApplicationEventPublisher publisher;

  public CreatePetUsecase(PetGateway petGateway, ApplicationEventPublisher publisher) {
    this.petGateway = petGateway;
    this.publisher = publisher;
  }

  @Override
  public void create(Pet pet) {
    UUID petId = petGateway.save(pet.toSnapshot());
    publisher.publishEvent(new PetCreated(this, petId, pet.getPetOwnerId().value()));
  }
}
