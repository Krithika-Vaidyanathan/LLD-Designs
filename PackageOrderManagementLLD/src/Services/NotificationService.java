package Services;

import components.Customers;

public class NotificationService {

    public void notifyCustomer(Customers customer, String message) {
        System.out.println("Notification sent to:- " + customer.getName() + ": " + message);
    }
}
