package com.example.eventservicerest.service;

import java.util.List;
import java.util.Optional;
import com.example.eventservicedto.model.VehicleModel;

public interface VehicleService {

    void createVehicle(VehicleModel event);
    //    updateVehicle(…);
    Optional<VehicleModel> getVehicle(Long id);
    //    deleteEvent();
    List<VehicleModel> getAllVehicles();
}
