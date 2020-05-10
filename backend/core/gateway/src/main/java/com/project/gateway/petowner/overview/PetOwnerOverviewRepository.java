package com.project.gateway.petowner.overview;

import com.project.domain.petowner.gateway.overview.PetOwnerOverview;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PetOwnerOverviewRepository extends JpaRepository<PetOwnerOverview, String> {

}
