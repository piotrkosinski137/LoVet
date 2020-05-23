package com.project.domain.gateway.overview;

import java.time.LocalDateTime;
import java.util.Objects;

public class DoctorVisitDatesOverview {

  private LocalDateTime visitDate;

  public DoctorVisitDatesOverview(LocalDateTime visitDate) {
    this.visitDate = visitDate;
  }

  public DoctorVisitDatesOverview() {
  }

  public LocalDateTime getVisitDate() {
    return visitDate;
  }

  public void setVisitDate(LocalDateTime visitDate) {
    this.visitDate = visitDate;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    DoctorVisitDatesOverview that = (DoctorVisitDatesOverview) o;
    return Objects.equals(visitDate, that.visitDate);
  }

  @Override
  public int hashCode() {
    return Objects.hash(visitDate);
  }
}
