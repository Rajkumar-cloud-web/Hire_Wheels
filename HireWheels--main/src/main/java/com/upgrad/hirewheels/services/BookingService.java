package com.upgrad.hirewheels.services;

import com.upgrad.hirewheels.entities.Booking;
import com.upgrad.hirewheels.entities.User;

public interface BookingService {
    public Booking addBooking (Booking booking, User user) throws Exception;
}
