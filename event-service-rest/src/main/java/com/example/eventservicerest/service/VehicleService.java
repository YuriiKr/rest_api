package com.example.eventservicerest.service;

import java.util.List;
import java.util.Optional;
import com.example.eventservicedto.entities.Vehicle;
import com.example.eventservicedto.model.VehicleModel;

public interface VehicleService {

    void createVehicle(Vehicle event);
    //    updateVehicle(…);
    Optional<VehicleModel> getVehicle(Long id);
    //    deleteEvent();
    List<Vehicle> getAllVehicles();
}
