package com.example.cabbooking.model;

public class Vehicle {
    private String model;
    private String licensePlate;

    public Vehicle(String model, String licensePlate) {
        this.model = model;
        this.licensePlate = licensePlate;
    }

    // Getters and setters
    public String getModel() { return model; }
    public void setModel(String model) { this.model = model; }

    public String getLicensePlate() { return licensePlate; }
    public void setLicensePlate(String licensePlate) { this.licensePlate = licensePlate; }
}
