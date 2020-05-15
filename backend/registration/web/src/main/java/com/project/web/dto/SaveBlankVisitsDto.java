package com.project.web.dto;

import java.time.LocalDateTime;
import java.util.Collection;
import java.util.UUID;

public class SaveBlankVisitsDto {
  private Collection<LocalDateTime> visits;

  public Collection<LocalDateTime> getVisits() {
    return visits;
  }

  public void setVisits(Collection<LocalDateTime> visits) {
    this.visits = visits;
  }
}
