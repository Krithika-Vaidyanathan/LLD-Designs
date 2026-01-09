package strategy;

public class CardPaymentStrategy implements PaymentStrategy {

    @Override
    public boolean pay(double amount) {
        System.out.println("Paid Rs." + (int) amount + " using CARD");
        return true;
    }
}
