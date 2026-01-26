package com.posun.application.useCase.clientUseCase;

import com.posun.application.dto.BookingRequestDTO;
import com.posun.domain.repository.IClientRepository;
import com.posun.domain.useCase.ICreateBookingUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CreateBookingUseCaseImpl implements ICreateBookingUseCase {
    private final IClientRepository  clientRepository;

    @Override
    public void execute(BookingRequestDTO bookingRequestDTO) {
        clientRepository.createBooking(bookingRequestDTO);
    }
}
