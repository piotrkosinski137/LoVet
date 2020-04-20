package com.project.event;

import org.springframework.context.ApplicationEvent;

public class DoctorCreated extends ApplicationEvent {

  private final String id;
  private final String name;
  private final String surname;
  private final String phoneNumber;

  public DoctorCreated(Object source, String id, String name, String surname, String phoneNumber) {
    super(source);
    this.id = id;
    this.name = name;
    this.surname = surname;
    this.phoneNumber = phoneNumber;
  }

  public String getId() {
    return id;
  }

  public String getName() {
    return name;
  }

  public String getSurname() {
    return surname;
  }

  public String getPhoneNumber() {
    return phoneNumber;
  }
}
