package com.posun.application.dto.tenant;

import com.posun.application.dto.userAdmin.UserRequestDTO;

public record CreateTenantRequestDTO(
        String businessName,
        TenantConfigDTO tenantConfigDTO,
        UserRequestDTO userAdminRequestDTO
) {
}
