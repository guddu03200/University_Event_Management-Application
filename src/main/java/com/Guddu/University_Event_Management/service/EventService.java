package com.Guddu.University_Event_Management.service;

import com.Guddu.University_Event_Management.model.Event;
import com.Guddu.University_Event_Management.repository.IEventRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
public class EventService {

    @Autowired
    IEventRepo iEventRepo;


    public String addEvent(Event event) {
        iEventRepo.save(event);

        return "New event added";
    }


    public String addEvents(List<Event> events) {
        iEventRepo.saveAll(events);

        return "New events added";
    }

    public Iterable<Event> getAllEvents() {
        return iEventRepo.findAll();
    }

    public Optional<Event> getEventById(Integer id) {
        return iEventRepo.findById(id);
    }

    public Iterable<Event> getEventByDate(LocalDate localDate) {
        return iEventRepo.findByEventDate(localDate);
    }

    public String updateEventLoactionById(Integer id, String eventLocation) {
        Optional<Event> optEvent = iEventRepo.findById(id);

        if(optEvent.isEmpty()){
            return "Event not found";
        }

        Event eve =  optEvent.get();
        eve.setLocationOfEvent(eventLocation);
        iEventRepo.save(eve);
        return "Location updated of event for event id :"+id;
    }
}
