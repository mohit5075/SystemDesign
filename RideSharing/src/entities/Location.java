package entities;

import java.util.Map;

public class Location {
    private int latitude;
    private int longitude;

    public Location(int latitude, int longitude) {
        this.latitude = latitude;
        this.longitude = longitude;
    }

    public int getLatitude() {
        return latitude;
    }

    public void setLatitude(int latitude) {
        this.latitude = latitude;
    }

    public int getLongitude() {
        return longitude;
    }

    public void setLongitude(int longitude) {
        this.longitude = longitude;
    }

    public int distance(Location to){
        return Math.abs(this.latitude-to.getLatitude())+Math.abs(this.longitude-to.getLongitude());
    }
}
