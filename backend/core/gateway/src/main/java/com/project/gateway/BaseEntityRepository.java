package com.project.gateway;

import java.util.Optional;

import org.springframework.data.repository.PagingAndSortingRepository;

import com.project.domain.auth.BaseEntity;
import com.project.domain.auth.EntityId;

public interface BaseEntityRepository extends PagingAndSortingRepository<BaseEntity, EntityId>
{
    Optional<BaseEntity> findByCredentialsUsername(String username);
}
