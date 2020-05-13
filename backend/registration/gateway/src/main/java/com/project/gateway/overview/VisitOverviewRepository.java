package com.project.gateway.overview;

import com.project.domain.gateway.overview.VisitOverview;
import java.util.UUID;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VisitOverviewRepository extends JpaRepository<VisitOverview, UUID> {

}
