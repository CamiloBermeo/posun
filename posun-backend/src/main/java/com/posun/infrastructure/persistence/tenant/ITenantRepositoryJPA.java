package com.posun.infrastructure.persistence.tenant;

import com.posun.infrastructure.entity.TenantEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ITenantRepositoryJPA extends JpaRepository<TenantEntity,Long> {
}
