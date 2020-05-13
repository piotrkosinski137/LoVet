package com.project.usecase;

import com.project.domain.Visit;
import com.project.domain.gateway.VisitGateway;
import com.project.domain.usecase.SaveVisit;
import org.springframework.stereotype.Service;

@Service
public class SaveVisitUsecase implements SaveVisit {

  private final VisitGateway visitGateway;

  public SaveVisitUsecase(VisitGateway visitGateway) {
    this.visitGateway = visitGateway;
  }

  @Override
  public void save(Visit visit) {
    visitGateway.save(visit);
  }
}
