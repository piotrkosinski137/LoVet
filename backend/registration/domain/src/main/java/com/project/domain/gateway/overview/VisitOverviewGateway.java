package com.project.domain.gateway.overview;

import java.time.LocalDate;
import java.util.Collection;
import java.util.Optional;
import java.util.UUID;

public interface VisitOverviewGateway {

  Optional<VisitOverview> findBy(UUID id);

  Collection<DoctorVisitDatesOverview> findByDoctorIdAndMonth(String doctorId, LocalDate date);
}
