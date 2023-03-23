package com.example.eventservicerest.converter;

import com.example.eventservicedto.entities.Vehicle;
import com.example.eventservicedto.model.VehicleModel;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class VehicleEntityToModelConverter implements Converter<Vehicle, VehicleModel> {
    @Override
    public VehicleModel convert(Vehicle source) {
        return new VehicleModel(source.getId(), source.getType(), source.getModel(),
                source.getManufacturer(), source.getShop().getId());
    }
}
