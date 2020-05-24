package com.project.domain.gateway;

import com.project.domain.DoctorId;
import com.project.domain.Visit;
import com.project.domain.VisitId;
import java.time.LocalDate;
import java.util.Collection;
import java.util.Optional;

public interface VisitGateway {

  Collection<VisitId> saveAll(Collection<Visit> visits);

  void deleteAllBy(Collection<VisitId> visitId);

  Optional<Visit> findBy(VisitId id);

  Collection<Visit> findBy(DoctorId doctorId, LocalDate day);
}
