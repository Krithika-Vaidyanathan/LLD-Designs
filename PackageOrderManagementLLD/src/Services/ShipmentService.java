package Services;

import components.CourierPartner;
import components.Customers;
import components.Order;
import components.Shipment;
import enums.OrderStatus;
import enums.ShipmentStatus;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

public class ShipmentService {

    private Map<String, Shipment> shipmentStore = new HashMap<>();
    private NotificationService notificationService = new NotificationService();

    public Shipment createShipment(Order order) {
        String shipmentId = UUID.randomUUID().toString();
        CourierPartner courier = new CourierPartner("C1", "FastExpress");

        Shipment shipment = new Shipment(shipmentId, courier);
        shipmentStore.put(shipmentId, shipment);

        System.out.println("Shipment created with ID: " + shipmentId);
        return shipment;
    }

    public void updateShipmentStatus(String shipmentId, ShipmentStatus status, Customers receiver) {
        Shipment shipment = shipmentStore.get(shipmentId);

        if(shipment == null) {
            throw new IllegalArgumentException("Shipment not found");
        }

        shipment.setStatus(status);
        notificationService.notifyCustomer(receiver, "Shipment " + shipmentId + " status updated to " + status);
    }
}
