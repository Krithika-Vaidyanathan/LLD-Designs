package panel;

import components.ParkingFloor;
import components.ParkingLot;
import components.ParkingSlot;
import src.enumTypes.ParkingSlotType;
import src.enumTypes.VehicleType;
import src.model.*;

import java.util.List;
import java.util.UUID;

public class EntrancePanel {
    private String id;
    public EntrancePanel(String id) {
        this.id = id;
    }

    public Ticket generateTicket(Vehicle vehicle, ParkingLot lot) {
        for(ParkingFloor floor: lot.getFloors()) {
            System.out.println("floor: " + floor.getFloorNumber());
            List<ParkingSlot> available =  floor.getAvailableSlots(this.getSlotType(vehicle.getType()));

            if(!available.isEmpty()) {
                ParkingSlot slot = available.get(0);
                slot.assignVehicle(vehicle);
                return new Ticket(UUID.randomUUID().toString(), slot, vehicle);
            }
        }
        throw new RuntimeException("No slot available");
    }

    //Based on the type of vehicle, we return the slot type where the vehicle can be parked.
    private ParkingSlotType getSlotType(VehicleType type) {
        return switch(type) {
            case BIKE -> ParkingSlotType.BIKE;
            case CAR -> ParkingSlotType.COMPACT;
            case TRUCK -> ParkingSlotType.LARGE;
        };
    }
}
