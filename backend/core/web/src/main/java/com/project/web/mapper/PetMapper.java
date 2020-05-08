package com.project.web.mapper;

import com.project.domain.petowner.Pet;
import com.project.domain.petowner.PetOwnerId;
import com.project.domain.petowner.PetType;
import com.project.web.dto.PetCommandDto;
import org.springframework.stereotype.Component;

@Component
public class PetMapper {

  public Pet toPet(PetCommandDto dto, String photoUrl, String petOwnerId) {
    return new Pet(dto.getName(), PetOwnerId.create(petOwnerId),
        PetType.valueOf(dto.getType()), photoUrl);
  }
}
