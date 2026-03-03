package models;

import enums.OrderStatus;
import observer.OrderObserver;

import java.util.List;

public class Order {
    private String id;
    private Customer customer;
    private DeliveryAgent deliveryAgent;
    private Restaurant restaurant;
    private OrderStatus orderStatus;
    private List<OrderObserver> observers;
    private List<OrderItem> orderItems;
    public Order(String id, Customer customer, Restaurant restaurant, List<OrderItem> orderItems) {
        this.id = id;
        this.customer = customer;
        this.restaurant = restaurant;
        this.orderItems = orderItems;
        this.orderStatus = OrderStatus.PENDING;
    }
    public String getId() {
        return id;
    }
    public Customer getCustomer() {
        return customer;
    }
    public OrderStatus getOrderStatus() {
        return orderStatus;
    }
    public void setOrderStatus(OrderStatus orderStatus) {
        this.orderStatus = orderStatus;
        notifyObservers();
    }
    private void notifyObservers() {
        for (OrderObserver observer : observers) {
            observer.updateOrderStatus(this);
        }
    }
    public void addObserver(OrderObserver observer) {
        observers.add(observer);
    }
    public void removeObserver(OrderObserver observer) {
        observers.remove(observer);
    }
    public void setDeliveryAgent(DeliveryAgent deliveryAgent) {
        this.deliveryAgent = deliveryAgent;
        observers.add(deliveryAgent);
        deliveryAgent.setAvailable(false);
    }
    public boolean cancelOrder() {
        if( orderStatus == OrderStatus.PENDING || orderStatus == OrderStatus.PREPARING)
        {
            setOrderStatus(OrderStatus.CANCELLED);
            if( deliveryAgent != null ) {
                deliveryAgent.setAvailable(true);
            }
            return true;
        }
        return false;
    }
    public Customer getCustomerDetails() {
        return customer;
    }
    public Restaurant getRestaurantDetails() {
        return restaurant;
    }
}
