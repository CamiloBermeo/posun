package com.posun.application.dto.tenant;

import com.posun.application.dto.userAdmin.UserAdminRequestDTO;

public record CreateTenantRequestDTO(
        String businessName,
        TenantConfigDTO tenantConfigDTO,
        UserAdminRequestDTO userAdminRequestDTO
) {
}
