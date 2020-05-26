package com.project.web.overview;

import com.project.commons.mapper.LocalDateMapper;
import com.project.domain.gateway.overview.FindVisitOverview;
import com.project.domain.gateway.overview.WorkingHoursOverview;
import java.security.Principal;
import java.util.Collection;
import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/visits")
public class FindVisitController {

  private final FindVisitOverview findVisitOverview;
  private final LocalDateMapper mapper;

  public FindVisitController(FindVisitOverview findVisitOverview, LocalDateMapper mapper) {
    this.findVisitOverview = findVisitOverview;
    this.mapper = mapper;
  }

  @Secured("ROLE_DOCTOR")
  @GetMapping("/doctor")
  public Collection<WorkingHoursOverview> findDoctorVisitDates(Principal principal,
      @RequestParam String monthDate) {
    return findVisitOverview.findMonthlyDoctorVisitDates(principal.getName(), mapper.mapFrom(monthDate));
  }

  @GetMapping("/doctor/{id}")
  public Collection<WorkingHoursOverview> findWeeklyDoctorVisits(@PathVariable(name= "id") String doctorId,
      @RequestParam String startDate) {
    return findVisitOverview.findWeeklyDoctorVisitDates(doctorId, mapper.mapFrom(startDate));
  }
}
