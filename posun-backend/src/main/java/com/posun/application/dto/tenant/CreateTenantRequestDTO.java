package com.posun.application.dto.tenant;

public record CreateTenantRequestDTO(
        String businessName,
        TenantConfigDTO tenantConfigDTO
) {
}
