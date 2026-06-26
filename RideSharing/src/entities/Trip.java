package entities;

import enums.TripStatus;
import observer.TripObserver;
import state.RequestedState;
import state.TripState;

import java.util.List;
import java.util.UUID;

public class Trip {
    private String id;
    private String driverId;
    private String riderId;
    private int price;
    private TripState tripState;
    private TripStatus tripStatus;
    private List<TripObserver> tripObservers;
    private Location src;
    private Location dest;

    public Trip(String driverId, String riderId, int price,Location src,Location dest) {
        this.id = UUID.randomUUID().toString();
        this.driverId = driverId;
        this.riderId = riderId;
        this.price = price;
        this.tripStatus = TripStatus.REQUESTED;
        this.tripState = new RequestedState();
        this.src = src;
        this.dest = dest;
    }

    public TripState getTripState() {
        return tripState;
    }

    public void setTripState(TripState tripState) {
        this.tripState = tripState;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getDriverId() {
        return driverId;
    }

    public void setDriverId(String driverId) {
        this.driverId = driverId;
    }

    public String getRiderId() {
        return riderId;
    }

    public void setRiderId(String riderId) {
        this.riderId = riderId;
    }
    public void setTripStatus(TripStatus tripStatus){
        this.tripStatus=  tripStatus;
    }
    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }
    public void startTrip(){
        tripState.startTrip(this);
        notifyObservers();
    }

    public void endTrip(){
        tripState.completeTrip(this);
        notifyObservers();
    }
    public void notifyObservers(){
        tripObservers.forEach(o->o.notify(this));
    }

    public void addObserver(TripObserver tripObserver){
        tripObservers.add(tripObserver);
    }

    public TripStatus getTripStatus() {
        return tripStatus;
    }

    public List<TripObserver> getTripObservers() {
        return tripObservers;
    }

    public void setTripObservers(List<TripObserver> tripObservers) {
        this.tripObservers = tripObservers;
    }

    public Location getSrc() {
        return src;
    }

    public void setSrc(Location src) {
        this.src = src;
    }

    public Location getDest() {
        return dest;
    }

    public void setDest(Location dest) {
        this.dest = dest;
    }
}
