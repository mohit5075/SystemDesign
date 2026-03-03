package models;

import java.util.List;

public class Menu {
    private String id;
    private String restaurantId;
    private List<MenuItem> items;
    public Menu(String id, String restaurantId, List<MenuItem> items) {
        this.id = id;
        this.restaurantId = restaurantId;
        this.items = items;
    }
    public String getId() {
        return id;
    }
    public String getRestaurantId() {
        return restaurantId;
    }
    public List<MenuItem> getItems() {
        return items;
    }
    public void addItem(MenuItem item) {
        items.add(item);
    }
    public void removeItem(MenuItem item) {
        items.remove(item);
    }
    public MenuItem getItemById(String itemId) {
        for (MenuItem item : items) {
            if (item.getId().equals(itemId)) {
                return item;
            }
        }
        return null;
    }
}
