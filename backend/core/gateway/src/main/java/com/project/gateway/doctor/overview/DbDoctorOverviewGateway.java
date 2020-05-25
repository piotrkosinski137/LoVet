package com.project.gateway.doctor.overview;

import com.project.domain.doctor.gateway.overview.DoctorOverview;
import com.project.domain.doctor.gateway.overview.DoctorOverviewGateway;
import java.util.Collection;
import org.springframework.stereotype.Service;

@Service
public class DbDoctorOverviewGateway implements DoctorOverviewGateway {

  private final DoctorOverviewRepository repository;

  public DbDoctorOverviewGateway(DoctorOverviewRepository repository) {
    this.repository = repository;
  }

  @Override
  public Collection<DoctorOverview> findAll() {
    return repository.findAll();
  }
}
