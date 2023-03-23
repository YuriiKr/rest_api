package com.example.eventservicerest.service;

import java.util.List;
import java.util.Optional;
import com.example.eventservicedto.model.VehicleModel;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface VehicleService {

    void createVehicle(VehicleModel event);
    //    updateVehicle(…);
    Optional<VehicleModel> getVehicle(Long id);
    //    deleteEvent();
    List<VehicleModel> getAllVehicles();

    Page<VehicleModel> getAllVehiclesByName(String name, String model, Pageable page);
}
