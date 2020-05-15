package com.project.domain.usecase;

import com.project.domain.DoctorId;
import com.project.domain.Visit;
import java.util.Collection;

public interface SaveVisit {

  void saveBlankTo(Collection<Visit> visits, DoctorId doctorId);

  void book(Visit visit);
}
