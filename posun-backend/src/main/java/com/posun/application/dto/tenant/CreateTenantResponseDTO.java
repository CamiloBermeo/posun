package com.posun.application.dto.tenant;

import java.time.LocalDateTime;

public record CreateTenantResponseDTO(
        Long id,
        String businessName,
        String AssignedURL,
        LocalDateTime createdAt,
        boolean status
) {
}
