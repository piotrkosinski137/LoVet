package com.project.web.dto;

import com.project.domain.DoctorId;
import com.project.domain.PetId;
import com.project.domain.Visit;
import com.project.domain.VisitId;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Collection;
import java.util.stream.Collectors;
import org.springframework.stereotype.Component;

@Component
public class VisitMapper {

  public Collection<Visit> toVisits(SaveBlankVisitsDto dto) {
    return dto.getVisits().stream().map(visitDto -> new Visit(convertToDate(visitDto))).collect(Collectors.toSet());
  }

  public Visit toVisit(BookVisitDto dto) {
    return new Visit(VisitId.create(dto.getVisitId()), DoctorId.create(dto.getDoctorId()), PetId.create(dto.getPetId()),
        dto.getVisitDate());
  }

  public LocalDateTime convertToDate(String date) {
    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'");
    return LocalDateTime.parse(date, formatter).plusHours(2);
  }
}
