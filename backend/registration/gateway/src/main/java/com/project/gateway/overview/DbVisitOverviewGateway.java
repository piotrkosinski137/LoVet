package com.project.gateway.overview;

import com.project.domain.gateway.overview.DoctorVisitDatesOverview;
import com.project.domain.gateway.overview.VisitOverview;
import com.project.domain.gateway.overview.VisitOverviewGateway;
import java.time.LocalDate;
import java.util.Collection;
import java.util.Optional;
import java.util.UUID;
import org.springframework.stereotype.Service;

@Service
public class DbVisitOverviewGateway implements VisitOverviewGateway {

  private final VisitOverviewRepository repository;

  public DbVisitOverviewGateway(VisitOverviewRepository visitOverviewRepository) {
    this.repository = visitOverviewRepository;
  }

  @Override
  public Optional<VisitOverview> findBy(UUID id) {
    return repository.findById(id);
  }

  @Override
  public Collection<DoctorVisitDatesOverview> findByDoctorIdAndMonth(String doctorId, LocalDate date) {
    return repository.findByDoctorAndDate(doctorId, date.getYear(), date.getMonthValue());
  }
}
