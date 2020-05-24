package com.project.gateway;

import com.project.domain.DoctorId;
import com.project.domain.Visit;
import com.project.domain.VisitId;
import com.project.domain.gateway.VisitGateway;
import java.time.LocalDate;
import java.util.Collection;
import java.util.Optional;
import java.util.stream.Collectors;
import org.springframework.stereotype.Service;

@Service
public class DbVisitGateway implements VisitGateway {

  private final VisitRepository visitRepository;

  public DbVisitGateway(VisitRepository visitRepository) {
    this.visitRepository = visitRepository;
  }

  @Override
  public Collection<VisitId> saveAll(Collection<Visit> visits) {
    return visitRepository
        .saveAll(visits.stream().map(Visit::toSnapshot).collect(Collectors.toSet()))
        .stream()
        .map(snapshot -> VisitId.create(snapshot.getId()))
        .collect(Collectors.toSet());
  }

  @Override
  public void deleteAllBy(Collection<VisitId> visitId) {
    visitRepository.deleteByIdIn(visitId.stream()
        .map(VisitId::value)
        .collect(Collectors.toList()));
  }

  @Override
  public Optional<Visit> findBy(VisitId id) {
    return visitRepository.findById(id.value()).map(Visit::fromSnapshot);
  }

  @Override
  public Collection<Visit> findBy(DoctorId doctorId, LocalDate day) {
    return visitRepository.findByDoctorAndDay(doctorId.value(), day.getYear(), day.getMonthValue(),
        day.getDayOfMonth())
        .stream()
        .map(Visit::fromSnapshot)
        .collect(Collectors.toSet());
  }
}
