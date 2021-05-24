package com.upgrad.hirewheels.services;

import com.upgrad.hirewheels.dao.BookingDao;
import com.upgrad.hirewheels.dao.VehicleDao;
import com.upgrad.hirewheels.entities.Booking;
import com.upgrad.hirewheels.entities.Vehicle;
import com.upgrad.hirewheels.exceptions.VehicleDetailsNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Service
public class VehicleServiceImpl implements VehicleService{
    @Autowired
    public VehicleDao vehicleDao;
    @Autowired
    public BookingDao bookingDao;

    @Override
    public List<Vehicle> getAllVehicles() {
        return vehicleDao.findAll();
    }

    @Override
    public List<Vehicle> getAvailableVehicles(Booking booking) {
        List<Vehicle> vehicleList= vehicleDao.findAll();
        List<Vehicle> vehicles=null;
        for (Vehicle v : vehicleList){
            if (v.getVehicleId()==booking.getVehicle().getVehicleId()
                    && v.isAvailabilityStatus() == true
                    && v.getLocation() == booking.getLocation() ){
                vehicles.add(v);
            }
        }
        return vehicles;
    }

    public Vehicle getVehicleById(int id) throws VehicleDetailsNotFoundException {
        return vehicleDao.findById(id).get();
    }

    public List<Vehicle> getAvailableVehicle(int categoryId, LocalDateTime pickUpDate, LocalDateTime dropDate, int locationId) {
        List<Vehicle> vehicles = vehicleDao.findAll();
        List<Vehicle> vehicleList = new ArrayList<>();

        List<Booking> bookingList = bookingDao.findAll();
        for (Vehicle vehicle : vehicles) {
            if (vehicle.getVehicleSubCategory().getVehicleSubCategoryId() == categoryId
                    && vehicle.getLocation().getLocationId() == locationId) {
                for (Booking booking : bookingList) {
                    if (booking.getVehicle().getVehicleId() == vehicle.getVehicleId()
                            && (booking.getPickupDate().isEqual(pickUpDate) || booking.getDropOffDate().isEqual(dropDate))) {
                        vehicleList.add(vehicle);
                    }
                }
            }
        }
        return vehicleList;
    }
}
