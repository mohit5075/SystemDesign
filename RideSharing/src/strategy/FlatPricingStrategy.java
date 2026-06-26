package strategy;

import entities.Location;
import enums.VehicleType;

import java.util.Map;

public class FlatPricingStrategy implements PricingStrategy{
    private static int basePrice = 100;
    private static int perKm = 2;
    @Override
    public int price(Location src, Location dest, VehicleType vehicleType) {
        return basePrice*src.distance(dest)*2;
    }
}
