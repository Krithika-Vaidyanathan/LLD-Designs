package components;

public class CourierPartner {
    private String courierId;
    private String name;

    public CourierPartner(String courierId, String name) {
        this.courierId = courierId;
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
