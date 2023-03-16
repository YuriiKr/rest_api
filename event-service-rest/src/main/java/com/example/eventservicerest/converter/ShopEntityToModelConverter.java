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
public class ShopEntityToModelConverter implements Converter<Shop, ShopModel> {

    private final Converter<Vehicle, VehicleModel> vehicleEntityToModelConverter;

    public ShopEntityToModelConverter(Converter<Vehicle, VehicleModel> vehicleEntityToModelConverter) {
        this.vehicleEntityToModelConverter = vehicleEntityToModelConverter;
    }

    @Override
    public ShopModel convert(Shop source) {
        final List<VehicleModel> vehicleModels = source.getVehicle().stream()
                .map(vehicleEntityToModelConverter::convert)
                .collect(Collectors.toList());

        return new ShopModel(source.getId(), source.getName(), source.getAddress(), vehicleModels);
    }
}
