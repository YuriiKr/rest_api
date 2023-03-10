package com.example.eventservicerest.service;

import java.util.List;
import java.util.Optional;
import com.example.eventservicerest.entities.Vehicle;

public interface VehicleService {

    void createVehicle(Vehicle event);
    //    updateVehicle(…);
    Optional<Vehicle> getVehicle(Long id);
    //    deleteEvent();
    List<Vehicle> getAllVehicles();
}
