package com.project.domain.gateway.overview;

import java.time.LocalDateTime;
import java.util.Objects;

public class WorkingHoursOverview {

  private String visitDate;
  private boolean isBooked;

  public WorkingHoursOverview(LocalDateTime visitDate, boolean isBooked) {
    this.visitDate = visitDate.toString();
    this.isBooked = isBooked;
  }

  public WorkingHoursOverview() {
  }

  public String getVisitDate() {
    return visitDate;
  }

  public void setVisitDate(String visitDate) {
    this.visitDate = visitDate;
  }

  public boolean isBooked() {
    return isBooked;
  }

  public void setBooked(boolean booked) {
    isBooked = booked;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    WorkingHoursOverview that = (WorkingHoursOverview) o;
    return Objects.equals(visitDate, that.visitDate);
  }

  @Override
  public int hashCode() {
    return Objects.hash(visitDate);
  }
}
