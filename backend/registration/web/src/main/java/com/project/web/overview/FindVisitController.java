package com.project.web.overview;

import com.project.commons.mapper.LocalDateMapper;
import com.project.domain.gateway.overview.FindVisitOverview;
import com.project.web.dto.DoctorVisitDatesDto;
import java.security.Principal;
import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.GetMapping;
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
  public DoctorVisitDatesDto findDoctorVisitDates(Principal principal, @RequestParam String monthDate) {
    return new DoctorVisitDatesDto(findVisitOverview.findDoctorVisitDatesBy(principal.getName(), mapper.mapFrom(monthDate)));
  }
}
