package com.example.eventservicerest.repository;

import java.util.List;
import java.util.Optional;
import com.example.eventservicedto.dto.Event;
import com.example.eventserviceimpl.repository.EventStorage;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;

@Component
public class JPAEventStorage implements EventStorage {

    private final JpaRepository<Event, Long> eventRepository;

    public JPAEventStorage(JpaRepository<Event, Long> eventRepository) {
        this.eventRepository = eventRepository;
    }

    @Override
    public void save(Event event) {
        eventRepository.save(event);
    }

    @Override
    public Optional<Event> findById(Long id) {
        return eventRepository.findById(id);
    }

    @Override
    public List<Event> findAll() {
        return eventRepository.findAll();
    }
}
