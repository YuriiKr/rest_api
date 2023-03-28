package com.example.auction.service;

import java.time.Duration;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.stream.Collectors;
import com.example.auction.models.VehicleModel;
import lombok.Data;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Data
@Service
public class VehicleServiceImpl implements VehicleService {

    final String uri = "http://localhost:8080/vehicle/getAll";

    RestTemplate restTemplate = new RestTemplate();

    @Override
    public List<VehicleModel> getAllVehicles() {
        return Arrays.stream(Objects.requireNonNull(restTemplate.getForObject(uri, VehicleModel[].class))).toList();
    }
}
