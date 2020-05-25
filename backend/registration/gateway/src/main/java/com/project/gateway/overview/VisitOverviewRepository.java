package com.project.gateway.overview;

import com.project.domain.gateway.overview.WorkingHoursOverview;
import com.project.domain.gateway.overview.VisitOverview;
import java.util.Collection;
import java.util.UUID;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface VisitOverviewRepository extends JpaRepository<VisitOverview, UUID> {

  @Query("select new com.project.domain.gateway.overview.WorkingHoursOverview(v.visitDate, v.isBooked) from VisitOverview v where v.doctorId=?1 and year(v.visitDate) = ?2 and month(v.visitDate) = ?3")
  Collection<WorkingHoursOverview> findByDoctorAndDate(String doctorId, int year, int month);
}
