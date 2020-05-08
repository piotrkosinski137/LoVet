package com.project.images;

import com.project.errors.ErrorCode;
import com.project.errors.LoVetException;

public class ImageSaveFailed extends LoVetException {

  public ImageSaveFailed(ErrorCode errorCode, String details) {
    super(errorCode, details);
  }

  public ImageSaveFailed(ErrorCode errorCode) {
    super(errorCode);
  }
}
