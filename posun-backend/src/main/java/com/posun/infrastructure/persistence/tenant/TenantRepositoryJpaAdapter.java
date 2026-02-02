package com.posun.infrastructure.persistence.tenant;

import com.posun.domain.model.Tenant;
import com.posun.domain.repository.ITenantRepository;
import com.posun.infrastructure.entity.TenantConfigEntity;
import com.posun.infrastructure.entity.TenantEntity;
import com.posun.infrastructure.mapper.TenantInfraMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

@Repository
@RequiredArgsConstructor
public class TenantRepositoryJpaAdapter implements ITenantRepository {

    private final ITenantRepositoryJPA jpa;

    @Override
    public Tenant createTenant(Tenant tenant) {
        TenantEntity tenantEntity = TenantInfraMapper.toEntity(tenant);
        if (tenantEntity.getTenantConfig() != null) {
            tenantEntity.getTenantConfig().setTenant(tenantEntity); // Vinculamos el hijo con el padre
        }
        TenantEntity tenantSaved = jpa.save(tenantEntity);
        return TenantInfraMapper.toDomain(tenantSaved);
    }
}
