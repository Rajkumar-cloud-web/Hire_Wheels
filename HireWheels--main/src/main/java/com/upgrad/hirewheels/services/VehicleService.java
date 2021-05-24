package com.upgrad.hirewheels.services;

import com.upgrad.hirewheels.entities.Booking;
import com.upgrad.hirewheels.entities.Vehicle;
import com.upgrad.hirewheels.exceptions.VehicleDetailsNotFoundException;

import java.time.LocalDateTime;
import java.util.List;

public interface VehicleService {

    public List<Vehicle> getAllVehicles();
    Vehicle getVehicleById(int id) throws VehicleDetailsNotFoundException;
    public List<Vehicle> getAvailableVehicles(Booking booking);
    List<Vehicle> getAvailableVehicle(int categoryId, LocalDateTime pickUpDate, LocalDateTime dropDate, int locationId);
}
