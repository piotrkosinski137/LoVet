package com.project.web;

import com.project.domain.petowner.usecase.SavePet;
import com.project.images.UploadImageUsecase;
import com.project.web.dto.PetCommandDto;
import com.project.web.mapper.PetMapper;
import java.security.Principal;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/pets")
public class PetController {

  private final SavePet savePet;
  private final PetMapper mapper;
  private final UploadImageUsecase uploadImageUsecase;

  public PetController(SavePet savePet, PetMapper mapper, UploadImageUsecase uploadImageUsecase) {
    this.savePet = savePet;
    this.mapper = mapper;
    this.uploadImageUsecase = uploadImageUsecase;
  }

  @PostMapping
  public void save(PetCommandDto dto, Principal principal) {
    savePet.save(mapper.toPet(dto, uploadImageUsecase.upload(dto.getBase64Image(),
            "/pets"), principal.getName()));
  }
}
