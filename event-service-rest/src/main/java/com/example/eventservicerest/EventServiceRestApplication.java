package com.example.eventservicerest;

import com.example.eventservicedto.dto.Event;
import com.example.eventservicerest.entities.Vehicle;
import com.example.eventservicerest.token.Token;
import com.example.eventservicerest.user.User;
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
