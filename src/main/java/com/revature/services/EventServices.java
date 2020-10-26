package com.revature.services;

import com.revature.exceptions.ResourceNotFoundException;
import com.revature.exceptions.ResourcePersistenceException;
import com.revature.models.Event;
import com.revature.repositories.EventRepo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Optional;


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

    public Event getEventById(Integer id) {

        Optional<Event> event = eventRepo.findById(id);
        if (!event.isPresent()) {
            throw new ResourceNotFoundException("No Event found with id: " + id);
        } else {
            return event.get();
        }
    }

    public Event saveEvent(Event event){
        LocalDateTime date = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("h:m");
        event.setTime(date.format(formatter));
        String time = event.getTime();
        event.setTime(timeReformatService.reformatTime(time));
        Optional<Event> testEvent = eventRepo.findById(event.getId());
        if (testEvent.isPresent()){
            throw new ResourcePersistenceException("Event with the same Id found in database, please enter a new id");
        }
        return eventRepo.save(event);
    }

    public Event updateEvent(Event updatedEvent) {
        Optional<Event> oldEvent = eventRepo.findById(updatedEvent.getId());
        if (!oldEvent.isPresent()) {
            throw new ResourceNotFoundException("Event with id: " + updatedEvent.getId() + " not found!");
        } else {
            updatedEvent.setTime(oldEvent.get().getTime());
            return eventRepo.save(updatedEvent);
        }
    }

    public void deleteEvent(Event event){
        eventRepo.delete(event);
    }

}
