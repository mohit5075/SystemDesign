package strategy;

import entities.Driver;
import entities.Location;
import enums.DriverState;
import enums.VehicleType;

import java.util.Comparator;
import java.util.List;

public class NearestDriverMatchingStrategy implements MatchingStrategy{
    @Override
    public List<Driver> getDrivers(List<Driver> drivers, Location src, Location dest, VehicleType vehicleType) {
        return drivers.stream()
                .filter(driver -> driver.getVehicleType().equals(vehicleType))
                .filter(driver -> driver.getDriverState().equals(DriverState.AVAILABLE))
                .sorted(Comparator.comparing(driver -> driver.getLocation().distance(src)))
                .toList();
    }
}
