package strategy;

public class CarRateStrategy implements ParkingRateStrategy {
    public double calculateFee(long hours) {
        return 20 + (hours - 1) * 10;
    }
}


