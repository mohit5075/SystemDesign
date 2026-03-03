public class ParkingSpot {
    private String spotId;
    private Vehicle vehicle;
    private Boolean isFree;
    private SpotType spotType;
    ParkingSpot(String spotId, SpotType spotType) {
        this.spotId = spotId;
        this.spotType = spotType;
        this.isFree = true;
        this.vehicle = null;
    }

    public Vehicle getVehicle() {
        return vehicle;
    }

    public SpotType getSpotType() {
        return spotType;
    }

    public void setSpotType(SpotType spotType) {
        this.spotType = spotType;
    }
    public void removeVehicle() {
        this.vehicle = null;
        this.isFree = true;
    }
    public void assignVehicle(Vehicle vehicle) {
        this.vehicle = vehicle;
        this.isFree = false;
    }
    public boolean isFree() {
        return isFree;
    }
}
