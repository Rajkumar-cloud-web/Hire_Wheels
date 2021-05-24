package com.upgrad.hirewheels.dao;

import com.upgrad.hirewheels.entities.VehicleCategory;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface VehicleCategoryDao extends JpaRepository <VehicleCategory, Integer> {

    public VehicleCategory findByVehicleCategoryId(int id);
}
