package com.project.usecase.event.doctor.exception;

import com.project.commons.errors.ErrorCode;
import com.project.commons.errors.LoVetException;

public class DoctorNotFound extends LoVetException {

  public DoctorNotFound(ErrorCode errorCode, String doctorId) {
    super(errorCode, String.format("Doctor with given email %s doesn't exist", doctorId));
  }
}
