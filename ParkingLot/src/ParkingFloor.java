import java.util.List;

public class ParkingFloor {
    private int floorNumber;
    private List<ParkingSpot> parkingSpots;
    ParkingFloor(int floorNumber, List<ParkingSpot> parkingSpots) {
        this.floorNumber = floorNumber;
        this.parkingSpots = parkingSpots;
    }
    public int getFloorNumber() {
        return floorNumber;
    }
    public List<ParkingSpot> getParkingSpots() {
        return parkingSpots;
    }
    public ParkingSpot getPakingSpotByVehicle(Vehicle vehicle) {
        for (ParkingSpot spot : parkingSpots) {
            if (spot.isFree() && spot.getSpotType().equals(vehicle.getVehicleType())) {
                return spot;
            }
        }
        return null;
    }
}
