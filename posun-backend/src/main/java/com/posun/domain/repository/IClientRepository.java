package com.posun.domain.repository;

import com.posun.application.dto.BookingRequestDTO;

public interface IClientRepository {
    void createBooking(BookingRequestDTO bookingRequestDTO);
}
