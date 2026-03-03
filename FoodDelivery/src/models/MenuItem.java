package models;

public class MenuItem {
    private String id;
    private String name;
    private int price;
    private boolean isAvailable;
    public MenuItem(String id, String name, int price, boolean isAvailable) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.isAvailable = isAvailable;
    }
    public String getId() {
        return id;
    }
    public String getName() {
        return name;
    }
    public int getPrice() {
        return price;
    }
    public boolean isAvailable() {
        return isAvailable;
    }
}
