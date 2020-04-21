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
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class RegisterPetOwner {

  private final LoadBaseEntity loadBaseEntity;
  private final SaveBaseEntity saveBaseEntity;
  private final ApplicationEventPublisher publisher;
  private final PasswordEncoder encoder;

  public RegisterPetOwner(LoadBaseEntity loadBaseEntity, SaveBaseEntity saveBaseEntity,
      ApplicationEventPublisher publisher, PasswordEncoder encoder) {
    this.loadBaseEntity = loadBaseEntity;
    this.saveBaseEntity = saveBaseEntity;
    this.publisher = publisher;
    this.encoder = encoder;
  }

  public void register(RegisterPetOwnerDto dto) {
    validateEmail(dto.getEmail());
    EntityId userId = saveBaseEntity.save(new BaseEntity(dto.getEmail(), encoder.encode(dto.getPassword())));

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
    final Pattern pattern = Pattern.compile("^[A-Z0-9._%+-]+@[A-Z0-9.-]+\\.[A-Z]{2,6}$", Pattern.CASE_INSENSITIVE);

    if (!pattern.matcher(email).matches()) {
      throw new InvalidEmailSyntax(email);
    }
  }

  private void validateIfEmailUnique(String email) {
    if (loadBaseEntity.existsByEmail(email)) {
      throw new PetOwnerAlreadyExist(email);
    }
  }
}
