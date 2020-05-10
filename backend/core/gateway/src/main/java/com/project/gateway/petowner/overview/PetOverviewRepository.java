package com.project.gateway.petowner.overview;

import com.project.domain.petowner.gateway.overview.PetOverview;
import java.util.Collection;
import java.util.UUID;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PetOverviewRepository extends JpaRepository<PetOverview, UUID> {

  Collection<PetOverview> findByPetOwnerId(String petOwnerId);
}
