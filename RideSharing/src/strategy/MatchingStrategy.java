package strategy;

import entities.Driver;
import entities.Location;
import enums.VehicleType;

import java.util.List;

public interface MatchingStrategy {
    List<Driver> getDrivers(List<Driver> drivers, Location src, Location dest, VehicleType vehicleType);
}
