package service;

import entities.Seat;
import entities.Show;
import entities.User;
import enums.SeatStatus;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class SeatLockManager {
    private final ScheduledExecutorService scheduler = Executors.newScheduledThreadPool(1);
    private Map<Show, Map<Seat,User>> lockedMap = new HashMap<>();
    public void lockSeat(List<Seat> seats, User user, Show show){
        for(Seat seat : seats){
            if (!seat.getSeatStatus().equals(SeatStatus.AVAILABLE))return;
        }
        seats.forEach(seat -> seat.setSeatStatus(SeatStatus.LOCKED));
        scheduler.schedule(()->
            unlockSeats(seats,user,show),500, TimeUnit.MILLISECONDS
        );
    }
    public void unlockSeats(List<Seat> seats,User user, Show show){
        Map<Seat,User> seatUserMap = lockedMap.get(show);
        for(Map.Entry<Seat,User> entry : seatUserMap.entrySet()){
            Seat seat = entry.getKey();
            User lockedUser = entry.getValue();
            seat.setSeatStatus(SeatStatus.AVAILABLE);
        }
    }
}
