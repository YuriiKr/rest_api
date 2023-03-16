package com.example.eventservicerest;

import com.example.eventservicedto.entities.Event;
import com.example.eventserviceimpl.service.EventServiceImpl;
import static org.hamcrest.Matchers.containsString;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@SpringBootTest
@AutoConfigureMockMvc
public class EventServiceControllerTest {

//    @Autowired
//    private MockMvc mockMvc;
//
//    @MockBean
//    private EventServiceImpl eventServiceImpl;
//
//    @Test
//    void getAllEventsTest() throws Exception {
//        final Event event = new Event();
//        event.setEventType("Party");
//        event.setId(1L);
//        event.setTitle("Home Party");
//        event.setPlace("Lviv");
//        event.setSpeaker("Andrii");
//        event.setDateTime(LocalDateTime.now());
//        List<Event> listOfEvents = new ArrayList<>();
//        listOfEvents.add(event);
//        when(eventServiceImpl.getAllEvents()).thenReturn(listOfEvents);
//
//        this.mockMvc.perform(get("/event/getAll")).andExpect(status().isOk())
//                .andExpect(content().string(containsString("Home Party")));
//
//        verify(eventServiceImpl).getAllEvents();
//    }
}
