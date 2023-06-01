package com.codeclan.coursebookings.controllers;

import com.codeclan.coursebookings.models.Booking;
import com.codeclan.coursebookings.repositories.BookingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class BookingController {


        @Autowired
        BookingRepository bookingRepository;

        @GetMapping(value = "/bookings")
        public ResponseEntity<List<Booking>> getAllBookings(){
            return new ResponseEntity<>(bookingRepository.findAll(), HttpStatus.OK);
        }

        @GetMapping(value = "/bookings/{id}")
        public ResponseEntity getBooking(@PathVariable Long id){
            return new ResponseEntity(bookingRepository.findById(id), HttpStatus.OK);
        }

        @PostMapping(value = "/bookings")
        public ResponseEntity<Booking> postPirate(@RequestBody Booking booking){
            bookingRepository.save(booking);
            return new ResponseEntity<>(booking, HttpStatus.CREATED);
        }
    }

