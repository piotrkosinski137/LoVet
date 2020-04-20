package com.project.auth.usecase;

import com.project.auth.controller.dto.RegisterPetOwnerDto;
import com.project.auth.domain.BaseEntity;
import com.project.auth.domain.EntityId;
import com.project.auth.domain.usecase.LoadBaseEntity;
import com.project.auth.domain.usecase.SaveBaseEntity;
import com.project.auth.usecase.exceptions.InvalidEmailSyntax;
import com.project.auth.usecase.exceptions.PetOwnerAlreadyExist;
import com.project.event.PetOwnerCreated;
import java.util.regex.Pattern;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Service;

@Service
public class RegisterPetOwner {

  private final LoadBaseEntity loadBaseEntity;
  private final SaveBaseEntity saveBaseEntity;
  private final ApplicationEventPublisher publisher;

  public RegisterPetOwner(LoadBaseEntity loadBaseEntity, SaveBaseEntity saveBaseEntity,
      ApplicationEventPublisher publisher) {
    this.loadBaseEntity = loadBaseEntity;
    this.saveBaseEntity = saveBaseEntity;
    this.publisher = publisher;
  }

  public void register(RegisterPetOwnerDto dto) {
    validateEmail(dto.getEmail());
    EntityId userId = saveBaseEntity.save(new BaseEntity(dto.getEmail(), dto.getPassword()));

    publisher.publishEvent(new PetOwnerCreated(this,
        userId.toString(),
        dto.getName(),
        dto.getSurname(),
        dto.getPhoneNumber()));
  }

  private void validateEmail(String email) {
    validateEmailSyntax(email);
    validateIfEmailUnique(email);
  }

  private void validateEmailSyntax(String email) {
    String regex = "^(.+)@(.+)$";
    Pattern pattern = Pattern.compile(regex);

    if (pattern.matcher(email).matches()) {
      throw new InvalidEmailSyntax(email);
    }
  }

  private void validateIfEmailUnique(String email) {
    if (loadBaseEntity.existsByEmail(email)) {
      throw new PetOwnerAlreadyExist(email);
    }
  }
}
