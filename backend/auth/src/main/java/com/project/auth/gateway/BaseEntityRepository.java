package com.project.auth.gateway;

import com.project.auth.domain.BaseEntity;
import com.project.auth.domain.EntityId;
import java.util.Optional;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface BaseEntityRepository extends PagingAndSortingRepository<BaseEntity, EntityId> {

  Optional<BaseEntity> findByCredentialsEmail(String email);

  boolean existsByCredentialsEmail(String email);
}
