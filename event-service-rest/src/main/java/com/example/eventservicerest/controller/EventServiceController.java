package com.example.eventservicerest.controller;

import java.util.List;
import java.util.Optional;
import com.example.eventservicedto.dto.Event;
import com.example.eventserviceimpl.service.EventServiceImpl;
import com.example.eventservicerest.user.UserRepository;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/event")
public class EventServiceController {

    private final EventServiceImpl eventServiceImpl;
    private final UserRepository userRepository;

    public EventServiceController(EventServiceImpl eventServiceImpl, UserRepository userRepository) {
        this.eventServiceImpl = eventServiceImpl;
        this.userRepository = userRepository;
    }

    @PostMapping
    @RequestMapping("/create")
    public void createEvent( @RequestBody Event event) {
        eventServiceImpl.createEvent(event);
    }

    @GetMapping
    @RequestMapping("/getById")
    public Optional<Event> getEventById( @RequestBody Long id) {
        return eventServiceImpl.getEvent(id);
    }

    @GetMapping
    @RequestMapping("/getAll")
    public List<Event> getAllEvents() {
        return eventServiceImpl.getAllEvents();
    }

    @EventListener(ApplicationReadyEvent.class)
    public void test() {

        userRepository.findAll().forEach(System.out::println);
    }


}
