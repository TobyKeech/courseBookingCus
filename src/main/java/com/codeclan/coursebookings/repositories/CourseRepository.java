package com.codeclan.coursebookings.repositories;

import com.codeclan.coursebookings.models.Course;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CourseRepository extends JpaRepository<Course,Long> {

    List<Course> findBystarRating (int starRating);

    List<Course>findByBookingsCustomerName(String customer);

}
