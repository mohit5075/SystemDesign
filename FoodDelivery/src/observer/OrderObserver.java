package observer;

import models.Order;

public interface OrderObserver {
    void updateOrderStatus(Order order);
}
