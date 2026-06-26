package entities;

import enums.SeatCategory;
import enums.SeatStatus;

public class Seat {
    private String id;
    private SeatCategory seatCategory;
    private int cost;
    private SeatStatus seatStatus;

    public Seat(SeatCategory seatCategory, int cost, SeatStatus seatStatus) {
        this.seatCategory = seatCategory;
        this.cost = cost;
        this.seatStatus = seatStatus;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public SeatCategory getSeatCategory() {
        return seatCategory;
    }

    public void setSeatCategory(SeatCategory seatCategory) {
        this.seatCategory = seatCategory;
    }

    public int getCost() {
        return cost;
    }

    public void setCost(int cost) {
        this.cost = cost;
    }

    public SeatStatus getSeatStatus() {
        return seatStatus;
    }

    public void setSeatStatus(SeatStatus seatStatus) {
        this.seatStatus = seatStatus;
    }
}
