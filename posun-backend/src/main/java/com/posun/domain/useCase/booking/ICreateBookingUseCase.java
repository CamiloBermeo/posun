package com.posun.domain.useCase.booking;

import com.posun.application.dto.booking.BookingRequestDTO;
import com.posun.application.dto.booking.BookingResponseDTO;

public interface ICreateBookingUseCase {
     BookingResponseDTO execute(BookingRequestDTO bookingRequestDTO);
}
