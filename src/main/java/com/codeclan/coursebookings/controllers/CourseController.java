package com.codeclan.coursebookings.controllers;


import com.codeclan.coursebookings.models.Course;
import com.codeclan.coursebookings.models.Customer;
import com.codeclan.coursebookings.repositories.CourseRepository;
import com.codeclan.coursebookings.repositories.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class CourseController {

    @Autowired
    CourseRepository courseRepository;

    @GetMapping(value = "/courses")
    public ResponseEntity<List<Course>> getAllCoursesOrByRatingOrByCustomer(
        @RequestParam(name = "starRating", required = false) Integer starRating,
        @RequestParam(name = "customer", required = false) String customer) {
    {
    if(starRating != null){
        return new ResponseEntity<>(courseRepository.findBystarRating(starRating), HttpStatus.OK);
    } else if (customer != null) {
        return new ResponseEntity<>(courseRepository.findByBookingsCustomerName(customer), HttpStatus.OK);
    }
        return new ResponseEntity<>(courseRepository.findAll(), HttpStatus.OK);
    }
    }

    @GetMapping(value = "/courses/{id}")
    public ResponseEntity getCourse(@PathVariable Long id){
        return new ResponseEntity(courseRepository.findById(id), HttpStatus.OK);
    }

    @PostMapping(value = "/courses")
    public ResponseEntity<Course> postCustomer(@RequestBody Course course){
        courseRepository.save(course);
        return new ResponseEntity<>(course, HttpStatus.CREATED);
    }
}