package com.example.eventservicerest.converter;

import com.example.eventservicedto.entities.Vehicle;
import com.example.eventservicedto.model.VehicleModel;
import com.example.eventservicerest.repository.ShopRepository;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class VehicleModelToEntityConverter implements Converter<VehicleModel, Vehicle> {

    private final ShopRepository shopRepository;

    public VehicleModelToEntityConverter(ShopRepository shopRepository) {
        this.shopRepository = shopRepository;
    }

    @Override
    public Vehicle convert(VehicleModel source) {
        return new Vehicle(source.getId(), source.getType(), source.getModel(),
                shopRepository.findById(source.getShopId()).orElse(null));
    }
}
