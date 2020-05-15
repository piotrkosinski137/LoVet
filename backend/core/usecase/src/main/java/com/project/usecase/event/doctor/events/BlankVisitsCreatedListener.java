package com.project.usecase.event.doctor.events;

import com.project.domain.doctor.Doctor;
import com.project.domain.doctor.DoctorId;
import com.project.domain.doctor.VisitId;
import com.project.domain.doctor.usecase.FindDoctor;
import com.project.domain.doctor.usecase.SaveDoctor;
import com.project.event.BlankVisitsCreated;
import java.util.stream.Collectors;
import javax.transaction.Transactional;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Service;

@Service
public class BlankVisitsCreatedListener {

  private final FindDoctor findDoctor;
  private final SaveDoctor saveDoctor;

  public BlankVisitsCreatedListener(FindDoctor findDoctor,
      SaveDoctor saveDoctor) {
    this.findDoctor = findDoctor;
    this.saveDoctor = saveDoctor;
  }

  @EventListener
  @Transactional
  public void addBlankVisits(BlankVisitsCreated event) {
    Doctor doctor = findDoctor.findBy(DoctorId.create(event.getDoctorId()));
    doctor.addVisits(event.getVisitIds().stream()
    .map(VisitId::create)
    .collect(Collectors.toSet()));
    saveDoctor.save(doctor);
  }
}
