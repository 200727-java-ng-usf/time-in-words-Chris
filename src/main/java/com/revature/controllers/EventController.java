package com.revature.controllers;

import com.revature.models.Event;
import com.revature.repositories.EventRepo;
import com.revature.services.EventServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/events")
public class EventController {

    private EventServices eventServices;

    @Autowired
    public EventController(EventServices eventServices) {
        this.eventServices = eventServices;
    }

    @GetMapping
    public List<Event> getAllEvents(){
        return eventServices.getAllEvents();
    }

    @GetMapping(value = "/{id}")
    public Event getEventById(@PathVariable Integer id){
        return eventServices.getEventById(id);
    }

    @PostMapping
    public Event registerNewEvent(@RequestBody Event newEvent){
        return eventServices.saveEvent(newEvent);
    }

    @PutMapping
    public Event updateEvent(@RequestBody Event updatedEvent){
        return eventServices.updateEvent(updatedEvent);
    }

    @DeleteMapping
    public void deleteEvent(@RequestBody Event event){
        eventServices.deleteEvent(event);
    }
}
