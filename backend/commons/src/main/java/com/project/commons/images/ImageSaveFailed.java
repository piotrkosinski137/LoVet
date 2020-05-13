package com.project.commons.images;

import com.project.commons.errors.LoVetException;
import com.project.commons.errors.ErrorCode;

public class ImageSaveFailed extends LoVetException {

  public ImageSaveFailed(ErrorCode errorCode, String details) {
    super(errorCode, details);
  }

  public ImageSaveFailed(ErrorCode errorCode) {
    super(errorCode);
  }
}
