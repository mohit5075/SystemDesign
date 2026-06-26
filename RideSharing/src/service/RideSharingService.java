package service;

import entities.Driver;
import entities.Location;
import entities.Rider;
import entities.Trip;
import enums.DriverState;
import enums.TripStatus;
import enums.VehicleType;
import strategy.MatchingStrategy;
import strategy.PricingStrategy;

import java.util.List;
import java.util.Map;

public class RideSharingService {
    private Map<String, Driver> driverMap;
    private Map<String, Rider> riderMap;
    private Map<String, Trip> tripMap;
    private MatchingStrategy matchingStrategy;
    private PricingStrategy pricingStrategy;

    public RideSharingService(Map<String, Driver> driverMap, Map<String, Rider> riderMap, Map<String, Trip> tripMap, MatchingStrategy matchingStrategy, PricingStrategy pricingStrategy) {
        this.driverMap = driverMap;
        this.riderMap = riderMap;
        this.tripMap = tripMap;
        this.matchingStrategy = matchingStrategy;
        this.pricingStrategy = pricingStrategy;
    }
    public void registerDriver(String name, String email, Location location, VehicleType vehicleType){
        Driver driver = new Driver(name, email, location,vehicleType);
        driverMap.put(driver.getId(),driver);
    }
    public void registerRider(String name, String email, Location location){
        Rider rider = new Rider(name, email, location);
        riderMap.put(rider.getId(),rider);
    }
    public void requestTrip(Location src, Location dest,VehicleType vehicleType,String riderId){
        if(!riderMap.containsKey(riderId))return;
        List<Driver> drivers = matchingStrategy.getDrivers(List.of((Driver) driverMap.values()),src,dest,vehicleType);
        if(drivers.isEmpty())return;
        Driver driver = drivers.get(0);
        int price = pricingStrategy.price(src, dest, vehicleType);
        Trip trip = new Trip(driver.getId(),riderId,price,src,dest);
        tripMap.put(trip.getId(),trip);
    }
    public void assignDriver(String driverId,String tripId){
        if(!driverMap.containsKey(driverId))return;
        if(!tripMap.containsKey(tripId))return;
        Trip trip = tripMap.get(tripId);
        Driver driver = driverMap.get(driverId);
        trip.setDriverId(driverId);
        trip.getTripState().setDriver(driver,trip);
        driver.setDriverState(DriverState.BUSY);
    }
    public void startTrip(String tripId){
        Trip trip = tripMap.get(tripId);
        trip.setTripStatus(TripStatus.IN_PROGRESS);
        trip.startTrip();
    }
    public void endTrip(String tripId){
        Trip trip = tripMap.get(tripId);
        trip.setTripStatus(TripStatus.COMPLETED);
        trip.endTrip();
        Driver driver = driverMap.get(trip.getDriverId());
        driver.setDriverState(DriverState.AVAILABLE);
        driver.addTripTohistory(tripId);
        Rider rider = riderMap.get(trip.getRiderId());
        rider.addTripTohistory(tripId);
        rider.setLocation(trip.getDest());
        driver.setLocation(trip.getDest());
    }
}
