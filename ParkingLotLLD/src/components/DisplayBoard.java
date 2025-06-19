package components;

import enumTypes.ParkingSlotType;

import java.util.HashMap;
import java.util.Map;

public class DisplayBoard {
    private Map<ParkingSlotType, Integer> availableSlots = new HashMap<>();

    public void updateSlotCount(ParkingSlotType type, int count) {
        availableSlots.put(type, count);
    }

    public void display() {
        availableSlots.forEach((type, count) ->
                System.out.println(type + ": " + count + " slots available."));
    }
}
