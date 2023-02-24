package com.example.eventserviceimpl.service;

import java.util.List;
import java.util.Optional;
import com.example.eventserviceapi.service.EventService;
import com.example.eventservicedto.dto.Event;
import com.example.eventserviceimpl.repository.EventStorage;
import lombok.AllArgsConstructor;

@AllArgsConstructor
public class EventServiceImpl implements EventService {

    private final EventStorage eventRepository;

    @Override
    public void createEvent(Event event) {
        eventRepository.save(event);
    }

    @Override
    public Optional<Event> getEvent(Long id) {
        return eventRepository.findById(id);
    }

    @Override
    public List<Event> getAllEvents() {
        return eventRepository.findAll();
    }


}
