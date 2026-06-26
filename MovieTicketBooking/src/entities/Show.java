package entities;

import java.time.LocalDateTime;
import java.util.Scanner;
import java.util.UUID;

public class Show {
    private String id;
    private LocalDateTime startTime;
    private LocalDateTime endTime;
    private Screen screen;
    private Theatre theatre;
    private Movie movie;

    public Show(LocalDateTime startTime, LocalDateTime endTime, Screen screen, Theatre theatre, Movie movie) {
        this.startTime = startTime;
        this.endTime = endTime;
        this.screen = screen;
        this.theatre = theatre;
        this.movie = movie;
        this.id = UUID.randomUUID().toString();
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public LocalDateTime getStartTime() {
        return startTime;
    }

    public void setStartTime(LocalDateTime startTime) {
        this.startTime = startTime;
    }

    public LocalDateTime getEndTime() {
        return endTime;
    }

    public void setEndTime(LocalDateTime endTime) {
        this.endTime = endTime;
    }

    public Screen getScreen() {
        return screen;
    }

    public void setScreen(Screen screen) {
        this.screen = screen;
    }

    public Theatre getTheatre() {
        return theatre;
    }

    public void setTheatre(Theatre theatre) {
        this.theatre = theatre;
    }

    public Movie getMovie() {
        return movie;
    }

    public void setMovie(Movie movie) {
        this.movie = movie;
    }
}
