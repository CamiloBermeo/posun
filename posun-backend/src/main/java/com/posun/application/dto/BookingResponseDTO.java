package com.posun.application.dto;

public record BookingResponseDTO(
        String name,
        String lastName,
        String electedEmployed,
        String bookingState
) {
}
