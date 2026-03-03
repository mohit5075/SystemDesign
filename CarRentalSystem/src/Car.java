public class Car {
    private int id;
    private String brand;
    private int pricePerDay;
    private String model;
    private boolean isAvailable;
    private int ownerId;
    private String licensePlate;
    public Car(int id, String brand, String model, int pricePerDay, boolean isAvailable, int ownerId, String licensePlate) {
        this.id = id;
        this.pricePerDay = pricePerDay;
        this.isAvailable = isAvailable;
        this.ownerId = ownerId;
        this.licensePlate = licensePlate;
        this.model=model;
        this.brand=brand;
    }
    public int getId() {
        return id;
    }
    public int getPricePerDay() {
        return pricePerDay;
    }
    public boolean isAvailable() {
        return isAvailable;
    }
    public void setAvailable(boolean available) {
        isAvailable = available;
    }
    public int getOwnerId() {
        return ownerId;
    }
    public String getLicensePlate() {
        return licensePlate;
    }
    public String getBrand() {
        return brand;
    }
    public String getModel() {
        return model;
    }
}
