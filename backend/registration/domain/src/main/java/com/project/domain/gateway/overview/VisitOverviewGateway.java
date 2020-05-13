package com.project.domain.gateway.overview;

import java.util.Optional;
import java.util.UUID;

public interface VisitOverviewGateway {

  Optional<VisitOverview> findBy(UUID id);
}
