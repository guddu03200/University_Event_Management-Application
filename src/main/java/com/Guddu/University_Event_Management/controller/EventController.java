package com.Guddu.University_Event_Management.controller;

import com.Guddu.University_Event_Management.model.Event;
import com.Guddu.University_Event_Management.service.EventService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@RestController
public class EventController {

    @Autowired
    EventService eventService;

    @PostMapping("event")
    public String addEvent(@RequestBody Event event){
        return eventService.addEvent(event);
    }


    @PostMapping("events")
    public String addEvents(@RequestBody List<Event> events){
        return eventService.addEvents(events);
    }


    @GetMapping("events")
    public Iterable<Event> getAllEvents(){
        return eventService.getAllEvents();
    }



    @GetMapping("event/{id}")
    public Optional<Event> getEventById(@PathVariable Integer id){

        return eventService.getEventById(id);
    }

    @GetMapping("event/date")
    public Iterable<Event> getEventByDate(@RequestParam LocalDate localDate){
        return eventService.getEventByDate(localDate);
    }


    @PutMapping("event/id/{id}/location/{eventLocation}")
    public String updateEventLocationById(@PathVariable Integer id, @PathVariable String eventLocation){
        return eventService.updateEventLoactionById(id, eventLocation);
    }

}
