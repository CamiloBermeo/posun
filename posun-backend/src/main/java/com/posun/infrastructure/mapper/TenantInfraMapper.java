package com.posun.infrastructure.mapper;

import com.posun.domain.model.Tenant;
import com.posun.domain.valueObject.Tenant.AssignedURLVO;
import com.posun.domain.valueObject.Tenant.BusinessNameVO;
import com.posun.domain.valueObject.Tenant.StatusVO;
import com.posun.infrastructure.entity.TenantConfigEntity;
import com.posun.infrastructure.entity.TenantEntity;

public class TenantInfraMapper {

    public static TenantEntity toEntity(Tenant tenant, TenantConfigEntity tenantConfigEntity) {

        return TenantEntity.builder()
                .businessName(tenant.getBusinessName().getBusinessName())
                .createdAt(tenant.getCreatedAt())
                .assignedURL(tenant.getAssignedURL().getAssignedURL())
                .tenantConfig(tenantConfigEntity)
                .build();

    }

    public static Tenant toDomain(TenantEntity tenantEntity) {
        Tenant.TenantBuilder TenantBuilder = Tenant.builder()
                .withTenantId(tenantEntity.getId())
                .withBusinessName(new BusinessNameVO(tenantEntity.getBusinessName()))
                .withAssignedURL(new AssignedURLVO(tenantEntity.getAssignedURL()))
                .withStatus(new StatusVO(tenantEntity.isStatus()))
                .build().toBuilder();
        return TenantBuilder.build();
    }

    public static TenantConfigEntity tenantConfigToEntity(Tenant tenant) {
        return TenantConfigEntity.builder()
                .primaryColor(tenant.getTenantConfig().getPrimaryColor().getPrimaryColor())
                .logoUrl(tenant.getTenantConfig().getLogoUrl().getLogoUrl())
                .faviconUrl(tenant.getTenantConfig().getFaviconUrl().getFaviconUrl())
                .welcomeMessage(tenant.getTenantConfig().getWelcomeMessage().getWelcomeMessage())
                .cancelationMaxHours(tenant.getTenantConfig().getCancelationMaxHours().getCancelationMaxHours())
                .allowsCancelation(tenant.getTenantConfig().isAllowsCancelation())
                .build();
    }
}
