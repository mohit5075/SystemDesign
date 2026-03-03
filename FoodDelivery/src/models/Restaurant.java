package models;

public class Restaurant {
    private String id;
    private String name;
    private Address address;
    private Menu menu;
    public Restaurant(String id, String name, Address address, Menu menu) {
        this.id = id;
        this.name = name;
        this.address = address;
        this.menu = menu;
    }
    public Menu getMenu() {
        return menu;
    }
    public void addMenuItem(MenuItem item) {
        menu.addItem(item);
    }
    public void removeMenuItem(MenuItem item) {
        menu.removeItem(item);
    }
    public Address getAddress() {
        return address;
    }
    public String getName() {
        return name;
    }
    public String getId(){
        return id;
    }
}
