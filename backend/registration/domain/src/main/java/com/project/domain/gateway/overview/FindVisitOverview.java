package com.project.domain.gateway.overview;

import java.time.LocalDate;
import java.util.Collection;
import java.util.UUID;

public interface FindVisitOverview {

  VisitOverview findBy(UUID id);

  Collection<WorkingHoursOverview> findMonthlyDoctorVisitDates(String doctorId, LocalDate month);

  Collection<WorkingHoursOverview> findWeeklyDoctorVisitDates(String doctorId, LocalDate month);
}
