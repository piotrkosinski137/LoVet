package com.project.web;

import com.project.domain.petowner.PetOwnerId;
import com.project.domain.petowner.gateway.overview.FindPetOwnerOverview;
import com.project.domain.petowner.gateway.overview.PetOwnerOverview;
import java.security.Principal;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/pet-owner/overview")
public class PetOwnerQueryController {

  private final FindPetOwnerOverview loadPetOwner;

  public PetOwnerQueryController(FindPetOwnerOverview loadPetOwner) {
    this.loadPetOwner = loadPetOwner;
  }

  @GetMapping("/current")
  public PetOwnerOverview getLoggedInPetOwner(Principal principal) {
    return loadPetOwner.findBy(PetOwnerId.create(principal.getName()));
  }
}
