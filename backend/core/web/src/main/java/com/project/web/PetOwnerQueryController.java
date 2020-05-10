package com.project.web;

import com.project.domain.petowner.PetOwnerId;
import com.project.domain.petowner.gateway.overview.LoadPetOwnerOverview;
import com.project.domain.petowner.gateway.overview.PetOwnerOverview;
import com.project.web.dto.PetOwnerDto;
import java.security.Principal;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/pet-owner/overview")
public class PetOwnerQueryController {

  private final LoadPetOwnerOverview loadPetOwner;

  public PetOwnerQueryController(LoadPetOwnerOverview loadPetOwner) {
    this.loadPetOwner = loadPetOwner;
  }

  @GetMapping("/current")
  public PetOwnerOverview getLoggedInPetOwner(Principal principal) {
    return loadPetOwner.findBy(PetOwnerId.create(principal.getName()));
  }
}
