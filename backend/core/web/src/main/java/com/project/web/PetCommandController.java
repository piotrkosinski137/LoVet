package com.project.web;

import com.project.domain.petowner.PetId;
import com.project.domain.petowner.PetOwnerId;
import com.project.domain.petowner.usecase.RemovePet;
import com.project.domain.petowner.usecase.SavePet;
import com.project.commons.images.UploadImageUsecase;
import com.project.web.dto.PetCommandDto;
import com.project.web.mapper.PetMapper;
import java.security.Principal;
import java.util.UUID;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/pets")
public class PetCommandController {

  private final SavePet savePet;
  private final RemovePet removePet;
  private final PetMapper mapper;
  private final UploadImageUsecase uploadImageUsecase;

  public PetCommandController(SavePet savePet, RemovePet removePet, PetMapper mapper,
      UploadImageUsecase uploadImageUsecase) {
    this.savePet = savePet;
    this.removePet = removePet;
    this.mapper = mapper;
    this.uploadImageUsecase = uploadImageUsecase;
  }

  @PostMapping
  public void save(@RequestBody PetCommandDto dto, Principal principal) {
    savePet.save(mapper.toPet(dto, uploadImageUsecase.upload(dto.getBase64Image(),
            "pets/")), PetOwnerId.create(principal.getName()));
  }

  @DeleteMapping
  public void remove(String petId, Principal principal) {
    removePet.remove(PetId.create(UUID.fromString(petId)), PetOwnerId.create(principal.getName()));
  }
}
