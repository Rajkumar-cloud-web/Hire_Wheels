package com.upgrad.hirewheels.services;

import com.upgrad.hirewheels.dao.UserDao;
import com.upgrad.hirewheels.dao.VehicleCategoryDao;
import com.upgrad.hirewheels.dao.VehicleSubCategoryDao;
import com.upgrad.hirewheels.dao.CityDao;
import com.upgrad.hirewheels.dao.FuelTypeDao;
import com.upgrad.hirewheels.dao.LocationDao;
import com.upgrad.hirewheels.entities.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*Create a service class named 'initServiceImpl' in the service package to prepopulate some of
the tables of hireWheels database with some fixed attributes This service should be used
every time the application start
 */
@Service
public class InitServiceImpl implements InitService{
    @Autowired
    UserDao userDao;
    @Autowired
    VehicleCategoryDao vehicleCategoryDao;
    @Autowired
    VehicleSubCategoryDao vehicleSubCategoryDAO;
    @Autowired
    CityDao cityDAO;

    @Autowired
    FuelTypeDao fuelTypeDAO;

    @Autowired
    LocationDao locationDAO;

    public void start() {

        addCity();
        addLocation();
        addFuelType();
        addVehicleCategory();
        addVehicleSubCategory();
    }

    private void addCity() {
        cityDAO.save(new City(1,"Mumbai"));
    }

    private void addFuelType() {
        List<FuelType> fuelTypeList = Arrays.asList(new FuelType(5,"Petrol"), new FuelType(6, "Diesel"));
        fuelTypeDAO.saveAll(fuelTypeList);
    }
    private void addLocation() {
        Location location;

        location = new Location(2, "Chembur",
                "Optic Complex",400019,cityDAO.findById(1).get());
        locationDAO.save(location);
        location = new Location(3, "Powai",
                "Hiranandani Tower",400020,cityDAO.findById(1).get());
        locationDAO.save(location);
        location   = new Location(4, "Worli",
                "Dr E Moses Rd, Worli Naka, Upper Worli",400018,cityDAO.findById(1).get());
        locationDAO.save(location);
    }

    private void addVehicleCategory() {
        List<VehicleCategory> vehicleCategoryList = Arrays.asList(new VehicleCategory(7, "CAR"),
                new VehicleCategory(8,"BIKE"));
        vehicleCategoryDao.saveAll(vehicleCategoryList);
    }

    private void addVehicleSubCategory() {
        List<VehicleSubCategory> vehicleSubCategories = new ArrayList<>();

        vehicleSubCategories.add(new VehicleSubCategory(9, "SUV",
                300,vehicleCategoryDao.findByVehicleCategoryId(7) ));

        vehicleSubCategories.add(new VehicleSubCategory(10, "SEDAN",
                350,vehicleCategoryDao.findByVehicleCategoryId(7) ));

        vehicleSubCategories.add(new VehicleSubCategory(11, "HATCHBACK",
                250,vehicleCategoryDao.findByVehicleCategoryId(7) ));

        vehicleSubCategories.add(new VehicleSubCategory(12, "CRUISER",
                200,vehicleCategoryDao.findByVehicleCategoryId(8) ));

        vehicleSubCategories.add(new VehicleSubCategory(13, "DIRT BIKE",
                200,vehicleCategoryDao.findByVehicleCategoryId(8) ));

        vehicleSubCategories.add(new VehicleSubCategory(14, "SPORTS BIKE",
                150,vehicleCategoryDao.findByVehicleCategoryId(8) ));

        vehicleSubCategoryDAO.saveAll(vehicleSubCategories);
    }






}
