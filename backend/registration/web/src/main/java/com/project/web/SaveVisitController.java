package com.project.web;

import com.project.domain.DoctorId;
import com.project.domain.usecase.SaveVisit;
import com.project.web.dto.BookVisitDto;
import com.project.web.dto.SaveBlankVisitsDto;
import com.project.web.dto.VisitMapper;
import java.security.Principal;
import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/visits")
public class SaveVisitController {

  private final SaveVisit saveVisit;
  private final VisitMapper visitMapper;

  public SaveVisitController(SaveVisit saveVisit, VisitMapper visitMapper) {
    this.saveVisit = saveVisit;
    this.visitMapper = visitMapper;
  }

  @Secured("ROLE_DOCTOR")
  @PostMapping("/doctor/new")
  public void saveBlankDoctorVisits(@RequestBody SaveBlankVisitsDto saveBlankVisitsDto,
      Principal principal) {
    saveVisit.saveBlankTo(visitMapper.toVisits(saveBlankVisitsDto),
        DoctorId.create(principal.getName()));
  }

  @PostMapping("/book")
  public void bookVisit(@RequestBody BookVisitDto bookVisitDto) {
    saveVisit.book(visitMapper.toVisit(bookVisitDto));
  }
}
