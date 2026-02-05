package com.posun.infrastructure.controller;

import com.posun.application.dto.booking.BookingRequestDTO;
import com.posun.application.dto.booking.BookingResponseDTO;
import com.posun.application.useCase.Booking.CreateBookingUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/public/bookings/{tenant}")
@RequiredArgsConstructor
public class BookingController {
    private final CreateBookingUseCase clientService;

    //agendar cita
    @PutMapping("/booking")
    public ResponseEntity<BookingResponseDTO> createBooking(@RequestBody BookingRequestDTO bookingRequestDTO){
            BookingResponseDTO createBooingResponse = clientService.createBooking(bookingRequestDTO);
        return ResponseEntity.ok(createBooingResponse);
    }

}
