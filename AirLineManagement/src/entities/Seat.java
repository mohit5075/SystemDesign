package entities;

import enums.SeatType;

public class Seat {
    private int number;
    private SeatType seatType;
    private boolean isAvailable;

    public Seat(int number, SeatType seatType) {
        this.number = number;
        this.seatType = seatType;
        this.isAvailable = true;
    }

    public int getNumber() {
        return number;
    }

    public SeatType getSeatType() {
        return seatType;
    }

    public boolean isAvailable() {
        return isAvailable;
    }

    public void setAvailable(boolean available) {
        isAvailable = available;
    }
}
