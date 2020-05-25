package com.project.gateway.doctor.overview;

import com.project.domain.doctor.gateway.overview.DoctorOverview;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DoctorOverviewRepository extends JpaRepository<DoctorOverview, String> {
}
