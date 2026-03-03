package models;

import java.util.List;

public class Customer extends User {
    private Address address;
    private List<Order> orderHistory;
    public Customer(String id, String name, String email, Address address) {
        super(id, name, email);
        this.address = address;
    }
    public Address getAddress() {
        return address;
    }
    public List<Order> getOrderHistory() {
        return orderHistory;
    }
    public void addItemToOrderHistory(Order order) {
        this.orderHistory.add(order);
    }

    @Override
    public void updateOrderStatus(Order order) {
        System.out.println("Dear " + getName() + ", your order with ID: " + order.getId() + " is now " + order.getOrderStatus());
    }
}
