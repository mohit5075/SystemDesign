package repo;

import entities.Seat;

import java.util.HashMap;
import java.util.Map;

public class SeatRepo {
    private Map<String, Seat> seatMap;
    public SeatRepo(){
        seatMap = new HashMap<>();
    }
    public void addSeat(Seat seat){
        seatMap.putIfAbsent(seat.getId(),seat);
    }
    public Seat getSeat(String id){
        return seatMap.get(id);
    }
}
