package strategy;

//Define strategy interface
public interface ParkingRateStrategy {
    double calculateFee(long durationInHours);
}
