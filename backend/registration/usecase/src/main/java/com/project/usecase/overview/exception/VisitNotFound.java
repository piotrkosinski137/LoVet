package com.project.usecase.overview.exception;

import com.project.commons.errors.ErrorCode;
import com.project.commons.errors.LoVetException;

public class VisitNotFound extends LoVetException {

  public VisitNotFound(ErrorCode errorCode, String id) {
    super(errorCode, String.format("Visit with id %s not found", id));
  }
}
