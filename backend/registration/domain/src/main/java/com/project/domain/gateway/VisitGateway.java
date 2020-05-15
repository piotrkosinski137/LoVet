package com.project.domain.gateway;

import com.project.domain.Visit;
import com.project.domain.VisitId;
import java.util.Collection;
import java.util.Optional;

public interface VisitGateway {

  Collection<VisitId> saveAll(Collection<Visit> visits);

  Optional<Visit> findBy(VisitId id);
}
