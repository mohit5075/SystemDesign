package state;

import entities.Driver;
import entities.Trip;

public class CompletedState implements TripState{
    @Override
    public void request(Trip trip) {
        System.out.println("Cannot request a trip that is already completed.");
    }

    @Override
    public void setDriver(Driver driver, Trip trip) {
        System.out.println("Cannot assign a driver to a completed trip.");
    }

    @Override
    public void startTrip(Trip trip) {
        System.out.println("Cannot start a completed trip.");
    }

    @Override
    public void completeTrip(Trip trip) {
        System.out.println("Trip is already completed.");
    }
}
