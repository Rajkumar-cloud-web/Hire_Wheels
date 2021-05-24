package com.upgrad.hirewheels.entities;


import javax.persistence.*;
import java.util.Set;

@Entity
public class Location {

    @Id
    @GeneratedValue
    private int locationId;
    @Column(length = 50,nullable = false)
    private String locationName;
    @Column(length = 100,nullable = false)
    private String address;
    @Column(length = 10,nullable = false)
    private int pincode;

    @OneToMany(mappedBy = "location", fetch = FetchType.EAGER)
    private Set<Booking> bookings;

    @OneToMany(mappedBy = "location", fetch = FetchType.EAGER)
    private Set<Vehicle> vehicles;


    @ManyToOne
    @JoinColumn(name = "city_id",nullable = false)
    private City city;

    public Location() {
    }

    public Location(int locationId, String locationName, String address, int pincode, City city) {
        this.locationId = locationId;
        this.locationName = locationName;
        this.address = address;
        this.pincode = pincode;
        this.city = city;
    }

    public Set<Vehicle> getVehicles() {
        return vehicles;
    }

    public void setVehicles(Set<Vehicle> vehicles) {
        this.vehicles = vehicles;
    }

    public City getCity() {
        return city;
    }

    public void setCity(City city) {
        this.city = city;
    }

    public Set<Booking> getBookings() {
        return bookings;
    }

    public void setBookings(Set<Booking> bookings) {
        this.bookings = bookings;
    }

    public int getLocationId() {
        return locationId;
    }

    public void setLocationId(int locationId) {
        this.locationId = locationId;
    }

    public String getLocationName() {
        return locationName;
    }

    public void setLocationName(String locationName) {
        this.locationName = locationName;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public int getPincode() {
        return pincode;
    }

    public void setPincode(int pincode) {
        this.pincode = pincode;
    }

    @Override
    public String toString() {
        return "Location{" +
                "locationId=" + locationId +
                ", locationName='" + locationName + '\'' +
                ", address='" + address + '\'' +
                ", pincode=" + pincode +
                // ", bookings=" + bookings +
                // ", vehicles=" + vehicles +
                ", city=" + city +
                '}';
    }
}