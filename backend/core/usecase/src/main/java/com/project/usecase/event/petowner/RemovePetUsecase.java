package com.project.usecase.event.petowner;

import com.project.domain.petowner.PetId;
import com.project.domain.petowner.PetOwnerId;
import com.project.domain.petowner.gateway.PetGateway;
import com.project.domain.petowner.usecase.RemovePet;
import com.project.event.PetRemoved;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Service;

@Service
public class RemovePetUsecase implements RemovePet {

  private final PetGateway petGateway;
  private final ApplicationEventPublisher publisher;

  public RemovePetUsecase(PetGateway petGateway, ApplicationEventPublisher publisher) {
    this.petGateway = petGateway;
    this.publisher = publisher;
  }

  @Override
  public void remove(PetId petId, PetOwnerId petOwnerId) {
    petGateway.remove(petId.value());
    publisher.publishEvent(new PetRemoved(this, petId.value(), petOwnerId.value()));
  }
}
