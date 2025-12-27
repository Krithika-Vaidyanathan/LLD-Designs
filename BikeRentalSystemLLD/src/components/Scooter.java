package components;

import enums.ScooterType;

public class Scooter extends Product {
    private ScooterType type;

    public Scooter(String productId, ScooterType type) {
        super(productId, 30);
        this.type = type;
    }

    @Override
    public double getHourlyRate() {
        switch(type) {
            case ELECTRIC: return baseHourlyRate * 1.5;
            case PETROL: return baseHourlyRate * 1.2;
            default: return baseHourlyRate;
        }
    }
}
