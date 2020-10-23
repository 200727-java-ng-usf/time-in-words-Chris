package com.revature.services;

import com.revature.models.Event;
import com.revature.repositories.EventRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class EventServices {

    private EventRepo eventRepo;
    private TimeReformatService timeReformatService;

    @Autowired
    public EventServices(EventRepo eventRepo, TimeReformatService timeReformatService) {
        this.eventRepo = eventRepo;
        this.timeReformatService = timeReformatService;
    }





    public List<Event> getAllEvents(){
        List<Event> eventList = (List<Event>) eventRepo.findAll();
        return eventList;
    }

    public Event getEventById(Integer id){

        Event event = eventRepo.findById(id).get();
        return event;
    }

    public Event saveEvent(Event event){
        String time = event.getTime();
        event.setTime(timeReformatService.reformatTime(time));
        return eventRepo.save(event);
    }

    public Event updateEvent(Event updatedEvent){
        return eventRepo.save(updatedEvent);
    }

    public void deleteEvent(Event event){
        eventRepo.delete(event);
    }

}
