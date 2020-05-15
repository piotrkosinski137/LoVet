package com.project.domain.doctor.usecase;

import com.project.domain.doctor.Doctor;
import com.project.domain.doctor.DoctorId;
import java.util.Collection;

public interface FindDoctor {

  Doctor findBy(DoctorId doctorId);
}
