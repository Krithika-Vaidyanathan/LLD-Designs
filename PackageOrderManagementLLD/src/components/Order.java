package components;

import enums.OrderStatus;

public class Order {
    private String orderId;
    private Customers sender;
    private Customers receiver;
    private Package pkg;
    private OrderStatus status;

    public Order(String orderId, Customers sender, Customers receiver, Package pkg) {
        this.orderId = orderId;
        this.sender = sender;
        this.receiver = receiver;
        this.pkg = pkg;
        this.status = OrderStatus.CREATED;
    }

    public void confirmOrder() {
        this.status = OrderStatus.CONFIRMED;
        System.out.println("Order confirmed:" + orderId);
    }

    public OrderStatus getStatus() {
        return status;
    }

    public Customers getReceiver() {
        return receiver;
    }


}
