package com.posun.infrastructure.persistence.tenant;

import com.posun.infrastructure.entity.TenantEntity;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ITenantRepositoryJpa extends JpaRepository<TenantEntity,Long> {
    @EntityGraph(attributePaths = {"userAdmins"}) // Fuerza la carga de la lista en una sola consulta
    Optional<TenantEntity> findById(Long id);
    Optional<TenantEntity> findTenantByName(String businessName);
}
