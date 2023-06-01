package com.codeclan.coursebookings.controllers;

import com.codeclan.coursebookings.models.Booking;
import com.codeclan.coursebookings.models.Course;
import com.codeclan.coursebookings.models.Customer;
import com.codeclan.coursebookings.repositories.BookingRepository;
import com.codeclan.coursebookings.repositories.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class CustomerController {

    @Autowired
    CustomerRepository customerRepository;

    @GetMapping(value = "/customers")
    public ResponseEntity<List<Customer>> getAllCustomerOrByCourse(
        @RequestParam(name = "course", required = false) String course){
    if(course != null){
        return new ResponseEntity<>(customerRepository.findByBookingsCourseName(course), HttpStatus.OK);
    }
        return new ResponseEntity<>(customerRepository.findAll(), HttpStatus.OK);
    }


    @GetMapping(value = "/customers/{id}")
    public ResponseEntity getCustomer(@PathVariable Long id){
        return new ResponseEntity(customerRepository.findById(id), HttpStatus.OK);
    }

    @PostMapping(value = "/customers")
    public ResponseEntity<Customer> postCustomer(@RequestBody Customer customer){
        customerRepository.save(customer);
        return new ResponseEntity<>(customer, HttpStatus.CREATED);
    }
}
