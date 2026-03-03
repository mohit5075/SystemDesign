package strategy;

import models.DeliveryAgent;
import models.Order;

import java.util.List;
import java.util.Optional;

public interface DeliveryAgentStrategy {
    Optional<DeliveryAgent> findAgent(List<DeliveryAgent> deliveryAgents, Order order);
}
