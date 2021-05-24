package com.upgrad.hirewheels.Controller;

import com.upgrad.hirewheels.dto.BookingDto;
import com.upgrad.hirewheels.entities.Booking;
import com.upgrad.hirewheels.services.BookingService;
import com.upgrad.hirewheels.services.UserService;
import com.upgrad.hirewheels.validators.BookingValidator;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/hirewheels/v1")
public class BookingController {
    @Autowired
    public BookingService bookingService;
    @Autowired
    public UserService usersService;
    @Autowired
    public ModelMapper modelMapper;
    @Autowired
    public BookingValidator bookingValidator;

    @PostMapping(value = "/bookings", consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity newBooking(@RequestBody BookingDto bookingDto) throws Exception {
        bookingValidator.validateBooking(bookingDto);
        System.out.println("S*******************"+bookingDto.getUsersId());
        Booking newBooking = modelMapper.map(bookingDto, Booking.class);
        System.out.println("******************"+newBooking.getUser());
        //Booking savedBooking= bookingService.addBooking(newBooking);
        Booking savedBooking= bookingService.addBooking(newBooking, usersService.getUserByID(bookingDto.getUsersId()) );
        BookingDto savedBookingDTO = modelMapper.map(savedBooking,BookingDto.class);
        return new ResponseEntity<>(savedBookingDTO, HttpStatus.CREATED);

    }
}
