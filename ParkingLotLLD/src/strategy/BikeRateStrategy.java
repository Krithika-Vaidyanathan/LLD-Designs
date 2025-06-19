package strategy;

public class BikeRateStrategy implements ParkingRateStrategy {
    public double calculateFee(long hours) {
        return 10 + (hours - 1) * 5;
    }
}