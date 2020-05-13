package com.project.gateway;

import com.project.domain.Visit;
import com.project.domain.gateway.VisitGateway;
import org.springframework.stereotype.Service;

@Service
public class DbVisitGateway implements VisitGateway {

  private final VisitRepository visitRepository;

  public DbVisitGateway(VisitRepository visitRepository) {
    this.visitRepository = visitRepository;
  }

  @Override
  public void save(Visit visit) {
    visitRepository.save(visit.toSnapshot());
    //TODO event to inform other parties
  }
}
