package components;

import enums.OrderStatus;
import enums.ShipmentStatus;

public class Shipment {
    private String shipmentId;
    private ShipmentStatus currentStatus;
    private CourierPartner courierPartner;
    private ShipmentTracker tracker;

    public Shipment(String shipmentId, CourierPartner courierPartner) {
        this.shipmentId = shipmentId;
        this.currentStatus = ShipmentStatus.CREATED;
        this.courierPartner = courierPartner;
        this.tracker = new ShipmentTracker();
        this.tracker.addEvent(ShipmentStatus.CREATED);
    }

    public void setStatus(ShipmentStatus status) {
        this.currentStatus = status;
        this.tracker.addEvent(status);
    }

    public ShipmentStatus getStatus() {
        return currentStatus;
    }

    public ShipmentTracker getTracker() {
        return tracker;
    }

    public String getShipmentId() {
        return shipmentId;
    }
}
