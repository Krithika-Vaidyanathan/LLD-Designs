package components;

public class Customer {
    private String customerId;
    private String name;
    private double balance;

    public Customer(String customerId, String name) {
        this.customerId = customerId;
        this.name = name;
        this.balance = 0.0;
    }

    public void addCharge(double amount) {
        balance += amount;
    }
    public void pay(double amount) {
        balance-=amount;
    }
    public double getBalance() {
        return  balance;
    }
    public String getName() {
        return  name;
    }
}
