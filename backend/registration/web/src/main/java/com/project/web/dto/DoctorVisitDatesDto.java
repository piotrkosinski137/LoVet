package com.project.web.dto;

import com.project.domain.gateway.overview.DoctorVisitDatesOverview;
import java.time.LocalDateTime;
import java.util.Collection;
import java.util.Set;
import java.util.stream.Collectors;

public class DoctorVisitDatesDto {
  private Collection<LocalDateTime> workingHours;

  public DoctorVisitDatesDto(Collection<DoctorVisitDatesOverview> visitDates) {
    this.workingHours = mapToWorkingHours(visitDates);
  }

  private Set<LocalDateTime> mapToWorkingHours(Collection<DoctorVisitDatesOverview> visitDates) {
    return visitDates.stream()
        .map(DoctorVisitDatesOverview::getVisitDate)
        .collect(Collectors.toSet());
  }

  public Collection<LocalDateTime> getWorkingHours() {
    return workingHours;
  }

  public void setWorkingHours(Collection<LocalDateTime> workingHours) {
    this.workingHours = workingHours;
  }
}
