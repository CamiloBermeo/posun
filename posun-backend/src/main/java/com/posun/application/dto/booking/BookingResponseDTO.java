package com.posun.application.dto.booking;

public record BookingResponseDTO(
        String name,
        String lastName,
        String electedEmployed,
        String bookingState
) {
}
