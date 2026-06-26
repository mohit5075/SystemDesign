package strategy;

import entities.Location;
import enums.VehicleType;

public interface PricingStrategy {
    int price(Location src, Location dest, VehicleType vehicleType);
}
