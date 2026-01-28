package com.posun.application.dto;

import java.time.LocalDate;
import java.time.LocalDateTime;

public record BookingRequestDTO(
        String name,
        String lastName,
        String electedEmployee,
        String phoneNumber,
        int serviceId,
        LocalDate startDateTime,
        LocalDate endDateTime
) {
}
