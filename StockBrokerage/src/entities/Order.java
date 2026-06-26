package entities;

import enums.Category;
import enums.OrderStatus;
import enums.OrderType;

public class Order {
    private String id;
    private String stock;
    private OrderType orderType;
    private int quantity;

    private Category category;
    private int price;
    private OrderStatus orderStatus;
    private String userId;

    public Order(String stock, OrderType orderType, Category category, int price, String userId,int quantity) {
        this.stock = stock;
        this.orderType = orderType;
        this.category = category;
        this.price = price;
        this.orderStatus = OrderStatus.PENDING;
        this.userId = userId;
        this.quantity = quantity;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getStock() {
        return stock;
    }

    public void setStock(String stock) {
        this.stock = stock;
    }

    public OrderType getOrderType() {
        return orderType;
    }

    public void setOrderType(OrderType orderType) {
        this.orderType = orderType;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public OrderStatus getOrderStatus() {
        return orderStatus;
    }

    public void setOrderStatus(OrderStatus orderStatus) {
        this.orderStatus = orderStatus;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }
}

//nums = [4,3,2,3,5,2,1], k = 4
// 41   3,2  32  5