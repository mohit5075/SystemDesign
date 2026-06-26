package entities;

import enums.DriverState;
import enums.VehicleType;

import java.util.UUID;

public class Driver extends User{
    private String id;
    private VehicleType vehicleType;
    private DriverState driverState;
    public Driver(String name, String email, Location location,VehicleType vehicleType) {
        super(name, email, location);
        this.vehicleType = vehicleType;
        this.id = UUID.randomUUID().toString();
        this.driverState = DriverState.AVAILABLE;
    }
    public String getId() {
        return id;
    }

    public VehicleType getVehicleType() {
        return vehicleType;
    }

    public void setVehicleType(VehicleType vehicleType) {
        this.vehicleType = vehicleType;
    }

    public DriverState getDriverState() {
        return driverState;
    }

    public void setDriverState(DriverState driverState) {
        this.driverState = driverState;
    }
}
