package com.example.eventservicerest.controller;

import java.util.List;
import java.util.Optional;
import com.example.eventservicedto.entities.Vehicle;
import com.example.eventservicedto.model.VehicleModel;
import com.example.eventservicerest.repository.VehicleRepository;
import com.example.eventservicerest.service.VehicleServiceImpl;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
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
    public void createVehicle( @RequestBody VehicleModel vehicleModel) {
        vehicleServiceImpl.createVehicle(vehicleModel);
    }

    @GetMapping
    @RequestMapping("/getById/{id}")
    public Optional<VehicleModel> getVehicleById(@PathVariable(value="id")Long id) {
        return vehicleServiceImpl.getVehicle(id);
    }

    @GetMapping
    @RequestMapping("/getAll")
    public List<VehicleModel> getAllVehicles() {
        return vehicleServiceImpl.getAllVehicles();
    }

    @GetMapping
    @RequestMapping("/getAllByName")
    public Page<VehicleModel> getAllVehiclesByName(
            @RequestParam String manufacturer,
            @RequestParam String model,
            Pageable pageable) {

        return vehicleServiceImpl.getAllVehiclesByName(manufacturer, model, pageable);
    }

//    @EventListener(ApplicationReadyEvent.class)
//    public void test() {
//        vehicleRepository.findAll().forEach(System.out::println);
//    }

}
