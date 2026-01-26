package com.posun.domain.useCase;

import com.posun.application.dto.BookingRequestDTO;

public interface ICreateBookingUseCase {
     void execute(BookingRequestDTO bookingRequestDTO);
}
