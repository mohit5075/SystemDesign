package state;

import entities.Driver;
import entities.Trip;

public class RequestedState implements TripState {
    @Override
    public void request(Trip trip) {
        System.out.println("Trip is already in requested state.");
    }

    @Override
    public void setDriver(Driver driver, Trip trip) {
        trip.setDriverId(driver.getId());
        trip.setTripState(new AssignedState());
    }

    @Override
    public void startTrip(Trip trip) {
        System.out.println("Cannot start a trip that has not been assigned a driver.");
    }

    @Override
    public void completeTrip(Trip trip) {
        System.out.println("Cannot end a trip that has not been assigned a driver.");
    }
}
