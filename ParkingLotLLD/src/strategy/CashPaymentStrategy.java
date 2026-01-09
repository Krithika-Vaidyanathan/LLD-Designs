package strategy;

public class CashPaymentStrategy implements PaymentStrategy {

    @Override
    public boolean pay(double amount) {
        System.out.println("Paid Rs." + (int) amount + " using CASH");
        return true;
    }
}
