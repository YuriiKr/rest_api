package com.example.eventserviceimpl.repository;

import java.util.List;
import java.util.Optional;
import com.example.eventservicedto.entities.Event;

public interface EventStorage {

    void save (Event event);
    Optional<Event> findById (Long id);
    List<Event> findAll ();

}

