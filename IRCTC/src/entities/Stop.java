package entities;

import java.time.LocalDateTime;

public class Stop {
    private Station station;
    private LocalDateTime arrivalTime;
    private LocalDateTime departureTime;

    public Stop(Station station, LocalDateTime arrivalTime, LocalDateTime departureTime) {
        this.station = station;
        this.arrivalTime = arrivalTime;
        this.departureTime = departureTime;
    }

    public Station getStation() {
        return station;
    }

    public void setStation(Station station) {
        this.station = station;
    }

    public LocalDateTime getArrivalTime() {
        return arrivalTime;
    }

    public void setArrivalTime(LocalDateTime arrivalTime) {
        this.arrivalTime = arrivalTime;
    }

    public LocalDateTime getDepartureTime() {
        return departureTime;
    }

    public void setDepartureTime(LocalDateTime departureTime) {
        this.departureTime = departureTime;
    }
}
