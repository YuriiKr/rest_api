package com.example.eventservicerest.converter;

import java.util.stream.Collectors;
import com.example.eventservicedto.entities.Shop;
import com.example.eventservicedto.entities.Vehicle;
import com.example.eventservicedto.model.ShopModel;
import com.example.eventservicedto.model.VehicleModel;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class ShopEntityToModelConverter implements Converter<Shop, ShopModel> {

    private final Converter<Vehicle, VehicleModel> vehicleConverter;

    public ShopEntityToModelConverter(Converter<Vehicle, VehicleModel> vehicleConverter) {
        this.vehicleConverter = vehicleConverter;
    }

    @Override
    public ShopModel convert(Shop source) {
        final var vehicleModels = source.getVehicle().stream()
                .map(vehicleConverter::convert)
                .collect(Collectors.toList());
        return new ShopModel(source.getId(), source.getName(), source.getAddress(), vehicleModels);
    }
}
