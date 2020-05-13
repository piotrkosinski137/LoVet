package com.project.gateway;

import com.project.domain.VisitSnapshot;
import java.util.UUID;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VisitRepository extends JpaRepository<VisitSnapshot, UUID> {
}
