package components;

import strategy.PaymentStrategy;

public class PaymentProcessor {

    private PaymentStrategy strategy;

    public PaymentProcessor(PaymentStrategy strategy) {
        this.strategy = strategy;
    }

    public boolean process(double amount) {
        return strategy.pay(amount);
    }
}
