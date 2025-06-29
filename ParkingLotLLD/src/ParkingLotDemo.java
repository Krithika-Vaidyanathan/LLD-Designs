import components.ParkingFloor;
import components.ParkingLot;
import components.ParkingSlot;
import src.enumTypes.ParkingSlotType;
import src.model.*;
import panel.EntrancePanel;
import panel.ExitPanel;

public class ParkingLotDemo {

    public static void main(String[] args) throws InterruptedException {
        ParkingLot lot = new ParkingLot("Chennai chrome lot");
        ParkingFloor floor1 = new ParkingFloor(1);

        floor1.addSlot(new ParkingSlot("C1", ParkingSlotType.COMPACT));
        floor1.addSlot(new ParkingSlot("C2", ParkingSlotType.COMPACT));
        floor1.addSlot(new ParkingSlot("B1", ParkingSlotType.BIKE));
        lot.addFloor(floor1);

        EntrancePanel ep = new EntrancePanel("ENT1");
        ExitPanel xp = new ExitPanel("EXT1");
        lot.addEntrance("ENT1", ep);
        lot.addExit("EXT1", xp);

        Vehicle myCar = new Car("TN-10-1234");
        Ticket ticket = ep.generateTicket(myCar, lot);
        System.out.println("Ticket issued for: " + ticket.getVehicle().getType() + " - " + myCar.getLicensePlate());
        floor1.getDisplayBoard().display();

        Thread.sleep(1000);
        xp.processExit(ticket);
        floor1.getDisplayBoard().display();
    }
}
