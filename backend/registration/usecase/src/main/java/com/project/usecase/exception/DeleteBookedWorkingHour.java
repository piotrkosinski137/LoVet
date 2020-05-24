package com.project.usecase.exception;

import com.project.commons.errors.ErrorCode;
import com.project.commons.errors.LoVetException;

public class DeleteBookedWorkingHour extends LoVetException {

  public DeleteBookedWorkingHour(ErrorCode errorCode) {
    super(errorCode);
  }
}
