package com.project.gateway.petowner;

import com.project.domain.petowner.PetSnapshot;
import java.util.Collection;
import java.util.UUID;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PetSnapshotRepository extends JpaRepository<PetSnapshot, UUID> {
    Collection<PetSnapshot> findByPetOwnerId(String petOwnerId);
}
