package state;

import entities.Driver;
import entities.Trip;

public class InProgressState implements TripState{
    @Override
    public void request(Trip trip) {
        System.out.println("Trip already started");
    }

    @Override
    public void setDriver(Driver driver, Trip trip) {

    }

    @Override
    public void startTrip(Trip trip) {

    }

    @Override
    public void completeTrip(Trip trip) {

    }
}
