package com.posun.application.useCase.Booking;

import com.posun.application.dto.booking.BookingRequestDTO;
import com.posun.application.dto.booking.BookingResponseDTO;
import com.posun.domain.repository.IBookingRepository;
import com.posun.domain.useCase.booking.ICreateBookingUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CreateBookingUseCaseImpl implements ICreateBookingUseCase {
    private final IBookingRepository clientRepository;

    @Override
    public BookingResponseDTO execute(BookingRequestDTO bookingRequestDTO) {
         clientRepository.createBooking(bookingRequestDTO);
        return null;
    }
}
