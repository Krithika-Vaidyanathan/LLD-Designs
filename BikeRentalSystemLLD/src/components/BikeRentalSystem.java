package components;

import enums.ProductStatus;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

public class BikeRentalSystem {

    private Map<String, Product> products = new HashMap<>();
    private Map<String, Rental> rentals = new HashMap<>();

    public void addProduct(Product product) {
        products.put(product.getProductId(), product);
    }
    public Rental rentProduct(String rentalId, String productId, Customer customer, LocalDateTime start, LocalDateTime end) {
        Product product = products.get(productId);

        if(product == null || product.getStatus() != ProductStatus.AVAILABLE) {
            throw new RuntimeException("Product not available");
        }
        product.markRented();
        Rental rental = new Rental(rentalId, product, customer, start, end);
        double amount = rental.calculateTotalAmount();
        customer.addCharge(amount);

        rentals.put(rentalId, rental);
        return rental;
    }

    public void returnProduct(String rentalId) {
        Rental rental = rentals.get(rentalId);
        rental.closeRental();
    }

    //strategy is chosen at runtime
    public void processPayment(Customer customer, double amount, PaymentProcessor paymentProcessor) {
        if(paymentProcessor.processPayment(amount)) {
            customer.pay(amount);
        }
    }
}
