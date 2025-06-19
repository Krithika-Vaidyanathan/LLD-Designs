package components;

import enumTypes.ParkingSlotType;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ParkingFloor {
    private int floorNumber;
    private Map<ParkingSlotType, List<ParkingSlot>> slots = new HashMap<>();
    private DisplayBoard displayBoard = new DisplayBoard();

    public ParkingFloor(int floorNumber) {
        this.floorNumber = floorNumber;
    }

    public DisplayBoard getDisplayBoard() {
        return displayBoard;
    }

    //Check if slot.getSlotType() is in slots map. If yes, return the existing list.
    //If not, create a new array list, store it in the map, return that list, then add current slot into that list.
    public void addSlot(ParkingSlot slot) {
        slots.computeIfAbsent(slot.getSlotType(), k -> new ArrayList<>()).add(slot);
        this.updateDisplayBoard(slot.getSlotType());
    }

    //Get slot list or return list if not found. Keep only free slots and collect result back to the list.
    public List<ParkingSlot> getAvailableSlots(ParkingSlotType type) {
        return slots.getOrDefault(type, new ArrayList<>()).stream().filter(s-> !s.isOccupied()).toList();
    }

    public void updateDisplayBoard(ParkingSlotType type) {
        long available = slots.getOrDefault(type, new ArrayList<>()).stream().filter(s-> !s.isOccupied()).count();
        displayBoard.updateSlotCount(type, (int) available);
    }

    public int getFloorNumber() {
        return floorNumber;
    }
}
