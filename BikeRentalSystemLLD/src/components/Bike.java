package components;

import enums.BikeSize;

public class Bike extends Product {
    private BikeSize size;
    public Bike(String productId, BikeSize size) {
        super(productId, 50);
        this.size = size;
    }

    @Override
    public double getHourlyRate() {
        switch(size) {
            case SMALL: return baseHourlyRate * 1.0;
            case MEDIUM: return baseHourlyRate * 1.2;
            case LARGE: return baseHourlyRate * 1.5;
            default: return baseHourlyRate;
        }
    }
}
