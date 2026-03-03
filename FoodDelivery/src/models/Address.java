package models;

public class Address {
    private String street;
    private String city;
    private double latitude;
    private double longitude;
    private String zipCode;

    public Address(String street, String city, String zipCode, double latitude, double longitude) {
        this.street = street;
        this.city = city;
        this.zipCode = zipCode;
        this.latitude = latitude;
        this.longitude = longitude;
    }
    public String getStreet() {
        return street;
    }
    public String getCity() {
        return city;
    }
    public double getLatitude() {
        return latitude;
    }
    public double getLongitude() {
        return longitude;
    }
    public String getZipCode() {
        return zipCode;
    }
    public double distanceTo(Address other){
        double lat = this.latitude - other.latitude;
        double lon = this.longitude - other.longitude;
        return Math.sqrt(lat*lat + lon*lon);
    }
}
