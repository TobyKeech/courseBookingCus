package com.codeclan.coursebookings.repositories;

import com.codeclan.coursebookings.models.Course;
import com.codeclan.coursebookings.models.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CustomerRepository extends JpaRepository<Customer,Long> {

    List<Customer>findByBookingsCourseName(String course);
}
