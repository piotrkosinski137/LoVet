package com.project.domain.doctor.gateway;

import com.project.domain.doctor.Doctor;
import com.project.domain.doctor.DoctorId;
import java.util.Optional;

public interface DoctorGateway {

  Optional<Doctor> findBy(DoctorId doctorId);

  void save(Doctor doctor);
}
