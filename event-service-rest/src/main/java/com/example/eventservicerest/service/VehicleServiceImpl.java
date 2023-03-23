package com.example.eventservicerest.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import com.example.eventservicedto.entities.Shop;
import com.example.eventservicedto.entities.Vehicle;
import com.example.eventservicedto.model.VehicleModel;
import com.example.eventservicerest.repository.ShopRepository;
import com.example.eventservicerest.repository.VehicleRepository;
import lombok.Data;
import org.springframework.core.convert.converter.Converter;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Data
@Service
public class VehicleServiceImpl implements VehicleService{

    private final VehicleRepository vehicleRepository;
    private final ShopRepository shopRepository;
    private final Converter<Vehicle, VehicleModel> vehicleEntityToModelConverter;
    private final Converter<VehicleModel, Vehicle> vehicleModelToEntityConverter;


    public VehicleServiceImpl(VehicleRepository vehicleRepository, ShopRepository shopRepository,
            Converter<Vehicle, VehicleModel> vehicleConverter,
            Converter<VehicleModel, Vehicle> vehicleConverterToEntity) {
        this.vehicleRepository = vehicleRepository;
        this.shopRepository = shopRepository;
        this.vehicleEntityToModelConverter = vehicleConverter;
        this.vehicleModelToEntityConverter = vehicleConverterToEntity;
    }

    @Override
    public void createVehicle(VehicleModel vehicleModel) {
        Optional<Shop> shop = shopRepository.findById(vehicleModel.getShopId());
        vehicleModel.setShopId(shop.get().getId());
        vehicleRepository.save(vehicleModelToEntityConverter.convert(vehicleModel));
    }

    @Override
    public Optional<VehicleModel> getVehicle(Long id) {
        return vehicleRepository.findById(id).map(vehicleEntityToModelConverter::convert);
    }

    @Override
    public List<VehicleModel> getAllVehicles() {
        return vehicleRepository.findAll().stream()
                .map(vehicleEntityToModelConverter::convert)
                .collect(Collectors.toList());
    }

    @Override
    public Page<VehicleModel> getAllVehiclesByName(String manufacturer, String model, Pageable page) {
         var vehicleEntities = vehicleRepository.getVehicleByName(manufacturer, model, page)
                .stream()
                .map(vehicleEntityToModelConverter::convert)
                .collect(Collectors.toList());
        return new PageImpl<>(vehicleEntities);
    }
}
