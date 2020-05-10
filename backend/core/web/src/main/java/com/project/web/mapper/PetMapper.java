package com.project.web.mapper;

import com.project.domain.petowner.Pet;
import com.project.domain.petowner.PetOwnerId;
import com.project.domain.petowner.PetType;
import com.project.web.dto.PetCommandDto;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import org.springframework.stereotype.Component;

@Component
public class PetMapper {

  public Pet toPet(PetCommandDto dto, String photoUrl) {
    return new Pet(dto.getName(), PetType.valueOf(dto.getType()), photoUrl,
        convertDateFromString(dto.getDateOfBirth()));
  }

  private LocalDate convertDateFromString(String dateOfBirth) {
    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
    return LocalDate.parse(dateOfBirth.substring(0, dateOfBirth.indexOf("T")), formatter);
  }
}
