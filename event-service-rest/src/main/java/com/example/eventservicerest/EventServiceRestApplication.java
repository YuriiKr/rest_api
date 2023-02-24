package com.example.eventservicerest;

import com.example.eventservicedto.dto.Event;
import com.example.eventservicerest.user.UserProfile;
import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories
@EntityScan(basePackageClasses = {Event.class, UserProfile.class})
//@OpenAPIDefinition(info = @Info(title = "Event API", version = "1.0", description = "Event Information"))
public class EventServiceRestApplication {

    public static void main(String[] args) {
        SpringApplication.run(EventServiceRestApplication.class, args);
    }

}
