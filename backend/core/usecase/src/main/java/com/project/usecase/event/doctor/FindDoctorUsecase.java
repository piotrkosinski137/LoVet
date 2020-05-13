package com.project.usecase.event.doctor;

import static com.project.commons.errors.ErrorCode.E_DOCTOR_01;

import com.project.domain.doctor.Doctor;
import com.project.domain.doctor.DoctorId;
import com.project.domain.doctor.gateway.DoctorGateway;
import com.project.usecase.event.doctor.exception.DoctorNotFound;
import org.springframework.stereotype.Service;

@Service
public class FindDoctorUsecase {

  private final DoctorGateway doctorGateway;

  public FindDoctorUsecase(DoctorGateway doctorGateway) {
    this.doctorGateway = doctorGateway;
  }

  public Doctor findBy(DoctorId doctorId) {
    return doctorGateway.findBy(doctorId)
        .orElseThrow(() -> new DoctorNotFound(E_DOCTOR_01, doctorId.value()));
  }
}
