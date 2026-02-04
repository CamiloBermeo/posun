package com.posun.application.dto.tenant;

public record TenantConfigDTO(
        String primaryColor,
        String logoUrl,
        String faviconUrl,
        String welcomeMessage,
        boolean allowsCancellation,
        Integer cancellationMaxHours
) {
}
