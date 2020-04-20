package com.project.auth.domain.usecase;

import com.project.auth.domain.BaseEntity;

public interface LoadBaseEntity {

  BaseEntity findByUsername(String username);

  boolean existsByEmail(String username);
}
