package com.project.gateway.doctor;

import com.project.domain.doctor.Doctor;
import com.project.domain.doctor.DoctorId;
import com.project.domain.doctor.gateway.DoctorGateway;
import java.util.Optional;
import org.springframework.stereotype.Service;

@Service
public class DbDoctorGateway implements DoctorGateway {

  private final DoctorSnapshotRepository doctorSnapshotRepository;

  public DbDoctorGateway(DoctorSnapshotRepository doctorSnapshotRepository) {
    this.doctorSnapshotRepository = doctorSnapshotRepository;
  }

  @Override
  public Optional<Doctor> findBy(DoctorId doctorId) {
    return doctorSnapshotRepository.findById(doctorId.value()).map(Doctor::fromSnapshot);
  }

  @Override
  public void save(Doctor doctor) {
    doctorSnapshotRepository.save(doctor.toSnapshot());
  }
}
