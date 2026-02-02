package com.posun.application.mapper;

import com.posun.application.dto.tenant.CreateTenantRequestDTO;
import com.posun.application.dto.tenant.CreateTenantResponseDTO;
import com.posun.domain.model.Tenant;
import com.posun.domain.model.TenantConfig;
import com.posun.domain.valueObject.Tenant.AssignedURLVO;
import com.posun.domain.valueObject.Tenant.BusinessNameVO;
import com.posun.domain.valueObject.Tenant.StatusVO;
import com.posun.domain.valueObject.TenantConfig.*;

import java.time.LocalDateTime;

public class TenantAppMapper {

    public static Tenant toModel(CreateTenantRequestDTO dto) {


        return Tenant.builder()
                .withBusinessName(new BusinessNameVO(dto.businessName()))
                .withAssignedURL(new AssignedURLVO(dto.businessName()))
                .withCreatedAt(LocalDateTime.now())
                .withStatus(new StatusVO(true))
                .withTenantConfig(tenantConfigToModel(dto))
                .build();
    }

    public static CreateTenantResponseDTO toDTO(Tenant tenant) {
        return new CreateTenantResponseDTO(
                tenant.getTenantId(),
                tenant.getBusinessName().getBusinessName(),
                tenant.getAssignedURL().getAssignedURL(),
                tenant.getCreatedAt(),
                tenant.getStatus().getStatus()
        );
    }

    public static TenantConfig tenantConfigToModel(CreateTenantRequestDTO dto){
        return TenantConfig.builder()
                .withPrimaryColor(new PrimaryColorVO(dto.tenantConfigDTO().primaryColor()))
                .withLogoUrl(new LogoUrlVO(dto.tenantConfigDTO().logoUrl()))
                .withFaviconUrl(new FaviconUrlVO(dto.tenantConfigDTO().faviconUrl()))
                .withWelcomeMessage(new WelcomeMessageVO(dto.tenantConfigDTO().welcomeMessage()))
                .withAllowsCancelation(dto.tenantConfigDTO().allowsCancelation())
                .withCancelationMaxHours(new CancelationMaxHoursVO(dto.tenantConfigDTO().cancelationMaxHours()))
                .build();
    }

}
