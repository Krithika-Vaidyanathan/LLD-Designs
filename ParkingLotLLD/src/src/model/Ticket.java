package src.model;

import components.ParkingSlot;

import java.util.Date;

public class Ticket {
    private String ticketNumber;
    private Date entryTime;
    private ParkingSlot slot;
    private Vehicle vehicle;

    public Ticket(String ticketNumber, ParkingSlot slot, Vehicle vehicle) {
        this.ticketNumber = ticketNumber;
        this.slot = slot;
        this.entryTime = new Date();
        this.vehicle = vehicle;
    }

    public Date getEntryTime() {
        return entryTime;
    }
    public ParkingSlot getSlot() {
        return slot;
    }
    public Vehicle getVehicle() {
        return vehicle;
    }
}
