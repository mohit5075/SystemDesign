import enums.OrderStatus;
import models.*;
import strategy.DeliveryAgentStrategy;

import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.concurrent.ConcurrentHashMap;

public class FoodDeliveryService {
    private final Map<String, Customer> customers = new ConcurrentHashMap<>();
    private final Map<String, Restaurant> restaurants = new ConcurrentHashMap<>();
    private final Map<String, DeliveryAgent> deliveryAgents = new ConcurrentHashMap<>();
    private final Map<String, Order> orders = new ConcurrentHashMap<>();
    private static FoodDeliveryService foodDeliveryService;
    private DeliveryAgentStrategy deliveryAgentStrategy;

    private FoodDeliveryService() {
    }
    public static FoodDeliveryService getInstance() {
        if (foodDeliveryService == null) {
            synchronized (FoodDeliveryService.class) {
                if (foodDeliveryService == null) {
                    foodDeliveryService = new FoodDeliveryService();
                }
            }
        }
        return foodDeliveryService;
    }
    public void setDeliveryAgentStrategy(DeliveryAgentStrategy deliveryAgentStrategy) {
        this.deliveryAgentStrategy = deliveryAgentStrategy;
    }
    public void registerCustomer(Customer customer) {
        customers.put(customer.getId(), customer);
    }
    public void registerRestaurant(Restaurant restaurant) {
        restaurants.put(restaurant.getId(), restaurant);
    }
    public void registerDeliveryAgent(DeliveryAgent deliveryAgent) {
        deliveryAgents.put(deliveryAgent.getId(), deliveryAgent);
    }
    public void placeOrder(String restaurantId, String customerId, List<OrderItem> orderItems){
        Restaurant restaurant = restaurants.get(restaurantId);
        Customer customer = customers.get(customerId);
        Order order = new Order(generateOrderId(), customer, restaurant, orderItems);
        orders.put(order.getId(), order);
    }
    private String generateOrderId() {
        return "ORDER-" + (orders.size() + 1);
    }
    public void updateOrderStatus(String orderId, OrderStatus status) {
        Order order = orders.get(orderId);
        if (order != null) {
            order.setOrderStatus(status);
            assignDeliveryAgent(order);
        }
    }
    public void assignDeliveryAgent(Order order) {
        if (order != null) {
            List<DeliveryAgent> availableAgents = deliveryAgents.values().stream()
                    .filter(DeliveryAgent::isAvailable)
                    .toList();
            deliveryAgentStrategy.findAgent(availableAgents, order).ifPresent(order::setDeliveryAgent);
        }
    }

    public Menu getRestaurantMenu(String restaurantId) {
        Restaurant restaurant = restaurants.get(restaurantId);
        if (restaurant == null) {
            throw new NoSuchElementException("Restaurant with ID " + restaurantId + " not found.");
        }
        return restaurant.getMenu();
    }
}
