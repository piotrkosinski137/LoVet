package com.project.usecase.event.doctor;

import com.project.domain.doctor.Doctor;
import com.project.domain.doctor.gateway.DoctorGateway;
import com.project.domain.doctor.usecase.SaveDoctor;
import org.springframework.stereotype.Service;

@Service
public class SaveDoctorUsecase implements SaveDoctor {

  private final DoctorGateway doctorGateway;

  public SaveDoctorUsecase(DoctorGateway doctorGateway) {
    this.doctorGateway = doctorGateway;
  }

  @Override
  public void save(Doctor doctor) {
    doctorGateway.save(doctor);
  }
}
