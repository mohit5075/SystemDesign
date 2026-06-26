package entities;

import observer.TripObserver;

import java.util.List;

public class User implements TripObserver {
    private String name;
    private String email;
    private Location location;
    private List<String> tripHistory;

    public User(String name, String email, Location location) {
        this.name = name;
        this.email = email;
        this.location = location;
    }

    @Override
    public void notify(Trip trip) {
        System.out.println("");
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }

    public void addTripTohistory(String id){
        tripHistory.add(id);
    }
    public List<String> getHistory(){
        return tripHistory;
    }
}
