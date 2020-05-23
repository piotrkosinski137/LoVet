package com.project.web.dto;

import java.util.Collection;

public class SaveBlankVisitsDto {

  private Collection<String> visits;

  public Collection<String> getVisits() {
    return visits;
  }

  public void setVisits(Collection<String> visits) {
    this.visits = visits;
  }
}
