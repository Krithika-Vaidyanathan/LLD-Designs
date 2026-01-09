package components;

import enums.ShipmentStatus;

import java.util.ArrayList;
import java.util.List;

public class ShipmentTracker {
    private List<ShipmentStatusEvent> events = new ArrayList<>();

    public void addEvent(ShipmentStatus status) {
        if(status == null) {
            throw new IllegalArgumentException("Shipment Tracker not updated");
        }
        events.add(new ShipmentStatusEvent(status));
    }

    public List<ShipmentStatusEvent> getHistory() {
        return events;
    }
}
