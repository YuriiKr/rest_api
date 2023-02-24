package com.example.eventserviceapi.service;
import java.util.List;
import java.util.Optional;
import com.example.eventservicedto.dto.Event;


public interface EventService {

    void createEvent(Event event);
//    updateEvent(…);
    Optional<Event> getEvent(Long id);
    //    * deleteEvent();
    List<Event> getAllEvents();
//    getAllEventsByTitle(…).
}
