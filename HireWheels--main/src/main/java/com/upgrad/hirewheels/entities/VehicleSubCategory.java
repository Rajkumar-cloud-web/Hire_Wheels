package com.upgrad.hirewheels.entities;


import javax.persistence.Entity;
import javax.persistence.*;
import java.util.Set;

@Entity
public class VehicleSubCategory {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int vehicleSubCategoryId;
    @Column(length = 50,nullable = false,unique = true)
    private String vehicleSubCategoryName;
    @Column(nullable = false)
    private double pricePerDay;

    @OneToMany(mappedBy = "vehicleSubCategory", fetch = FetchType.EAGER)
    private Set<Vehicle> vehicles;

    @ManyToOne
    @JoinColumn(name = "vehicle_category_id",nullable = false)
    private VehicleCategory vehicleCategory;

    public VehicleSubCategory() {
    }

    public VehicleSubCategory(int vehicleSubCategoryId, String vehicleSubCategoryName, double pricePerDay, VehicleCategory vehicleCategory) {
        this.vehicleSubCategoryId = vehicleSubCategoryId;
        this.vehicleSubCategoryName = vehicleSubCategoryName;
        this.pricePerDay = pricePerDay;
        this.vehicleCategory = vehicleCategory;
    }

    public Set<Vehicle> getVehicles() {
        return vehicles;
    }

    public void setVehicles(Set<Vehicle> vehicles) {
        this.vehicles = vehicles;
    }

    public VehicleCategory getVehicleCategory() {
        return vehicleCategory;
    }

    public void setVehicleCategory(VehicleCategory vehicleCategory) {
        this.vehicleCategory = vehicleCategory;
    }

    public int getVehicleSubCategoryId() {
        return vehicleSubCategoryId;
    }

    public void setVehicleSubCategoryId(int vehicleSubCategoryId) {
        this.vehicleSubCategoryId = vehicleSubCategoryId;
    }

    public String getVehicleSubCategoryName() {
        return vehicleSubCategoryName;
    }

    public void setVehicleSubCategoryName(String vehicleSubCategoryName) {
        this.vehicleSubCategoryName = vehicleSubCategoryName;
    }

    public double getPricePerDay() {
        return pricePerDay;
    }

    public void setPricePerDay(double pricePerDay) {
        this.pricePerDay = pricePerDay;
    }

    @Override
    public String toString() {
        return "VehicleSubCategory{" +
                "vehicleSubCategoryId=" + vehicleSubCategoryId +
                ", vehicleSubCategoryName='" + vehicleSubCategoryName + '\'' +
                ", pricePerDay=" + pricePerDay +
                '}';
    }
}