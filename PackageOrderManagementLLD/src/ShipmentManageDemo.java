import Services.ShipmentService;
import components.Customers;
import components.Order;
import components.Shipment;
import components.ShipmentStatusEvent;
import enums.PackageType;
import components.Package;
import enums.ShipmentStatus;

public class ShipmentManageDemo {


    public static void main(String[] args) {
        // Customers
        Customers sender = new Customers("C1", "Alice", "Chennai", "9999999999");
        Customers receiver = new Customers("C2", "Bob", "Bangalore", "8888888888");

        // Package
        Package pkg = new Package(2.5, 10, 8, 6, PackageType.BOX);

        // Order
        Order order = new Order("O1", sender, receiver, pkg);
        order.confirmOrder();

        // Shipment
        ShipmentService shipmentService = new ShipmentService();
        Shipment shipment = shipmentService.createShipment(order);

        // Shipment lifecycle
        shipmentService.updateShipmentStatus(
                shipment.getShipmentId(),
                ShipmentStatus.PICKED_UP,
                receiver
        );

        shipmentService.updateShipmentStatus(
                shipment.getShipmentId(),
                ShipmentStatus.IN_TRANSIT,
                receiver
        );

        shipmentService.updateShipmentStatus(
                shipment.getShipmentId(),
                ShipmentStatus.DELIVERED,
                receiver
        );

        // Print tracking history
        System.out.println("\nShipment Tracking History:");
        for (ShipmentStatusEvent event : shipment.getTracker().getHistory()) {
            System.out.println(event.getStatus() + " at " + event.getTimestamp());
        }
    }
}
