package components;

import src.enumTypes.ParkingSlotType;
import src.model.Vehicle;

public class ParkingSlot {
    private String slotId;
    private ParkingSlotType slotType;   //BIKE, COMPACT, LARGE
    private boolean isOccupied = false;
    private Vehicle vehicle;

    public ParkingSlot(String slotId, ParkingSlotType type) {
        this.slotId = slotId;
        this.slotType = type;    //BIKE, COMPACT, LARGE
    }

    public boolean assignVehicle(Vehicle vehicle) {
        if(isOccupied) return false;
        this.vehicle = vehicle;
        isOccupied = true;
        return true;
    }

    public void removeVehicle() {
        this.vehicle = null;
        this.isOccupied = false;
    }

    public ParkingSlotType getSlotType() {
        return slotType;
    }
    public boolean isOccupied() {
        return isOccupied;
    }
}
