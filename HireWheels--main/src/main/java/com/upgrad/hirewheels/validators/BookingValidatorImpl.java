package com.upgrad.hirewheels.validators;

import com.upgrad.hirewheels.dto.BookingDto;
import com.upgrad.hirewheels.entities.User;
import com.upgrad.hirewheels.entities.Vehicle;
import com.upgrad.hirewheels.exceptions.APIException;
import com.upgrad.hirewheels.exceptions.UserDetailsNotFoundException;
import com.upgrad.hirewheels.exceptions.VehicleDetailsNotFoundException;
import com.upgrad.hirewheels.services.UserService;
import com.upgrad.hirewheels.services.VehicleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class BookingValidatorImpl implements BookingValidator{

    @Autowired
    public VehicleService vehicleService;
    @Autowired
    public UserService usersService;

    @Override
    public void validateBooking(BookingDto bookingDto) throws APIException, VehicleDetailsNotFoundException, UserDetailsNotFoundException {
        if(bookingDto.getUsersId()<=0) {
            throw new APIException("Invalid user");
        }
        if (!bookingDto.getBookingDate().isEqual(bookingDto.getPickupDate().toLocalDate())){
            //if (!bookingDto.getBookingDate().isEqual(bookingDto.getPickupDate().getDayOfYear())){
            throw  new APIException("Booking date should be today's date");
        }
        User users= usersService.getUserByID(bookingDto.getUsersId());
        if(users.getWalletMoney()<bookingDto.getAmount()) {
            throw new APIException("Insufficient balance. Please check with Admin’");
        }

        Vehicle vehicle= vehicleService.getVehicleById(bookingDto.getVehicleId());
        if (!vehicle.isAvailabilityStatus()){
            throw new APIException("vehicle is unavailable for booking");
        }
        if (bookingDto.getLocationId() != bookingDto.getLocationId()){
            throw new APIException(" vehicle not available for booking location");
        }
    }

}
