package com.posun.application.dto.booking;

import java.time.LocalDate;

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
