package strategy;

import entities.Location;
import enums.VehicleType;

import java.util.Map;

public class VehicleBasedPricingStrategy implements PricingStrategy{
    private static int basePrice = 100;
    private Map<VehicleType,Integer> priceMap = Map.of(
            VehicleType.BIKE, 10,
            VehicleType.AUTO,20,
            VehicleType.CAR,30
    );
    @Override
    public int price(Location src, Location dest, VehicleType vehicleType) {
        return basePrice+priceMap.get(vehicleType)*src.distance(dest);
    }
}
