package models;

public class DeliveryAgent extends User {
    private boolean isAvailable;
    private Address location;
    public DeliveryAgent(String id, String name, String email) {
        super(id, name, email);
    }
    public void setAvailable(boolean available) {
        isAvailable = available;
    }
    public boolean isAvailable() {
        return isAvailable;
    }
    public Address getLocation() {
        return location;
    }
    public void setLocation(Address location) {
        this.location = location;
    }

    @Override
    public void updateOrderStatus(Order order) {

    }
}
