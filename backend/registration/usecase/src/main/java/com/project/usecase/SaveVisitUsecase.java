package com.project.usecase;

import static com.project.commons.errors.ErrorCode.E_VISIT_01;

import com.project.domain.DoctorId;
import com.project.domain.Visit;
import com.project.domain.VisitId;
import com.project.domain.gateway.VisitGateway;
import com.project.domain.usecase.SaveVisit;
import com.project.event.BlankVisitsCreated;
import com.project.usecase.overview.exception.VisitNotFound;
import java.util.Collection;
import java.util.stream.Collectors;
import javax.transaction.Transactional;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Service;

@Service
public class SaveVisitUsecase implements SaveVisit {

  private final VisitGateway visitGateway;
  private final ApplicationEventPublisher publisher;

  public SaveVisitUsecase(VisitGateway visitGateway,
      ApplicationEventPublisher publisher) {
    this.visitGateway = visitGateway;
    this.publisher = publisher;
  }

  public void saveBlankTo(Collection<Visit> visits, DoctorId doctorId) {
    visits.forEach(visit -> visit.assignDoctor(doctorId));
    Collection<VisitId> visitIds = visitGateway.saveAll(visits);
    publisher.publishEvent(new BlankVisitsCreated(this, visitIds.stream()
        .map(VisitId::value)
        .collect(Collectors.toSet()), doctorId.value()));
  }

  @Override
  @Transactional
  public void book(Visit visit) {
    Visit dbVisit = visitGateway.findBy(visit.getId())
        .orElseThrow(() -> new VisitNotFound(E_VISIT_01, visit.getId().value().toString()));

    dbVisit.book(visit.getDoctorId(),
        visit.getPetId(),
        visit.getVisitDate());
  }
}
