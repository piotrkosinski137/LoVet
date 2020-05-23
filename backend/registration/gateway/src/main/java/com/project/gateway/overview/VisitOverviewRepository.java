package com.project.gateway.overview;

import com.project.domain.gateway.overview.DoctorVisitDatesOverview;
import com.project.domain.gateway.overview.VisitOverview;
import java.util.Collection;
import java.util.UUID;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface VisitOverviewRepository extends JpaRepository<VisitOverview, UUID> {

  @Query("select new com.project.domain.gateway.overview.DoctorVisitDatesOverview(v.visitDate) from VisitOverview v where v.doctorId=?1 and year(v.visitDate) = ?2 and month(v.visitDate) = ?3")
  Collection<DoctorVisitDatesOverview> findByDoctorAndDate(String doctorId, int year, int month);
}
