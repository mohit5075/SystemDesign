package service;

import entities.Seat;
import entities.User;
import enums.SeatStatus;
import repo.SeatRepo;
import repo.ShowRepo;
import repo.UserRepo;
import strategy.PaymentStrategy;

import java.util.ArrayList;
import java.util.List;

public class BookingService {
    private final SeatRepo seatRepo;
    private final PaymentStrategy paymentStrategy;
    private final ShowRepo showRepo;
    private final UserRepo userRepo;
    public BookingService(SeatRepo seatRepo, PaymentStrategy paymentStrategy, ShowRepo showRepo, UserRepo userRepo) {
        this.seatRepo = seatRepo;
        this.paymentStrategy = paymentStrategy;
        this.showRepo = showRepo;
        this.userRepo = userRepo;
    }

    public void bookSeats(List<String> seatIds,String userId,String showId){
        List<Seat> seats = new ArrayList<>();
        for(String id : seatIds){
            Seat seat = seatRepo.getSeat(id);
            seats.add(seat);
            if(!checkAvailability(seat)){
                return;
            }
        }
        for(Seat seat : seats){
            seat.setSeatStatus(SeatStatus.LOCKED);
        }
        int price = calculatePrice(seats);
        paymentStrategy.pay(price);
        for(Seat seat : seats){
            seat.setSeatStatus(SeatStatus.BOOKED);
        }
    }

    private void bookSeat(Seat seat){
        synchronized (seat){

        }
    }

    private boolean checkAvailability(Seat seat){
        if(seat.getSeatStatus().equals(SeatStatus.AVAILABLE))return true;
        return false;
    }

    private int calculatePrice(List<Seat>seats){
        int price =0;
        for(Seat seat : seats)price+=seat.getCost();
        return price;
    }
}
