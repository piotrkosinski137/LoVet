package com.project.auth.usecase;

import com.project.auth.domain.BaseEntity;

public interface LoadBaseEntity {

  BaseEntity loadByUsername(String username);
}
