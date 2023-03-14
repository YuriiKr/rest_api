package com.example.eventservicerest;

import com.example.eventservicedto.entities.Event;
import com.example.eventservicedto.entities.Vehicle;
import com.example.eventservicedto.entities.Token;
import com.example.eventservicedto.entities.User;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories
//@EntityScan(basePackageClasses = {Event.class, User.class})
@EntityScan(basePackageClasses = {Event.class, User.class, Token.class, Vehicle.class})
public class EventServiceRestApplication {

    public static void main(String[] args) {
        SpringApplication.run(EventServiceRestApplication.class, args);
    }

}
