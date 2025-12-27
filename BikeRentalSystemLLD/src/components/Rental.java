package components;

import java.time.Duration;
import java.time.LocalDateTime;

public class Rental {
    private String rentalId;
    private Product product;
    private Customer customer;
    private LocalDateTime startTime;
    private LocalDateTime endTime;
    private boolean returned;

    public Rental(String rentalId, Product product, Customer customer, LocalDateTime startTime, LocalDateTime endTime) {
        this.rentalId = rentalId;
        this.customer = customer;
        this.startTime = startTime;
        this.product = product;
        this.endTime = endTime;
        this.returned = false;
    }

    public double calculateTotalAmount() {
        long hours = Duration.between(startTime, endTime).toHours();
        if(hours==0) hours=1;
        return hours * product.getHourlyRate();
    }

    public boolean isOverdue(LocalDateTime now) {
        return !returned && now.isAfter(endTime);
    }

    public void closeRental() {
        returned = true;
        product.markAvailable();
    }

    public Customer getCustomer() {
        return customer;
    }
}
