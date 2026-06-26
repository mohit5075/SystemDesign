package entities;

import java.util.UUID;

public class Rider extends User{
    private String id;
    public Rider(String name, String email, Location location) {
        super(name, email, location);
        this.id = UUID.randomUUID().toString();
    }

    public String getId() {
        return id;
    }
}
