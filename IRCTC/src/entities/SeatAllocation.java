package entities;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

public class SeatAllocation {
    private String trainId;
    private int seatId;
    private LocalDate date;
    private Set<Integer> seatAlloc;

    public SeatAllocation(String trainId, int seatId, LocalDate date) {
        this.trainId = trainId;
        this.seatId = seatId;
        this.date = date;
        this.seatAlloc = new HashSet<>();
    }

    public String getTrainId() {
        return trainId;
    }

    public void setTrainId(String trainId) {
        this.trainId = trainId;
    }

    public int getSeatId() {
        return seatId;
    }

    public void setSeatId(int seatId) {
        this.seatId = seatId;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public Set<Integer> getSeatAlloc() {
        return seatAlloc;
    }

    public void setSeatAlloc(Set<Integer> seatAlloc) {
        this.seatAlloc = seatAlloc;
    }
}
