package com.project.usecase.event.petowner;

import com.project.domain.petowner.Pet;
import com.project.domain.petowner.PetOwnerId;
import com.project.domain.petowner.gateway.PetGateway;
import com.project.domain.petowner.usecase.SavePet;
import com.project.event.PetCreated;
import java.util.UUID;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Service;

@Service
public class SavePetUsecase implements SavePet {

  private final PetGateway petGateway;
  private final ApplicationEventPublisher publisher;

  public SavePetUsecase(PetGateway petGateway, ApplicationEventPublisher publisher) {
    this.petGateway = petGateway;
    this.publisher = publisher;
  }

  @Override
  public void save(Pet pet, PetOwnerId petOwnerId) {
    UUID petId = petGateway.save(pet.toSnapshot());
    publisher.publishEvent(new PetCreated(this, petId, petOwnerId.value()));
  }
}
