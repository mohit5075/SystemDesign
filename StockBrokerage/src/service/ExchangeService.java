package service;

import entities.Order;
import entities.OrderBook;

import java.util.concurrent.ConcurrentHashMap;

public class ExchangeService {
    private ConcurrentHashMap<String, OrderBook> orderBooks;

    public ExchangeService() {
        this.orderBooks = new ConcurrentHashMap<>();
    }
    public void addOrder(Order order){
        orderBooks.computeIfAbsent(order.getStock(),k->new OrderBook()).addOrder(order);
        match(order);
    }
    private void match(Order order){
        while(order.)
    }
}
