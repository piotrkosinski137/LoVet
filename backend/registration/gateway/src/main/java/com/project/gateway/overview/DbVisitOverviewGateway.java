package com.project.gateway.overview;

import com.project.domain.gateway.overview.VisitOverview;
import com.project.domain.gateway.overview.VisitOverviewGateway;
import java.util.Optional;
import java.util.UUID;
import org.springframework.stereotype.Service;

@Service
public class DbVisitOverviewGateway implements VisitOverviewGateway {

  private final VisitOverviewRepository visitOverviewRepository;

  public DbVisitOverviewGateway(VisitOverviewRepository visitOverviewRepository) {
    this.visitOverviewRepository = visitOverviewRepository;
  }

  @Override
  public Optional<VisitOverview> findBy(UUID id) {
    return visitOverviewRepository.findById(id);
  }
}
