import Service.PaymentService;
import entities.*;
import enums.BookingStatus;
import enums.FlightStatus;
import strategy.PaymentStrategy;

import java.awt.print.Book;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class AirLineManagementSystem {
    private static AirLineManagementSystem instance =null;
    private PaymentStrategy paymentStrategy;
    private final PaymentService paymentService;
    private Map<String,Flight> flightMap  = new ConcurrentHashMap<>();
    private static AirLineManagementSystem getInstance(){
        if(instance==null){
            instance = new AirLineManagementSystem(new PaymentService());
        }
        return instance;
    }
    public AirLineManagementSystem(PaymentService paymentService) {
        this.paymentService = paymentService;
    }
    public void addFlight(Flight flight){
        flightMap.put(flight.getFlightId(),flight);
    }

    public Flight getFlight(String id) {
        return flightMap.get(id);
    }

    public Booking bookFlight(String flightId, Passenger passenger, Seat seat){
        Flight flight = flightMap.get(flightId);
        seat.setAvailable(false);
        Payment payment = paymentService.makePayment(flight.getFare(),paymentStrategy);
        return new Booking(flight.getFlightId(),passenger.getId(),payment, BookingStatus.Completed);
    }
    public List<String> getFlightList(String src, String dest, LocalDate date){
        return flightMap.values().stream().filter(flight -> flight.getSource().equalsIgnoreCase(src)
                && flight.getDestination().equalsIgnoreCase(dest)
                && date.getDayOfMonth()==flight.getArrivalTime().getDayOfMonth()
        ).map(Flight::getFlightId).toList();
    }

    public PaymentStrategy getPaymentStrategy() {
        return paymentStrategy;
    }

    public void setPaymentStrategy(PaymentStrategy paymentStrategy) {
        this.paymentStrategy = paymentStrategy;
    }
}
