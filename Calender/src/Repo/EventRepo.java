package Repo;

import entity.Event;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class EventRepo {
    private Map<String, Event> eventMap = new ConcurrentHashMap<>();
    public void addEvent(Event event){
        eventMap.put(event.getEventId(),event);
    }
    public Event getEvent(String id){
        return eventMap.get(id);
    }
    public List<Event> getAllEvents(){
        List<Event>events = new ArrayList<>();
        for(Map.Entry<String,Event> entry: eventMap.entrySet()){
            events.add(entry.getValue());
        }
        return events;
    }
}
