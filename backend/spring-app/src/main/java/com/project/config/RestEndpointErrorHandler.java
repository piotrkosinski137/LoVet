package com.project.config;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

@ControllerAdvice
public class RestEndpointErrorHandler {

  @ExceptionHandler(value = {RuntimeException.class})
  protected ResponseEntity<ErrorMessage> handleException(RuntimeException ex, WebRequest request) {
    return ResponseEntity.badRequest().body(new ErrorMessage(ex.getMessage()));
  }
}

class ErrorMessage {

  private String details;

  private ErrorMessage() {
  }

  public ErrorMessage(String details) {
    this.details = details;
  }

  public String getDetails() {
    return details;
  }

  public void setDetails(String details) {
    this.details = details;
  }
}
