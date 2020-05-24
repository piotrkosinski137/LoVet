package com.project.web.dto;

import java.util.Collection;
import javax.validation.constraints.NotNull;

public class SaveBlankVisitsDto {

  @NotNull
  private Collection<String> visits;
  @NotNull
  private String day;

  public Collection<String> getVisits() {
    return visits;
  }

  public void setVisits(Collection<String> visits) {
    this.visits = visits;
  }

  public String getDay() {
    return day;
  }

  public void setDay(String day) {
    this.day = day;
  }
}
