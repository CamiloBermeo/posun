package com.posun.application.dto.tenant;

import java.time.LocalDateTime;

public record CreateTenantResponseDTO(
        Long tenantId,
        String businessName,
        String assignedURL,
        boolean status,
        LocalDateTime createdAt,

        Long adminId,
        String adminEmail,
        String userPosition
) {
}
