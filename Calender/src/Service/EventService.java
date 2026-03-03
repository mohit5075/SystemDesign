package Service;

import Repo.EventRepo;
import Repo.InviteRepo;
import entity.Event;
import entity.Invite;

import java.time.LocalDateTime;
import java.util.List;

public class EventService {
    private final EventRepo eventRepo;
    private final InviteRepo inviteRepo;
    public EventService(EventRepo eventRepo, InviteRepo inviteRepo) {
        this.eventRepo = eventRepo;
        this.inviteRepo = inviteRepo;
    }
    public void createEvent(String userId, LocalDateTime startTime, LocalDateTime endTime,String name,List<String> attendees){
        Event event = new Event(name,startTime,endTime,userId,attendees);
        eventRepo.addEvent(event);
        for(String attendeeId : attendees){
            Invite invite = new Invite(attendeeId,event.getEventId());
            inviteRepo.addInvite(invite);
        }
    }
    public List<Event> getEvents(String userId, LocalDateTime startTime, LocalDateTime endTime){
        return eventRepo.getAllEvents().stream().filter(e->(
            e.getAttendees().contains(userId) ||
            e.getOrganiserId().equalsIgnoreCase(userId) ||
            e.getStartTime().isBefore(endTime) ||
            e.getEndTime().isAfter(startTime)
        )).toList();
    }
}
