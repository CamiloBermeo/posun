package com.posun.infrastructure.persistence.tenant;

import com.posun.infrastructure.entity.TenantEntity;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface ITenantRepositoryJpa extends JpaRepository<TenantEntity,Long> {
    @EntityGraph(attributePaths = {"userAdmins"}) // Fuerza la carga de la lista en una sola consulta
    Optional<TenantEntity> findById(Long id);
    @Query("SELECT t FROM TenantEntity t LEFT JOIN FETCH t.userAdmins WHERE t.businessName = :businessName")
    Optional<TenantEntity> findTenantByBusinessName(String businessName);
}
