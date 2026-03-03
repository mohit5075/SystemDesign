package entity;

import enums.InviteStatus;

import java.util.UUID;

public class Invite {
    private String id;
    private String userId;
    private String eventId;
    private InviteStatus inviteStatus;

    public Invite(String userId,String eventId) {
        this.id = UUID.randomUUID().toString();
        this.userId = userId;
        this.eventId = eventId;
        this.inviteStatus = InviteStatus.PENDING;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public InviteStatus getInviteStatus() {
        return inviteStatus;
    }

    public void setInviteStatus(InviteStatus inviteStatus) {
        this.inviteStatus = inviteStatus;
    }

    public String getEventId() {
        return eventId;
    }

    public void setEventId(String eventId) {
        this.eventId = eventId;
    }
}
