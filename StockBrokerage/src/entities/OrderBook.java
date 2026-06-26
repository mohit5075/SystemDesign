package entities;

import enums.OrderType;

import java.util.PriorityQueue;

public class OrderBook {
    private PriorityQueue<Order>buyOrders = new PriorityQueue<>((a,b)->{
        return b.getPrice()-a.getPrice();
    });
    private PriorityQueue<Order>sellOrders = new PriorityQueue<>();
    public void addOrder(Order order){
        if(order.getOrderType().equals(OrderType.BUY))buyOrders.add(order);
        else sellOrders.add(order);
    }
}
