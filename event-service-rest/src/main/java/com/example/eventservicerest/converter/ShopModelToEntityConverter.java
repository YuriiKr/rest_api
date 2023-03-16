package com.example.eventservicerest.converter;

import java.util.List;
import java.util.stream.Collectors;
import com.example.eventservicedto.entities.Shop;
import com.example.eventservicedto.entities.Vehicle;
import com.example.eventservicedto.model.ShopModel;
import com.example.eventservicedto.model.VehicleModel;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class ShopModelToEntityConverter implements Converter<ShopModel, Shop> {

    private final Converter<VehicleModel, Vehicle> vehicleModelToEntityConverter;

    public ShopModelToEntityConverter(Converter<VehicleModel, Vehicle> vehicleModelToEntityConverter) {
        this.vehicleModelToEntityConverter = vehicleModelToEntityConverter;
    }

    @Override
    public Shop convert(ShopModel source) {
        final List<Vehicle> vehicles = source.getVehicles().stream()
                .map(vehicleModelToEntityConverter::convert)
                .collect(Collectors.toList());

        return new Shop(source.getId(), source.getName(), source.getAddress(), vehicles);
    }
}
