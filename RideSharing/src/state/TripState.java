package state;

import entities.Driver;
import entities.Trip;

public interface TripState {
    void request(Trip trip);
    void setDriver(Driver driver, Trip trip);
    void startTrip(Trip trip);
    void completeTrip(Trip trip);
}
