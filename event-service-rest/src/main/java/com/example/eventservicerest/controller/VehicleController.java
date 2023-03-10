package com.example.eventservicerest.controller;

import java.util.List;
import java.util.Optional;
import com.example.eventservicerest.entities.Vehicle;
import com.example.eventservicerest.repository.VehicleRepository;
import com.example.eventservicerest.service.VehicleServiceImpl;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/vehicle")
public class VehicleController {

    private final VehicleServiceImpl vehicleServiceImpl;
    private final VehicleRepository vehicleRepository;

    public VehicleController(VehicleServiceImpl vehicleServiceImpl, VehicleRepository vehicleRepository) {
        this.vehicleServiceImpl = vehicleServiceImpl;
        this.vehicleRepository = vehicleRepository;
    }

    @PostMapping
    @RequestMapping("/create")
    public void createVehicle( @RequestBody Vehicle vehicle) {
        System.out.println("=========== >>>>> CREATE VEHICLE ++++");
        System.out.println("=========== >>>>> " + vehicle.toString());
        vehicleServiceImpl.createVehicle(vehicle);
    }

    @GetMapping
    @RequestMapping("/getById")
    public Optional<Vehicle> getVehicleById( @RequestBody Long id) {
        return vehicleServiceImpl.getVehicle(id);
    }

    @GetMapping
    @RequestMapping("/getAll")
    public List<Vehicle> getAllVehicles() {
        return vehicleServiceImpl.getAllVehicles();
    }

//    @EventListener(ApplicationReadyEvent.class)
//    public void test() {
//        vehicleRepository.findAll().forEach(System.out::println);
//    }

}
