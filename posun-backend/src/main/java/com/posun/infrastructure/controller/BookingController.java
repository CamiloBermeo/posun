package com.posun.infrastructure.controller;

import com.posun.application.dto.booking.BookingRequestDTO;
import com.posun.application.dto.booking.BookingResponseDTO;
import com.posun.domain.useCase.booking.ICreateBookingUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/public/bookings/{tenant}")
@RequiredArgsConstructor
public class BookingController {
    private final ICreateBookingUseCase clientService;

    //agendar cita
    @PutMapping("/booking")
    public ResponseEntity<BookingResponseDTO> createBooking(@RequestBody BookingRequestDTO bookingRequestDTO){
            BookingResponseDTO createBooingResponse = clientService.execute(bookingRequestDTO);
        return ResponseEntity.ok(createBooingResponse);
    }

}
