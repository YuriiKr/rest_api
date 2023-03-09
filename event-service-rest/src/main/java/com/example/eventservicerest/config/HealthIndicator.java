package com.example.eventservicerest.config;

import org.springframework.boot.actuate.health.Health;
import org.springframework.stereotype.Component;

@Component
public class HealthIndicator implements org.springframework.boot.actuate.health.HealthIndicator {
    @Override
    public Health getHealth(boolean includeDetails) {
        return org.springframework.boot.actuate.health.HealthIndicator.super.getHealth(includeDetails);
    }

    @Override
    public Health health() {
        Health health = Health.down().build();
        return health;
    }
}
