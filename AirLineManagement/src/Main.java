import entities.Flight;
import entities.Passenger;
import entities.Seat;
import enums.FlightStatus;
import enums.SeatType;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        LocalDateTime departureTime = LocalDateTime.of(2026,1,30,10,30);
        LocalDateTime arrivalTime = departureTime.plusHours(2);
        Seat seat = new Seat(1, SeatType.Economy);
        List<Seat> seats = new ArrayList<>();
        seats.add(seat);
        Flight flight = new Flight("Kota","Blr", departureTime,arrivalTime, FlightStatus.OnTime,10000.0,seats);
        Passenger passenger = new Passenger("Mohit","goyalmk2001@gmail.com");
    }
}