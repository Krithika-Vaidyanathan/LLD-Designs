package strategy;

import components.PaymentProcessor;

public class CashPaymentProcessor implements PaymentProcessor {

    @Override
    public boolean processPayment(double amount) {
        System.out.println("Paid $" + amount  + " using Cash");
        return true;
    }
}
