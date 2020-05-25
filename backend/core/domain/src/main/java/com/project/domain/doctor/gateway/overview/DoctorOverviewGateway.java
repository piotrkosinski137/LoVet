package com.project.domain.doctor.gateway.overview;

import java.util.Collection;

public interface DoctorOverviewGateway {

  Collection<DoctorOverview> findAll();
}
