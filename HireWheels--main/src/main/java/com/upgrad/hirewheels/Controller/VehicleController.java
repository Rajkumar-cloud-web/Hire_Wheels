package com.upgrad.hirewheels.Controller;


import com.upgrad.hirewheels.dto.VehicleDto;
import com.upgrad.hirewheels.entities.Vehicle;
import com.upgrad.hirewheels.exceptions.VehicleDetailsNotFoundException;
import com.upgrad.hirewheels.services.VehicleService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping(value = "/hirewheel/v1")
public class VehicleController {
    @Autowired
    VehicleService vehicleService;

    @Autowired
    ModelMapper modelMapper;

    @GetMapping(value = "/sayHelloMovie")
    public String sayHello() {
        return "Hello World To All From VehicleController";
    }

    @GetMapping(value = "/Vehicles", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity getVehicles() {
        List<Vehicle> vehicleList = vehicleService.getAllVehicles();
        List<VehicleDto> vehicleDTOList = new ArrayList<>();
        for (Vehicle vehicle : vehicleList) {
            vehicleDTOList.add(modelMapper.map(vehicle, VehicleDto.class));
        }
        return new ResponseEntity<>(vehicleDTOList, HttpStatus.OK);
    }

    @GetMapping(value = "/Available_Vehicles", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity getAvailableVehicles(@RequestParam(value = "categoryId") int categoryId,
                                               @RequestParam(value = "pickUpDate") LocalDateTime pickUpDate,
                                               @RequestParam(value = "dropDate") LocalDateTime dropDate,
                                               @RequestParam(value = "locationId") int locationId
    ) {

        List<Vehicle> vehicleList = vehicleService.getAvailableVehicle(categoryId, pickUpDate, dropDate, locationId);
        List<VehicleDto> vehicleDTOList = new ArrayList<>();
        for (Vehicle vehicle : vehicleList) {
            vehicleDTOList.add(modelMapper.map(vehicle, VehicleDto.class));
        }
        return new ResponseEntity<>(vehicleDTOList, HttpStatus.OK);


    }
}

