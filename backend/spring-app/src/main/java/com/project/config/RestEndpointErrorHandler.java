package com.project.config;

import static com.project.errors.ErrorCode.E_DEFAULT;

import com.project.errors.LoVetException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

@ControllerAdvice
public class RestEndpointErrorHandler {

  Logger logger = LoggerFactory.getLogger(RestEndpointErrorHandler.class);

  @ExceptionHandler(value = {LoVetException.class})
  protected ResponseEntity<ErrorMessage> handleException(LoVetException ex, WebRequest request) {
    logger.info(ex.getMessage());
    return ResponseEntity.badRequest().body(new ErrorMessage(ex.getErrorCode().name()));
  }

  @ExceptionHandler(value = {RuntimeException.class})
  protected ResponseEntity<ErrorMessage> handleException(RuntimeException ex, WebRequest request) {
    logger.info(ex.getMessage());
    return ResponseEntity.badRequest().body(new ErrorMessage(E_DEFAULT.name()));
  }
}
