package com.project.auth.domain.usecase;

import com.project.auth.domain.BaseEntity;
import com.project.auth.domain.EntityId;

public interface SaveBaseEntity {

  EntityId save(BaseEntity baseEntity);
}
