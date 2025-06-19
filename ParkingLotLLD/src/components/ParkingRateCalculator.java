package components;

import strategy.ParkingRateStrategy;

public class ParkingRateCalculator {
    private ParkingRateStrategy strategy;

    public ParkingRateCalculator(ParkingRateStrategy strategy) {
        this.strategy = strategy;
    }

    public double calculate(long hours) {
        return strategy.calculateFee(hours);
    }
}
