package com.example.auction.controller;


import java.util.List;
import com.example.auction.models.VehicleModel;
import com.example.auction.service.VehicleServiceImpl;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auction")
public class AuctionController {

    private VehicleServiceImpl vehicleServiceImpl;

    public AuctionController(VehicleServiceImpl vehicleServiceImpl) {
        this.vehicleServiceImpl = vehicleServiceImpl;
    }

    //    @PostMapping
//    @RequestMapping("/create")
//    public void createVehicle( @RequestBody VehicleModel vehicleModel) {
//        vehicleServiceImpl.createVehicle(vehicleModel);
//    }
//
//    @GetMapping
//    @RequestMapping("/getById/{id}")
//    public Optional<VehicleModel> getVehicleById(@PathVariable(value="id")Long id) {
//        return vehicleServiceImpl.getVehicle(id);
//    }

    @GetMapping
    @RequestMapping("/getAllVehicles")
    public List<VehicleModel> getAllVehicles() {
        return vehicleServiceImpl.getAllVehicles();
    }

//    @EventListener(ApplicationReadyEvent.class)
//    public void test() {
//        vehicleRepository.findAll().forEach(System.out::println);
//    }

}
