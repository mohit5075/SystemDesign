package service;

import entities.Order;
import entities.User;
import enums.OrderType;

import java.util.HashMap;
import java.util.Map;

public class BrokerageService {
    private Map<String, User>userMap = new HashMap<>();
    public void createOrder(Order order){
        User user = userMap.get(order.getUserId());
        int price = order.getPrice();
        int quantity = order.getQuantity();
        if(order.getOrderType().equals(OrderType.BUY) && user.getAccount().getAmount()<price*quantity){
            throw new RuntimeException("Insifficient Funds");
        }

    }
}
