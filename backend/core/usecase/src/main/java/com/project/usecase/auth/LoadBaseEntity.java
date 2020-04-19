package com.project.usecase.auth;

import com.project.domain.auth.BaseEntity;

public interface LoadBaseEntity {

  BaseEntity loadByUsername(String username);
}
