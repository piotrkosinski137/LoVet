package com.project.web.doctor;

import com.project.domain.doctor.gateway.overview.DoctorOverview;
import com.project.domain.doctor.gateway.overview.FindDoctorOverview;
import java.util.Collection;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/doctors/overview")
public class DoctorQueryController {

  private final FindDoctorOverview findDoctorOverview;

  public DoctorQueryController(FindDoctorOverview findDoctorOverview) {
    this.findDoctorOverview = findDoctorOverview;
  }

  @GetMapping()
  public Collection<DoctorOverview> findAll() {
    return findDoctorOverview.findAll();
  }
}
