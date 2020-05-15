package com.project.event;

import java.util.Collection;
import java.util.UUID;
import org.springframework.context.ApplicationEvent;

public class BlankVisitsCreated extends ApplicationEvent {

  private String doctorId;
  private Collection<UUID> visitIds;

  public BlankVisitsCreated(Object source, Collection<UUID> visitIds, String doctorId) {
    super(source);
    this.visitIds = visitIds;
    this.doctorId = doctorId;
  }

  public Collection<UUID> getVisitIds() {
    return visitIds;
  }

  public String getDoctorId() {
    return doctorId;
  }
}
