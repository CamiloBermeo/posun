package com.posun.application.useCase.BookingUseCase;

import com.posun.application.dto.BookingRequestDTO;
import com.posun.application.dto.BookingResponseDTO;
import com.posun.domain.repository.IBookingRepository;
import com.posun.domain.useCase.ICreateBookingUseCase;
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
