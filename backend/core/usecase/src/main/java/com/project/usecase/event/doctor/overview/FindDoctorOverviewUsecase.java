package com.project.usecase.event.doctor.overview;

import com.project.domain.doctor.gateway.overview.DoctorOverview;
import com.project.domain.doctor.gateway.overview.DoctorOverviewGateway;
import com.project.domain.doctor.gateway.overview.FindDoctorOverview;
import java.util.Collection;
import org.springframework.stereotype.Service;

@Service
public class FindDoctorOverviewUsecase implements FindDoctorOverview {

  private final DoctorOverviewGateway gateway;

  public FindDoctorOverviewUsecase(DoctorOverviewGateway gateway) {
    this.gateway = gateway;
  }

  @Override
  public Collection<DoctorOverview> findAll() {
    return gateway.findAll();
  }
}
