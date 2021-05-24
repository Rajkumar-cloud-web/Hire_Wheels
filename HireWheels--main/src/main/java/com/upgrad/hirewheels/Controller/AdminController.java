package com.upgrad.hirewheels.Controller;


import com.upgrad.hirewheels.dto.VehicleDto;
import com.upgrad.hirewheels.entities.Vehicle;
import com.upgrad.hirewheels.exceptions.APIException;
import com.upgrad.hirewheels.exceptions.VehicleDetailsNotFoundException;
import com.upgrad.hirewheels.exceptions.VehicleRegistrationFailedException;
import com.upgrad.hirewheels.exceptions.VehicleSatusException;
import com.upgrad.hirewheels.services.AdminService;
import com.upgrad.hirewheels.services.VehicleService;
import com.upgrad.hirewheels.validators.VehicleValidator;
import org.modelmapper.ModelMapper;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.slf4j.Logger;




@RestController
@RequestMapping(value = "/hirewheels/v1")
public class AdminController {


    @Autowired
    public AdminService adminService;
    @Autowired
    public VehicleService vehicleService;

    @Autowired
    public ModelMapper modelMapper;
    private static final Logger logger = LoggerFactory.getLogger(AdminController.class);

    @Autowired
    public VehicleValidator vehicleValidator;

    @PostMapping(value="/Vehicles", consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity newVehicle(@RequestBody VehicleDto vehicleDTO) throws VehicleRegistrationFailedException, APIException {
        vehicleValidator.validateVehicle(vehicleDTO);
        Vehicle newVehicle = modelMapper.map(vehicleDTO, Vehicle.class);
        ;
        Vehicle savedVehicle = adminService.registerVehicle(newVehicle);

        VehicleDto savedVehicleDTO = modelMapper.map(savedVehicle, VehicleDto.class);
        logger.debug("adding new vehicle : " + savedVehicleDTO);
        return new ResponseEntity<>(savedVehicleDTO, HttpStatus.CREATED);
    }

        @PutMapping(value = "/Vehicle/{id}")
        public ResponseEntity changeAvailability ( @PathVariable(name = "id") int id) throws
                VehicleDetailsNotFoundException, VehicleSatusException {
            Vehicle responseVehicle = vehicleService.getVehicleById(id);
            Vehicle vehicle = adminService.changeAvailability(responseVehicle);
            VehicleDto responseVehicleDTO = modelMapper.map(vehicle, VehicleDto.class);
            logger.debug("changing availability status : " + responseVehicleDTO);
            return new ResponseEntity<>(responseVehicleDTO, HttpStatus.OK);

        }
    }
