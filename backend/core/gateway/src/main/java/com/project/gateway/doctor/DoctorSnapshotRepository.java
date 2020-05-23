package com.project.gateway.doctor;

import com.project.domain.doctor.DoctorSnapshot;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DoctorSnapshotRepository extends JpaRepository<DoctorSnapshot, String> {

}
