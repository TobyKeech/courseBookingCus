package com.codeclan.coursebookings.components;
import com.codeclan.coursebookings.models.Booking;
import com.codeclan.coursebookings.models.Course;
import com.codeclan.coursebookings.models.Customer;
import com.codeclan.coursebookings.repositories.BookingRepository;
import com.codeclan.coursebookings.repositories.CourseRepository;
import com.codeclan.coursebookings.repositories.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

import java.util.ArrayList;

@Profile("!test")
//@Component //Comment this out if you do not to run the data loader.
public class DataLoader implements ApplicationRunner {

    @Autowired
    CourseRepository courseRepository;

    @Autowired
    BookingRepository bookingRepository;

    @Autowired
    CustomerRepository customerRepository;


    public DataLoader() {

    }

    public void run(ApplicationArguments args) {

        Course codeclan = new Course("codeclan", "edi", 5);
        courseRepository.save(codeclan);
        Course pokemomMaster = new Course("pokemonM", "arena", 2);
        courseRepository.save(pokemomMaster);
        Course keithCollective = new Course("keith", "space", 10);
        courseRepository.save(keithCollective);

        Customer keith = new Customer("keith", "edi", 30);
        customerRepository.save(keith);
        Customer mar = new Customer("mar", "edi", 28);
        customerRepository.save(mar);
        Customer sky = new Customer("sky", "edi", 25);
        customerRepository.save(sky);

        Booking booking1 = new Booking("23/5/28", codeclan, keith );
        bookingRepository.save(booking1);
        Booking booking2 = new Booking("23/5/28", pokemomMaster, mar);
        bookingRepository.save(booking2);
        Booking booking3 = new Booking("23/5/28", keithCollective, sky);
        bookingRepository.save(booking3);

    }
    }
