package service;

import entities.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class IrctcService {
    private Map<String, Train> trainMap = new HashMap<>();
    private Map<String, Booking> bookings = new HashMap<>();
    private Map<String, SeatAllocation>seatAllocations = new HashMap<>();
    private Map<String, Stop> stopMap = new HashMap<>();

    public List<Train> getTrains(String src, String dest, LocalDate date){
        List<Train>trains = new ArrayList<>();
        for(Train train : trainMap.values()){
            List<Stop> stops = train.getStops();
            int idx1 =-1;
            int idx2=-1;
            for(Stop stop : stops){
                if(stop.getStation().getCode().equals(src)){
                    idx1 = getStopIndex(train,stop);
                }
                if(stop.getStation().getCode().equals(dest)){
                    idx2 = getStopIndex(train,stop);
                }

            }
            if(idx1<idx2)trains.add(train);
        }
        return trains;
    }
    int getStopIndex(Train train,Stop stop){
        return train.getStops().indexOf(stop);
    }
    int getStopIdx(Train train,String str){
        List<Stop>stops = train.getStops();
        for(int i=0;i<stops.size();i++){
            if(stops.get(i).getStation().getCode().equals(str))return i;
        }
        return -1;
    }

    public int getAvailableSeats(String src,String dest,String trainId,LocalDate date){
        Train train = trainMap.get(trainId);
        List<Seat> seats=  train.getSeats();
        int sourceIdx = getStopIdx(train,src);
        int destIdx = getStopIdx(train,dest);
        int cnt=0;
        for(Seat seat : seats){
            String id = seat.getId()+" "+trainId+" "+date;
            SeatAllocation seatAllocation = seatAllocations.get(id);
            if(seatAllocation==null){
                cnt++;continue;
            }
            boolean f=true;
            for(int i=sourceIdx;i<destIdx;i++){
                if(seatAllocation.getSeatAlloc().contains(i)){
                    f=false;break;
                }
            }
            if(f)cnt++;
        }
        return cnt;
    }

    public void book(String src,String dest,String trainId,LocalDate date,int seatId){
        Train train = trainMap.get(trainId);
        int sourceIdx = getStopIdx(train,src);
        int destIdx = getStopIdx(train,dest);
        String id = seatId+" "+trainId+" "+date;
        SeatAllocation seatAllocation = seatAllocations.get(id);
        if(seatAllocation==null){
            seatAllocation = new SeatAllocation(trainId,seatId,date);
        }
        for(int i=sourceIdx;i<destIdx;i++){
            if(seatAllocation.getSeatAlloc().add(i));
        }
    }

}
