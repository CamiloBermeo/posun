package com.posun.application.mapper;

import com.posun.application.dto.tenant.CreateTenantRequestDTO;
import com.posun.application.dto.tenant.CreateTenantResponseDTO;
import com.posun.domain.model.Tenant;
import com.posun.domain.model.TenantConfig;
import com.posun.domain.model.UserAdmin;
import com.posun.domain.valueObject.Tenant.AssignedURLVO;
import com.posun.domain.valueObject.Tenant.BusinessNameVO;
import com.posun.domain.valueObject.Tenant.StatusVO;
import com.posun.domain.valueObject.TenantConfig.*;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class TenantAppMapper {

    public static Tenant toModel(CreateTenantRequestDTO dto, UserAdmin userAdmin) {
        return Tenant.builder()
                .withBusinessName(new BusinessNameVO(dto.businessName()))
                .withAssignedURL(new AssignedURLVO(dto.businessName()))
                .withCreatedAt(LocalDateTime.now())
                .withStatus(new StatusVO(true))
                .withTenantConfig(tenantConfigToModel(dto))
                .withUserAdmin(List.of(userAdmin))
                .build();
    }

    public static CreateTenantResponseDTO toDTO(Tenant tenant) {
        List<UserAdmin> admins = tenant.getUserAdmins();
        return new CreateTenantResponseDTO(
                tenant.getTenantId(),
                tenant.getBusinessName().getValue(),
                tenant.getAssignedURL().getValue(),
                tenant.getStatus().getValue(),
                tenant.getCreatedAt(),
                admins.getFirst().getUserId(),
                admins.getFirst().getEmail().getValue(),
                admins.getFirst().getUserPosition().toString()
        );
    }

    private static TenantConfig tenantConfigToModel(CreateTenantRequestDTO dto) {
        return TenantConfig.builder()
                .withPrimaryColor(new PrimaryColorVO(dto.tenantConfigDTO().primaryColor()))
                .withLogoUrl(new LogoUrlVO(dto.tenantConfigDTO().logoUrl()))
                .withFaviconUrl(new FaviconUrlVO(dto.tenantConfigDTO().faviconUrl()))
                .withWelcomeMessage(new WelcomeMessageVO(dto.tenantConfigDTO().welcomeMessage()))
                .withAllowsCancellation(dto.tenantConfigDTO().allowsCancellation())
                .withCancellationMaxHours(new CancellationMaxHoursVO(dto.tenantConfigDTO().cancellationMaxHours()))
                .build();
    }

}
