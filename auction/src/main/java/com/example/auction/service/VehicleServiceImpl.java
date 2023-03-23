package com.example.auction.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import com.example.auction.models.VehicleModel;
import lombok.Data;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Service;

@Data
@Service
public class VehicleServiceImpl implements VehicleService {


    @Override
    public List<VehicleModel> getAllVehicles() {

        return List.of();
    }
}
