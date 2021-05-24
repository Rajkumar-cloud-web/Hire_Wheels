package com.upgrad.hirewheels.services;

import com.upgrad.hirewheels.dao.VehicleDao;
import com.upgrad.hirewheels.entities.Vehicle;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class AdminServiceImpl implements AdminService{

    @Autowired
    public VehicleDao vehicleDao;
    @Override
    public Vehicle registerVehicle(Vehicle vehicle ) {
        if (!vehicle.isAvailabilityStatus()){
            vehicle.setAvailabilityStatus(true);
        }
        return vehicleDao.save(vehicle);
    }

    @Override
    public Vehicle changeAvailability(Vehicle vehicle) {
        vehicle.setAvailabilityStatus(false);
        return vehicleDao.save(vehicle);
    }
}
