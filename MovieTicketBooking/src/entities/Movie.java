package entities;

import java.util.UUID;

public class Movie {
    private String id;
    private String name;

    public Movie(String name) {
        this.id = UUID.randomUUID().toString();
        this.name = name;
    }

    public String getName() {
        return name;
    }
    public String getId() {
        return id;
    }
}
