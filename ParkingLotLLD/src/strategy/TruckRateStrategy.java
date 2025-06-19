package strategy;

public class TruckRateStrategy implements ParkingRateStrategy {
    public double calculateFee(long hours) {
        return 10 * (hours - 1) * 30;
    }
}
