package com.project.web.dto;

import com.project.domain.gateway.overview.WorkingHoursOverview;
import java.time.LocalDateTime;
import java.util.Collection;
import java.util.Set;
import java.util.stream.Collectors;

public class DoctorVisitDatesDto {
  private Collection<WorkingHoursOverview> workingHours;

  public DoctorVisitDatesDto(Collection<WorkingHoursOverview> workingHours) {
    this.workingHours = workingHours;
  }

  public Collection<WorkingHoursOverview> getWorkingHours() {
    return workingHours;
  }

  public void setWorkingHours(Collection<WorkingHoursOverview> workingHours) {
    this.workingHours = workingHours;
  }
}
