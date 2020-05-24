package com.project.gateway;

import com.project.domain.VisitSnapshot;
import java.util.Collection;
import java.util.List;
import java.util.UUID;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface VisitRepository extends JpaRepository<VisitSnapshot, UUID> {

  @Query("select v from VisitSnapshot v where v.doctorId=?1 and year(v.visitDate) = ?2 and month(v.visitDate) = ?3 and day(v.visitDate) = ?4")
  Collection<VisitSnapshot> findByDoctorAndDay(String doctorId, int year, int month, int day);

  void deleteByIdIn(List<UUID> ids);
}
