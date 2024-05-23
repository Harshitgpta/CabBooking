package com.example.cabbooking.service;

import com.example.cabbooking.model.Driver;
import com.example.cabbooking.model.Location;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class DriverService {
    private List<Driver> drivers = new ArrayList<>();

    public void addDriver(Driver driver) {
        drivers.add(driver);
    }

    public List<Driver> findRides(Location source, Location destination) {
        return drivers.stream()
                .filter(driver -> driver.isAvailable() && calculateDistance(driver.getCurrentLocation(), source) <= 5)
                .collect(Collectors.toList());
    }

    private double calculateDistance(Location loc1, Location loc2) {
        return Math.sqrt(Math.pow(loc1.getX() - loc2.getX(), 2) + Math.pow(loc1.getY() - loc2.getY(), 2));
    }

    public void chooseRide(String userName, String driverName) {
        for (Driver driver : drivers) {
            if (driver.getName().equals(driverName)) {
                driver.setAvailable(false);
                break;
            }
        }
    }
}
