package components;

import enums.ProductStatus;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

/**
 * BikeRentalSystem acts as the main orchestrator.
 * It manages products, rentals, and delegates payment processing.
 */
public class BikeRentalSystem {

    // Stores all products available in the system (productId → Product)
    private Map<String, Product> products = new HashMap<>();

    // Stores all active and completed rentals (rentalId → Rental)
    private Map<String, Rental> rentals = new HashMap<>();

    /**
     * Adds a new product (Bike/Scooter) to the inventory.
     * The system manages products but does not own their lifecycle.
     */
    public void addProduct(Product product) {
        products.put(product.getProductId(), product);
    }

    /**
     * Handles renting a product.
     * Flow:
     * 1. Validate product availability
     * 2. Mark product as rented
     * 3. Create a Rental entity
     * 4. Calculate initial charges
     * 5. Associate rental with customer
     */
    public Rental rentProduct(
            String rentalId,
            String productId,
            Customer customer,
            LocalDateTime start,
            LocalDateTime end) {

        // Fetch product from inventory
        Product product = products.get(productId);

        // Validate product existence and availability
        if (product == null || product.getStatus() != ProductStatus.AVAILABLE) {
            throw new RuntimeException("Product not available");
        }

        // Update product state
        product.markRented();

        // Create rental linking product and customer
        Rental rental = new Rental(rentalId, product, customer, start, end);

        // Calculate rental cost and add to customer's balance
        double amount = rental.calculateTotalAmount();
        customer.addCharge(amount);

        // Store rental for tracking
        rentals.put(rentalId, rental);

        return rental;
    }

    /**
     * Handles return of a rented product.
     * Closing the rental updates rental state and frees the product.
     */
    public void returnProduct(String rentalId) {
        Rental rental = rentals.get(rentalId);

        // Close rental (marks product AVAILABLE internally)
        rental.closeRental();

        // Logging return confirmation
        System.out.println(
                "Product: " + rental.getProduct().productId +
                        ", Returned Status: " + rental.getProduct().status
        );
    }

    /**
     * Displays all products with their current availability status.
     * Useful for inventory checks.
     */
    public void getAvailableProducts() {
        for (Product product : products.values()) {
            System.out.println(
                    "Product: " + product.getProductId() +
                            ", Status: " + product.getStatus()
            );
        }
    }

    /**
     * Displays all products currently rented by a given customer.
     * Uses rentals as the source of truth.
     */
    public void showProductsRentedByCustomer(Customer customer) {
        for (Rental rental : rentals.values()) {
            if (rental.getCustomer().equals(customer)) {
                System.out.println(
                        "Customer: " + customer.getName() +
                                ", rented ProductId: " + rental.getProduct().getProductId()
                );
            }
        }
    }

    /**
     * Processes payment using a strategy selected at runtime.
     * BikeRentalSystem depends on the abstraction (PaymentProcessor),
     * not concrete payment implementations.
     */
    public void processPayment(
            Customer customer,
            double amount,
            PaymentProcessor paymentProcessor) {

        // Execute payment strategy
        if (paymentProcessor.processPayment(amount)) {
            customer.pay(amount);
        }
    }
}
