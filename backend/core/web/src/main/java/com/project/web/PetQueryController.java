package com.project.web;

import com.project.domain.petowner.PetOwnerId;
import com.project.domain.petowner.gateway.overview.PetOverview;
import com.project.usecase.event.petowner.overview.FindPetOverviewUsecase;
import java.security.Principal;
import java.util.Collection;
import java.util.UUID;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/pets/overview")
public class PetQueryController {

  private final FindPetOverviewUsecase loadPetOverviewUsecase;

  public PetQueryController(FindPetOverviewUsecase loadPetOverviewUsecase) {
    this.loadPetOverviewUsecase = loadPetOverviewUsecase;
  }

  @GetMapping("/current")
  public Collection<PetOverview> findAllFromLoggedIn(Principal principal) {
    return loadPetOverviewUsecase.findAllFrom(PetOwnerId.create(principal.getName()));
  }

  @GetMapping("/{petId}")
  public PetOverview findBy(@PathVariable String petId) {
    return loadPetOverviewUsecase.findBy(UUID.fromString(petId));
  }
}
