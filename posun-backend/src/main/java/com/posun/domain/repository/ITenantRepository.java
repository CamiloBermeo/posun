package com.posun.domain.repository;

import com.posun.domain.model.Tenant;

import java.util.Optional;

public interface ITenantRepository {

    Tenant createTenant(Tenant tenant);
    Optional<Tenant> findById(Long id);
    Optional<Tenant> findByName(String businessName);

}
