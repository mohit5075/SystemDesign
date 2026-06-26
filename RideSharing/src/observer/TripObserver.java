package observer;

import entities.Trip;

public interface TripObserver {
    void notify(Trip trip);
}
