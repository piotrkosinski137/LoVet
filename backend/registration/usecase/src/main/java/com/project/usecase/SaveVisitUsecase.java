package com.project.usecase;

import static com.project.commons.errors.ErrorCode.E_DOCTOR_02;
import static com.project.commons.errors.ErrorCode.E_VISIT_01;

import com.project.domain.DoctorId;
import com.project.domain.Visit;
import com.project.domain.VisitId;
import com.project.domain.gateway.VisitGateway;
import com.project.domain.usecase.SaveVisit;
import com.project.event.BlankVisitsCreated;
import com.project.event.BlankVisitsRemoved;
import com.project.usecase.exception.DeleteBookedWorkingHour;
import com.project.usecase.overview.exception.VisitNotFound;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Collection;
import java.util.List;
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

  @Transactional
  public void saveWorkingHoursDay(Collection<Visit> visits, DoctorId doctorId, LocalDate day) {
    Collection<Visit> dbVisits = visitGateway.findBy(doctorId, day);
    removeMissingVisits(visits, dbVisits, doctorId);
    addNewVisits(visits, dbVisits, doctorId);
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

  private void removeMissingVisits(Collection<Visit> visits, Collection<Visit> dbVisits,
      DoctorId doctorId) {
    Collection<Visit> visitsToDelete = dbVisits.stream()
        .filter(visit -> !containsVisit(visit.getVisitDate(), visits))
        .collect(Collectors.toSet());

    if (visitsToDelete.size() > 0) {
      if (anyToRemoveIsBooked(visitsToDelete)) {
        throw new DeleteBookedWorkingHour(
            E_DOCTOR_02); // TODO add better info which workHour causes problem
      }
      Collection<VisitId> visitIds = visitsToDelete.stream()
          .map(Visit::getId)
          .collect(Collectors.toList());
      visitGateway.deleteAllBy(visitIds);
      publisher.publishEvent(new BlankVisitsRemoved(this,
          visitIds.stream()
              .map(VisitId::value)
              .collect(Collectors.toSet()), doctorId.value()));
    }
  }

  private void addNewVisits(Collection<Visit> visits, Collection<Visit> dbVisits,
      DoctorId doctorId) {
    List<Visit> visitsToAdd = visits.stream()
        .filter(visit -> !containsVisit(visit.getVisitDate(), dbVisits))
        .map(visit -> visit.assignDoctor(doctorId))
        .collect(Collectors.toList());
    visitGateway.saveAll(visitsToAdd);
    publisher.publishEvent(new BlankVisitsCreated(this, visitsToAdd.stream()
        .map(visit -> visit.getId().value())
        .collect(Collectors.toSet()), doctorId.value()));
  }

  private boolean anyToRemoveIsBooked(Collection<Visit> visits) {
    return visits.stream().anyMatch(Visit::isBooked);
  }

  private boolean containsVisit(LocalDateTime visitDate, Collection<Visit> visits) {
    return visits.stream()
        .anyMatch(visit -> visit.getVisitDate().equals(visitDate));
  }
}
