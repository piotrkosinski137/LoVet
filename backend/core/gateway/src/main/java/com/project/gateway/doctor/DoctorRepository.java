package com.project.gateway.doctor;

import com.project.domain.doctor.DoctorSnapshot;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DoctorRepository extends JpaRepository<DoctorSnapshot, String> {

}
