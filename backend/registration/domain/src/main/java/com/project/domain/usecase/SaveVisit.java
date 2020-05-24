package com.project.domain.usecase;

import com.project.domain.DoctorId;
import com.project.domain.Visit;
import java.time.LocalDate;
import java.util.Collection;

public interface SaveVisit {

  void saveWorkingHoursDay(Collection<Visit> visits, DoctorId doctorId, LocalDate day);

  void book(Visit visit);
}
