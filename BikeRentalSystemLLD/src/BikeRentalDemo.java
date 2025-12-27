import components.*;
import enums.BikeSize;
import enums.ScooterType;
import strategy.CashPaymentProcessor;

import java.time.LocalDateTime;

public class BikeRentalDemo {
    public static void main(String[] args) throws InterruptedException {
        BikeRentalSystem system = new BikeRentalSystem();

        //Inventory
        Product bike = new Bike("B1", BikeSize.MEDIUM);
        Product scooter = new Scooter("S1", ScooterType.ELECTRIC);

        system.addProduct(bike);
        system.addProduct(scooter);

        //Customer
        Customer customer = new Customer("C1", "Krithika");

        //Rental
        LocalDateTime start = LocalDateTime.now();
        LocalDateTime end = start.plusHours(3);

        Rental rental = system.rentProduct("R1", "B1", customer, start, end);
        System.out.println("Balance after rental: $" + customer.getBalance());
        Thread.sleep(5000);

        //Choose payment method at runtime
        PaymentProcessor cashPayment = new CashPaymentProcessor();
        system.processPayment(customer, customer.getBalance(), cashPayment);
        System.out.println("Balance after payment: $"+ customer.getBalance());
    }
}
