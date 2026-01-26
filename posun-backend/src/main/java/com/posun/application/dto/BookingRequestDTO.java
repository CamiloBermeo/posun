package com.posun.application.dto;

import java.time.LocalDateTime;

public record BookingRequestDTO(
        String name,
        String lastName,
        String phoneNumber,
        int serviceId,
        LocalDateTime startDateTime
) {
}
