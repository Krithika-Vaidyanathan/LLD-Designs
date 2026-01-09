package Factory;

import src.enumTypes.VehicleType;
import src.model.Bike;
import src.model.Car;
import src.model.Truck;
import src.model.Vehicle;
//VehicleFactory encapsulate object creation logic.
//This keeps client code clean and allows new vehicle types to be added without modifying existing flow, aligning with the Open–Closed Principle
public class VehicleFactory {
    public static Vehicle createVehicle(VehicleType type, String licensePlate) {

        switch (type) {
            case CAR:
                return new Car(licensePlate);
            case BIKE:
                return new Bike(licensePlate);
            case TRUCK:
                return new Truck(licensePlate);
            default:
                throw new IllegalArgumentException("Unsupported vehicle type");
        }
    }
}
