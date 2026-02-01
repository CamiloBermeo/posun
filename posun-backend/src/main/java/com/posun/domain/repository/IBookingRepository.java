package com.posun.domain.repository;

import com.posun.application.dto.booking.BookingRequestDTO;
import com.posun.domain.model.Booking;

public interface IBookingRepository {
    Booking createBooking(BookingRequestDTO bookingRequestDTO);
}
