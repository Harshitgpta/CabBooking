package com.example.cabbooking.controller;

import com.example.cabbooking.model.Driver;
import com.example.cabbooking.model.Location;
import com.example.cabbooking.service.DriverService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/drivers")
public class DriverController {
    @Autowired
    private DriverService driverService;

    @PostMapping("/add")
    public void addDriver(@RequestBody Driver driver) {
        driverService.addDriver(driver);
    }

    @GetMapping("/findRide")
    public List<Driver> findRide(@RequestParam String userName, @RequestParam int sourceX, @RequestParam int sourceY, @RequestParam int destX, @RequestParam int destY) {
        Location source = new Location(sourceX, sourceY);
        Location destination = new Location(destX, destY);
        return driverService.findRides(source, destination);
    }

    @PostMapping("/chooseRide")
    public void chooseRide(@RequestParam String userName, @RequestParam String driverName) {
        driverService.chooseRide(userName, driverName);
    }
}
