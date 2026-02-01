package com.posun.infrastructure.persistence.booking;

import com.posun.application.dto.booking.BookingRequestDTO;
import com.posun.domain.model.Booking;
import com.posun.domain.repository.IBookingRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

@Repository
@RequiredArgsConstructor
public class BookingRepositoryJpaAdapter implements IBookingRepository {

    private final IBookingRepositoryJpa jpa;

    @Override
    public Booking createBooking(BookingRequestDTO bookingRequestDTO) {



        return null;
    }
}
