package com.example.eventservicerest.service;

import java.util.List;
import java.util.Optional;
import com.example.eventservicerest.entities.Shop;
import com.example.eventservicerest.entities.Vehicle;
import com.example.eventservicerest.repository.ShopRepository;
import com.example.eventservicerest.repository.VehicleRepository;
import lombok.Data;
import org.springframework.stereotype.Service;

@Data
@Service
public class VehicleServiceImpl implements VehicleService{

    private final VehicleRepository vehicleRepository;
    private final ShopRepository shopRepository;


    public VehicleServiceImpl(VehicleRepository vehicleRepository, ShopRepository shopRepository) {
        this.vehicleRepository = vehicleRepository;
        this.shopRepository = shopRepository;
    }

    @Override
    public void createVehicle(Vehicle vehicle) {
        System.out.println("55555555555");
        Optional<Shop> shop = shopRepository.findByShopId(vehicle.getShop().getShopId());
        System.out.println("+++++++++++ SHOP: " + shop.toString());
        vehicle.setShop(shop.orElse(null));
        vehicleRepository.save(vehicle);
    }

    @Override
    public Optional<Vehicle> getVehicle(Long id) {
        return vehicleRepository.findById(id);
    }

    @Override
    public List<Vehicle> getAllVehicles() {
        return vehicleRepository.findAll();
    }
}
