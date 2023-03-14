package com.example.eventservicerest;


import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import com.example.eventservicedto.entities.Event;
import com.example.eventserviceimpl.service.EventServiceImpl;
import com.example.eventservicerest.repository.JPAEventStorage;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class EventServiceImplTest {

    @Mock
    private JPAEventStorage storage;

    private EventServiceImpl eventServiceImpl;

    @BeforeEach
    void setUp() {
        this.eventServiceImpl = new EventServiceImpl(storage);
    }

    @Test
    void getEventTypeInUppercaseTest() {
        final Event event = new Event();
        event.setEventType("Party");
        event.setId(1L);
        event.setTitle("Home Party");
        event.setPlace("Lviv");
        event.setSpeaker("Andrii");
        event.setDateTime(LocalDateTime.now());
        List<Event> listOfEvents = new ArrayList<>();
        listOfEvents.add(event);
        when(storage.findAll()).thenReturn(listOfEvents);
        List<Event> result = eventServiceImpl.getAllEvents();
        assertEquals("PARTY", result.get(0).getEventType());
        verify(storage).findAll();
    }
}
