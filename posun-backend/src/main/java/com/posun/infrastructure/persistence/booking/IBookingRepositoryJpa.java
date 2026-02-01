package com.posun.infrastructure.persistence.booking;

import com.posun.infrastructure.entity.BookingEntity;
import org.springframework.data.jpa.repository.JpaRepository;


public interface IBookingRepositoryJpa extends JpaRepository<BookingEntity, Long> {
}
