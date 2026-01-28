package com.posun.domain.useCase;

import com.posun.application.dto.BookingRequestDTO;
import com.posun.application.dto.BookingResponseDTO;

public interface ICreateBookingUseCase {
     BookingResponseDTO execute(BookingRequestDTO bookingRequestDTO);
}
