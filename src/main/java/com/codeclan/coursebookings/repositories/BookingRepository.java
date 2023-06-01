package com.codeclan.coursebookings.repositories;

import com.codeclan.coursebookings.models.Booking;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookingRepository extends JpaRepository<Booking, Long> {
}
