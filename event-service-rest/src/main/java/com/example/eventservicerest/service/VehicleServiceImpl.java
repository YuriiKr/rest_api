package com.example.eventservicerest.service;

import java.util.List;
import java.util.Optional;
import com.example.eventservicedto.entities.Shop;
import com.example.eventservicedto.entities.Vehicle;
import com.example.eventservicedto.model.VehicleModel;
import com.example.eventservicerest.repository.ShopRepository;
import com.example.eventservicerest.repository.VehicleRepository;
import lombok.Data;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Service;

@Data
@Service
public class VehicleServiceImpl implements VehicleService{

    private final VehicleRepository vehicleRepository;
    private final ShopRepository shopRepository;
    private final Converter<Vehicle, VehicleModel> vehicleConverter;


    public VehicleServiceImpl(VehicleRepository vehicleRepository, ShopRepository shopRepository,
            Converter<Vehicle, VehicleModel> vehicleConverter) {
        this.vehicleRepository = vehicleRepository;
        this.shopRepository = shopRepository;
        this.vehicleConverter = vehicleConverter;
    }

    @Override
    public void createVehicle(Vehicle vehicle) {
        Optional<Shop> shop = shopRepository.findById(vehicle.getShop().getId());
        vehicle.setShop(shop.orElse(null));
        vehicleRepository.save(vehicle);
    }

    @Override
    public Optional<VehicleModel> getVehicle(Long id) {
        return vehicleRepository.findById(id).map(vehicleConverter::convert);
    }

    @Override
    public List<Vehicle> getAllVehicles() {
        return vehicleRepository.findAll();
    }
}
