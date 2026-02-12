package com.posun.infrastructure.mapper;

import com.posun.domain.model.Tenant;
import com.posun.domain.valueObject.Tenant.AssignedURLVO;
import com.posun.domain.valueObject.Tenant.BusinessNameVO;
import com.posun.domain.valueObject.Tenant.StatusVO;
import com.posun.infrastructure.entity.TenantConfigEntity;
import com.posun.infrastructure.entity.TenantEntity;
import com.posun.infrastructure.entity.UserAdminEntity;

import java.util.List;

public class TenantInfraMapper {

    public static TenantEntity toEntity(Tenant tenant) {

        return TenantEntity.builder()
                .businessName(tenant.getBusinessName().getValue())
                .createdAt(tenant.getCreatedAt())
                .status(tenant.getStatus().getValue())
                .assignedURL(tenant.getAssignedURL().getValue())
                .tenantConfig(tenantConfigToEntity(tenant))
                .build();

    }

    public static Tenant toDomain(TenantEntity tenantEntity) {
        Tenant.TenantBuilder TenantBuilder = Tenant.builder()
                .withTenantId(tenantEntity.getId())
                .withBusinessName(new BusinessNameVO(tenantEntity.getBusinessName()))
                .withAssignedURL(new AssignedURLVO(tenantEntity.getAssignedURL()))
                .withCreatedAt(tenantEntity.getCreatedAt())
                .withStatus(new StatusVO(tenantEntity.isStatus()))
                .withUserAdmin(tenantEntity.getUserAdmins().stream()
                        .map())
                .build().toBuilder();
        return TenantBuilder.build();
    }

    public static TenantConfigEntity tenantConfigToEntity(Tenant tenant) {
        return TenantConfigEntity.builder()
                .primaryColor(tenant.getTenantConfig().getPrimaryColor().getValue())
                .logoUrl(tenant.getTenantConfig().getLogoUrl().getValue())
                .faviconUrl(tenant.getTenantConfig().getFaviconUrl().getValue())
                .welcomeMessage(tenant.getTenantConfig().getWelcomeMessage().getValue())
                .cancellationMaxHours(tenant.getTenantConfig().getCancellationMaxHours().getValue())
                .allowsCancellation(tenant.getTenantConfig().isAllowsCancellation())
                .build();
    }
}
