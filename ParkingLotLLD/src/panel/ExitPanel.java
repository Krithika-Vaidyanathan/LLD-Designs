package panel;

import components.ParkingRateCalculator;
import components.ParkingSlot;
import model.*;
import strategy.BikeRateStrategy;
import strategy.CarRateStrategy;
import strategy.ParkingRateStrategy;
import strategy.TruckRateStrategy;

import java.util.Date;

public class ExitPanel {
    private String id;
    public ExitPanel(String id) {
        this.id = id;
    }

    public void processExit(Ticket ticket) {
        ParkingSlot slot = ticket.getSlot();
        slot.removeVehicle();
        long duration = Math.max(1, (new Date().getTime() - ticket.getEntryTime().getTime()) / (1000 * 60 * 60));

        ParkingRateStrategy strategy = switch(ticket.getVehicle().getType()) {
            case CAR -> new CarRateStrategy();
            case BIKE -> new BikeRateStrategy();
            case TRUCK -> new TruckRateStrategy();
        };

        ParkingRateCalculator calc = new ParkingRateCalculator(strategy);
        double fee = calc.calculate(duration);
        System.out.println( ticket.getVehicle().getType() + " Vehicle exited. Duration: " + duration + " hours. Fee: Rs." + (int) fee);
    }
}
