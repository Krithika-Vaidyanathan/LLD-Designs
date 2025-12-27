package components;

import enums.ProductStatus;

public abstract class Product {
    protected String productId;
    protected ProductStatus status;
    protected double baseHourlyRate;

    public Product(String productId, double baseHourlyRate) {
        this.productId = productId;
        this.baseHourlyRate = baseHourlyRate;
        this.status = ProductStatus.AVAILABLE;
    }

    public String getProductId() {
        return this.productId;
    }
    public ProductStatus getStatus() {
        return this.status;
    }
    public void markRented() {
        status = ProductStatus.RENTED;
    }
    public void markAvailable() {
        status = ProductStatus.AVAILABLE;
    }

    //Each product decides its own pricing
    public abstract double getHourlyRate();
}
