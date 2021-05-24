package com.upgrad.hirewheels.entities;


import javax.persistence.Entity;
import javax.persistence.*;
import java.util.Set;

@Entity
public class FuelType {


    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int fuelTypeId;
    @Column(length = 50,nullable = false,unique = true)
    private String fuelType;

    @OneToMany(mappedBy = "fuelType",fetch = FetchType.EAGER)
    private Set<Vehicle> vehicles;

    public FuelType(int fuelTypeId, String fuelType) {
        this.fuelTypeId = fuelTypeId;
        this.fuelType = fuelType;
    }

    public FuelType() {
    }

    public Set<Vehicle> getVehicles() {
        return vehicles;
    }

    public void setVehicles(Set<Vehicle> vehicles) {
        this.vehicles = vehicles;
    }

    public int getFuelTypeId() {
        return fuelTypeId;
    }

    public void setFuelTypeId(int fuelTypeId) {
        this.fuelTypeId = fuelTypeId;
    }

    public String getFuelType() {
        return fuelType;
    }

    public void setFuelType(String fuelType) {
        this.fuelType = fuelType;
    }

    @Override
    public String toString() {
        return "FuelType{" +
                "fuelTypeId=" + fuelTypeId +
                ", fuelType='" + fuelType + '\'' +
                // ", vehicles=" + vehicles +
                '}';
    }
}