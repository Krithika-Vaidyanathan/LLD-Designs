package strategy;

import components.PaymentProcessor;

public class DebitCardPaymentProcessor implements PaymentProcessor {
    @Override
    public boolean processPayment(double amount) {
        System.out.println("Paid $" + amount + " using Debit Card");
        return true;
    }
}
