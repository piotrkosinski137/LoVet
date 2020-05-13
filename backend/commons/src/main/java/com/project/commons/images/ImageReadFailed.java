package com.project.commons.images;

import com.project.commons.errors.ErrorCode;
import com.project.commons.errors.LoVetException;

public class ImageReadFailed extends LoVetException {

  public ImageReadFailed(ErrorCode errorCode, String details) {
    super(errorCode, details);
  }

  public ImageReadFailed(ErrorCode errorCode) {
    super(errorCode);
  }
}
