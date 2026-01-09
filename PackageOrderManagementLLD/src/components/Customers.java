package components;

public class Customers {
    private String customerId;
    private String name;
    private String address;
    private String phone;

    public Customers(String customerId, String name, String address, String phone) {
        this.customerId = customerId;
        this.name = name;
        this.address = address;
        this.phone = phone;
    }

    public String getAddress() {
        return address;
    }

    public String getName() {
        return name;
    }

}
