package entity;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

public class Event {
    private String eventId;
    private String name;
    private LocalDateTime startTime;
    private LocalDateTime endTime;
    private String organiserId;
    private List<String> attendees;

    public Event(String name, LocalDateTime startTime, LocalDateTime endTime, String organiserId, List<String> attendees) {
        this.eventId = UUID.randomUUID().toString();
        this.name = name;
        this.startTime = startTime;
        this.endTime = endTime;
        this.organiserId = organiserId;
        this.attendees = attendees;
    }

    public String getEventId() {
        return eventId;
    }

    public void setEventId(String eventId) {
        this.eventId = eventId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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

    public String getOrganiserId() {
        return organiserId;
    }

    public void setOrganiserId(String organiserId) {
        this.organiserId = organiserId;
    }

    public List<String> getAttendees() {
        return attendees;
    }

    public void setAttendees(List<String> attendees) {
        this.attendees = attendees;
    }
}
