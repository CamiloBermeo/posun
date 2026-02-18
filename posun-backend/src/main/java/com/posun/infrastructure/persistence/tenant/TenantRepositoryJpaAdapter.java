package com.posun.infrastructure.persistence.tenant;

import com.posun.domain.model.Tenant;
import com.posun.domain.repository.ITenantRepository;
import com.posun.infrastructure.entity.TenantEntity;
import com.posun.infrastructure.entity.UserAdminEntity;
import com.posun.infrastructure.mapper.TenantInfraMapper;
import com.posun.infrastructure.mapper.UserAdminInfraMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
@RequiredArgsConstructor
public class TenantRepositoryJpaAdapter implements ITenantRepository {

    private final ITenantRepositoryJpa jpa;

    @Override
    public Tenant createTenant(Tenant tenant) {
        TenantEntity tenantEntity = TenantInfraMapper.toEntity(tenant);

        if (tenantEntity.getTenantConfig() != null) {
            tenantEntity.getTenantConfig().setTenant(tenantEntity); // Vinculamos el hijo con el padre
        }
        List<UserAdminEntity> userAdminEntities = UserAdminInfraMapper.toEntityList(tenant.getUserAdmins(), tenantEntity);
        userAdminEntities.forEach(tenantEntity::addAdmin);
        TenantEntity tenantSaved = jpa.save(tenantEntity);
        return TenantInfraMapper.toDomain(tenantSaved);
    }

    @Override
    public Optional<Tenant> findById(Long id) {
        return jpa.findById(id).map(TenantInfraMapper::toDomain);
    }
}