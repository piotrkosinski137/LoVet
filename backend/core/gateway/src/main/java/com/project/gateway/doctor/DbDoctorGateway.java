package com.project.gateway.doctor;

import com.project.domain.doctor.Doctor;
import com.project.domain.doctor.DoctorId;
import com.project.domain.doctor.gateway.DoctorGateway;
import java.util.Optional;
import org.springframework.stereotype.Service;

@Service
public class DbDoctorGateway implements DoctorGateway {

  private final DoctorRepository doctorRepository;

  public DbDoctorGateway(DoctorRepository doctorRepository) {
    this.doctorRepository = doctorRepository;
  }

  @Override
  public Optional<Doctor> findBy(DoctorId doctorId) {
    return doctorRepository.findById(doctorId.value()).map(Doctor::fromSnapshot);
  }
}
