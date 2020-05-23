package com.project.commons.mapper;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import org.springframework.stereotype.Component;

@Component
public class LocalDateMapper {

  public LocalDate mapFrom(String date) {
    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("d.MM.yyyy");
    return LocalDate.parse(date, formatter);
  }
}
