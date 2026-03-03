public class HourlyPricingStrategy implements PricingStrategy{
    @Override
    public int calculatePrice(Ticket ticket) {
        long hoursParked = java.time.Duration.between(ticket.getEntryTime(), ticket.getExitTime()).toHours();
        double durationInHours = Math.ceil(hoursParked);
        return switch (ticket.getVehicle().getVehicleType()) {
            case VehicleType.BIKE -> 10 * (int) durationInHours; // Flat rate for bikes
            case VehicleType.TRUCK -> 30 * (int) durationInHours; // Flat rate for trucks
            case VehicleType.CAR -> 20 * (int) durationInHours; // Flat rate for cars
        };
    }
}
