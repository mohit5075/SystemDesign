package entities;

import java.util.List;

public class Train {
    private String id;
    private String name;
    private List<Stop> stops;
    private List<Seat> seats;

    public Train(String id, String name, List<Stop> stops, List<Seat> seats) {
        this.id = id;
        this.name = name;
        this.stops = stops;
        this.seats = seats;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Stop> getStops() {
        return stops;
    }

    public void setStops(List<Stop> stops) {
        this.stops = stops;
    }

    public List<Seat> getSeats() {
        return seats;
    }

    public void setSeats(List<Seat> seats) {
        this.seats = seats;
    }
}
