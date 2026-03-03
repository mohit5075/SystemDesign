import java.time.LocalDateTime;

public class Ticket {
    private String ticketId;
    private Vehicle vehicle;
    private ParkingSpot parkingSpot;
    private LocalDateTime entryTime;
    private LocalDateTime exitTime;
    private TicketStatus ticketStatus;

    public Ticket(String ticketId, Vehicle vehicle, ParkingSpot parkingSpot) {
        this.ticketId = ticketId;
        this.vehicle = vehicle;
        this.entryTime = LocalDateTime.now();
        this.parkingSpot = parkingSpot;
    }

    public void markExit() {
        this.exitTime = LocalDateTime.now();
    }
    public Vehicle getVehicle() {
        return vehicle;
    }
    public LocalDateTime getEntryTime() {
        return entryTime;
    }
    public LocalDateTime getExitTime() {
        return exitTime;
    }
    public void closeTicket(PricingStrategy pricingStrategy) {
        this.exitTime = LocalDateTime.now();
        int price = pricingStrategy.calculatePrice(this);
        System.out.println("Total parking fee for ticket " + ticketId + " is: " + price);
        parkingSpot.removeVehicle();
        this.ticketStatus = TicketStatus.CLOSED;
    }
}
