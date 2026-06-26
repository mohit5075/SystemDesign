package state;

import entities.Driver;
import entities.Trip;

public class AssignedState implements TripState{
    @Override
    public void request(Trip trip) {
        System.out.println("Trip has already been requested and assigned.");
    }

    @Override
    public void setDriver(Driver driver, Trip trip) {
        System.out.println("Trip is already assigned. To re-assign, cancel first.");
    }

    @Override
    public void startTrip(Trip trip) {
        trip.setTripState(new InProgressState());
    }

    @Override
    public void completeTrip(Trip trip) {
        System.out.println("Cannot end a trip that has not started.");
    }
}
