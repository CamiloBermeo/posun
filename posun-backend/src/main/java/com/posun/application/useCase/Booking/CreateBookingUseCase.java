package com.posun.application.useCase.Booking;

import com.posun.application.dto.booking.BookingRequestDTO;
import com.posun.application.dto.booking.BookingResponseDTO;
import com.posun.domain.repository.IBookingRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CreateBookingUseCase{
    private final IBookingRepository clientRepository;

    public BookingResponseDTO createBooking(BookingRequestDTO bookingRequestDTO) {
         clientRepository.createBooking(bookingRequestDTO);
        return null;
    }
}
