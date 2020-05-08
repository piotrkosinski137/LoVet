package com.project.web;

import com.project.domain.petowner.usecase.LoadPetOwner;
import com.project.web.dto.PetOwnerDto;
import java.security.Principal;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/pet-owner")
public class PetOwnerController {

  private final LoadPetOwner loadPetOwner;

  public PetOwnerController(LoadPetOwner loadPetOwner) {
    this.loadPetOwner = loadPetOwner;
  }

  @GetMapping("/current")
  public PetOwnerDto getLoggedInPetOwner(Principal principal) {
    System.out.println(principal.getName());
    return null;
  }

}
