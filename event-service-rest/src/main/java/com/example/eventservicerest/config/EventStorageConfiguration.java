package com.example.eventservicerest.config;

import com.example.eventservicedto.dto.Event;
import com.example.eventserviceimpl.repository.EventStorage;
import com.example.eventserviceimpl.service.EventServiceImpl;
import com.example.eventservicerest.repository.JPAEventStorage;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.JpaRepository;

@Configuration
public class EventStorageConfiguration {

    @Bean
    public EventStorage eventStorage(JpaRepository<Event, Long> repository) {
        return new JPAEventStorage(repository);
    }

    @Bean
    public EventServiceImpl serviceImpl(EventStorage eventStorage) {
        return new EventServiceImpl(eventStorage);
    }
}
