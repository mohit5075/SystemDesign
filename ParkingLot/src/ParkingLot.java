import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentLinkedQueue;

public class ParkingLot {
    private ConcurrentHashMap<SpotType, ConcurrentLinkedQueue<ParkingSpot>> availableSpots;
    private List<ParkingFloor> parkingFloors;
    public ParkingLot() {
        this.availableSpots = new ConcurrentHashMap<>();
        this.parkingFloors = new ArrayList<>();
        for (SpotType spotType : SpotType.values()) {
            availableSpots.put(spotType, new ConcurrentLinkedQueue<>());
        }
    }
    public ConcurrentHashMap<SpotType, ConcurrentLinkedQueue<ParkingSpot>> getAvailableSpots() {
        return availableSpots;
    }
    public void addParkingFloor(ParkingFloor parkingFloor) {
        this.parkingFloors.add(parkingFloor);
    }
    public void setAvailableSpots(ConcurrentHashMap<SpotType, ConcurrentLinkedQueue<ParkingSpot>> availableSpots) {
        this.availableSpots = availableSpots;
    }
    public void addParkingSpot(ParkingSpot parkingSpot) {
        SpotType spotType = parkingSpot.getSpotType();
        availableSpots.get(spotType).add(parkingSpot);
    }
    public ParkingSpot getParkingSpot(SpotType spotType) {
        return availableSpots.get(spotType).poll();
    }
    public Ticket parkVehicle(Vehicle vehicle) {
        for (ParkingFloor floor : parkingFloors) {
            ParkingSpot spot = floor.getPakingSpotByVehicle(vehicle);
            if (spot != null && spot.occupy()) {
                return new Ticket(vehicle, spot, floor);
            }
        }
        throw new RuntimeException("No spot available");
    }
}
