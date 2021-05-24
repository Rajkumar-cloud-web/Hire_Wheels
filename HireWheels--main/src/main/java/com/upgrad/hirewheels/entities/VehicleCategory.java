package com.upgrad.hirewheels.entities;


import javax.persistence.Entity;
import javax.persistence.*;

@Entity
public class VehicleCategory {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int vehicleCategoryId;
    @Column(length = 50,nullable = false,unique = true)
    private  String VehicleCategoryName;

    public VehicleCategory() {
    }

    public VehicleCategory(int vehicleCategoryId, String vehicleCategoryName) {
        this.vehicleCategoryId = vehicleCategoryId;
        VehicleCategoryName = vehicleCategoryName;
    }

    public int getVehicleCategoryId() {
        return vehicleCategoryId;
    }

    public void setVehicleCategoryId(int vehicleCategoryId) {
        this.vehicleCategoryId = vehicleCategoryId;
    }

    public String getVehicleCategoryName() {
        return VehicleCategoryName;
    }

    public void setVehicleCategoryName(String vehicleCategoryName) {
        VehicleCategoryName = vehicleCategoryName;
    }

    @Override
    public String toString() {
        return "VehicleCategory{" +
                "vehicleCategoryId=" + vehicleCategoryId +
                ", VehicleCategoryName='" + VehicleCategoryName + '\'' +
                '}';
    }
}