package com.project.gateway.petowner;

import com.project.domain.petowner.PetOwnerSnapshot;
import java.util.UUID;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PetOwnerSnapshotRepository extends JpaRepository<PetOwnerSnapshot, UUID> {

}
