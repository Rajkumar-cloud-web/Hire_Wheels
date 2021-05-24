package com.upgrad.hirewheels.entities;


import javax.persistence.Entity;
import javax.persistence.*;
import java.util.Set;

@Entity
public class City {

    @Id
    @GeneratedValue
    private int cityId;
    @Column(length = 50)
    private String cityName;

    @OneToMany(mappedBy = "city",fetch = FetchType.EAGER)
    private Set<Location> locations ;

    public Set<Location> getLocations() {
        return locations;
    }

    public City() {
    }

    public City(int cityId, String cityName) {
        this.cityId = cityId;
        this.cityName = cityName;
    }

    public void setLocations(Set<Location> locations) {
        this.locations = locations;
    }

    public int getCityId() {
        return cityId;
    }

    public void setCityId(int cityId) {
        this.cityId = cityId;
    }

    public String getCityName() {
        return cityName;
    }

    public void setCityName(String cityName) {
        this.cityName = cityName;
    }

    @Override
    public String toString() {
        return "City{" +
                "cityId=" + cityId +
                ", cityName='" + cityName + '\'' +
                //", locations=" + locations +
                '}';
    }
}