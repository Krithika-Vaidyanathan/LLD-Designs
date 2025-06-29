package src.model;

import src.enumTypes.VehicleType;

public abstract class Vehicle {
    protected String licensePlate;
    protected VehicleType vehicleType; //CAR, BIKE, TRUCK

    public Vehicle(String licensePlate, VehicleType type) {
        this.licensePlate = licensePlate;
        this.vehicleType = type;
    }

    public VehicleType getType() {
        return vehicleType;  //CAR, BIKE, TRUCK
    }

    public String getLicensePlate() {
        return licensePlate;
    }
}




