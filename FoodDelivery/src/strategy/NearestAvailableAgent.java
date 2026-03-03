package strategy;

import models.Customer;
import models.DeliveryAgent;
import models.Order;
import models.Restaurant;

import java.util.Comparator;
import java.util.List;
import java.util.Optional;

public class NearestAvailableAgent implements DeliveryAgentStrategy{
    @Override
    public Optional<DeliveryAgent> findAgent(List<DeliveryAgent> deliveryAgents, Order order) {
        return deliveryAgents.stream().min(Comparator.comparingDouble(agent->calculateDistance(agent, order)));
    }
    private double calculateDistance(DeliveryAgent agent, Order order){
        Customer customer = order.getCustomer();
        Restaurant restaurant  = order.getRestaurantDetails();
        double resToAgent = restaurant.getAddress().distanceTo(agent.getLocation());
        double resToCustomer = restaurant.getAddress().distanceTo(customer.getAddress());
        return resToAgent + resToCustomer;
    }
}
