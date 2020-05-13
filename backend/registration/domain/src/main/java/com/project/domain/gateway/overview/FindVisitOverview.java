package com.project.domain.gateway.overview;

import java.util.UUID;

public interface FindVisitOverview {

  VisitOverview findBy(UUID id);
}
