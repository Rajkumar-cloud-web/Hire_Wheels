package com.upgrad.hirewheels.validators;

import com.upgrad.hirewheels.dto.VehicleDto;
import com.upgrad.hirewheels.exceptions.APIException;


public interface VehicleValidator {
    public void validateVehicle(VehicleDto vehicleDto) throws APIException;
}
