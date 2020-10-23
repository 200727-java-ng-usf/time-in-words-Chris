package com.revature.services;

import com.revature.models.Event;
import com.revature.repositories.EventRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class EventServices {

    EventRepo eventRepo;


    @Autowired
    public EventServices(EventRepo eventRepo) {
        this.eventRepo = eventRepo;
    }



    public List<Event> getAllEvents(){
        List<Event> eventList = (List<Event>) eventRepo.findAll();
        return eventList;
    }

    public Event getEventById(Integer id){

        Event event = eventRepo.findById(id).get();
        return event;
    }


}
