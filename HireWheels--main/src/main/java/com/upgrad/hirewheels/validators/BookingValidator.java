package com.upgrad.hirewheels.validators;

import com.upgrad.hirewheels.dto.BookingDto;
import com.upgrad.hirewheels.exceptions.APIException;
import com.upgrad.hirewheels.exceptions.UserDetailsNotFoundException;
import com.upgrad.hirewheels.exceptions.VehicleDetailsNotFoundException;

public interface BookingValidator {
    public void validateBooking(BookingDto bookingDto) throws APIException, VehicleDetailsNotFoundException, UserDetailsNotFoundException;

}
